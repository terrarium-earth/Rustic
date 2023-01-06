package earth.terrarium.rustic.common.blocks;

import earth.terrarium.botarium.api.fluid.FluidHolder;
import earth.terrarium.botarium.api.fluid.FluidHooks;
import earth.terrarium.botarium.api.item.ItemStackHolder;
import earth.terrarium.botarium.api.menu.MenuHooks;
import earth.terrarium.rustic.common.blockentities.AlchemicCondenserBlockEntity;
import earth.terrarium.rustic.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class AlchemicCondenserBlock extends BaseEntityBlock {

    public AlchemicCondenserBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (level.getBlockEntity(pos) instanceof AlchemicCondenserBlockEntity barrel) {
            ItemStack held = stack.copy();
            held.setCount(1);
            ItemStackHolder holder = new ItemStackHolder(held);
            FluidHolder fluid = FluidHooks.safeGetItemFluidManager(holder.getStack()).map(h -> h.getFluidInTank(0)).orElse(null);

            if (fluid != null && !fluid.isEmpty() && FluidHooks.moveItemToBlockFluid(holder, barrel, null, fluid) != 0) {
                if (holder.isDirty() && !player.getAbilities().instabuild) {
                    stack.shrink(1);
                    if (!player.addItem(holder.getStack())) {
                        player.drop(holder.getStack(), false);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            } else if (player instanceof ServerPlayer serverPlayer) {
                MenuHooks.openMenu(serverPlayer, barrel);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? null : createTickerHelper(blockEntityType, ModBlockEntities.ALCHEMIC_CONDENSER.get(), AlchemicCondenserBlockEntity::tick);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AlchemicCondenserBlockEntity(pos, state);
    }
}
