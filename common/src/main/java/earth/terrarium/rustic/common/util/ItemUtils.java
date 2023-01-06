package earth.terrarium.rustic.common.utils;

import earth.terrarium.botarium.api.fluid.FluidHolder;
import earth.terrarium.botarium.api.fluid.FluidHooks;
import earth.terrarium.botarium.api.fluid.PlatformFluidHandler;
import earth.terrarium.botarium.api.item.ItemStackHolder;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.Optional;

public class ItemUtils {

    public static ItemStack copyWithCount(ItemStack stack, int count) {
        ItemStack copy = stack.copy();
        copy.setCount(count);
        return copy;
    }

    public static boolean addItem(Container container, int slot, ItemStack stack) {
        if (!stack.isEmpty()) {
            ItemStack item = container.getItem(slot);
            if (item.isEmpty()) {
                container.setItem(slot, stack);
                return true;
            } else if (ItemStack.isSameItemSameTags(item, stack) && item.getCount() + stack.getCount() <= item.getMaxStackSize()) {
                item.grow(Math.min(stack.getCount(), item.getMaxStackSize() - item.getCount()));
                return true;
            }
        }
        return false;
    }

    public static InteractionResult pickupFluid(BlockEntity block, Player player, InteractionHand hand) {
        Optional<PlatformFluidHandler> manager = FluidHooks.safeGetBlockFluidManager(block, null);
        FluidHolder fluid = manager.map(h -> h.getFluidInTank(0)).orElse(null);
        ItemStack stack = player.getItemInHand(hand);
        ItemStackHolder holder = new ItemStackHolder(copyWithCount(stack, 1));

        if (fluid != null && !fluid.isEmpty()) {
            if (FluidHooks.moveBlockToItemFluid(block, null, holder, fluid) != 0) {
                if (holder.isDirty()) {
                    stack.shrink(1);
                    if (!player.addItem(holder.getStack())) {
                        player.drop(holder.getStack(), false);
                    }
                    return InteractionResult.sidedSuccess(player.level.isClientSide);
                }
            } else if (stack.is(Items.BUCKET) && fluid.getFluidAmount() >= FluidHooks.buckets(1)) {
                PlatformFluidHandler handler = manager.get();
                FluidHolder newHolder = handler.extractFluid(FluidHooks.newFluidHolder(fluid.getFluid(), FluidHooks.buckets(1), fluid.getCompound()), false);
                if (!newHolder.isEmpty() && newHolder.getFluidAmount() == FluidHooks.buckets(1)) {
                    Item bucket = newHolder.getFluid().getBucket();
                    if (!Items.AIR.equals(bucket)) {
                        stack.shrink(1);
                        if (!player.addItem(new ItemStack(bucket))) {
                            player.drop(new ItemStack(bucket), false);
                        }
                        return InteractionResult.sidedSuccess(player.level.isClientSide);
                    }
                }
            }
        }
        return InteractionResult.PASS;
    }
}
