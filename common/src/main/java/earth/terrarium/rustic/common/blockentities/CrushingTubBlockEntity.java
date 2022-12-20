package earth.terrarium.rustic.common.blockentities;

import earth.terrarium.botarium.api.fluid.ExtractOnlyUpdatingFluidContainer;
import earth.terrarium.botarium.api.fluid.FluidHolder;
import earth.terrarium.botarium.api.fluid.FluidHoldingBlock;
import earth.terrarium.botarium.api.fluid.FluidHooks;
import earth.terrarium.rustic.common.recipes.CrushingRecipe;
import earth.terrarium.rustic.common.registry.ModBlockEntities;
import earth.terrarium.rustic.common.utils.ItemUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CrushingTubBlockEntity extends BlockEntity implements Container, FluidHoldingBlock {


    private final NonNullList<ItemStack> items;

    private ExtractOnlyUpdatingFluidContainer fluidContainer;
    private int presses;

    private CrushingRecipe recipe;

    public CrushingTubBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CRUSHING_TUB.get(), blockPos, blockState);
        this.items = NonNullList.withSize(1, ItemStack.EMPTY);
    }

    public FluidHolder getFluid() {
        return getFluidContainer().getFluids().get(0);
    }

    public void checkRecipes() {
        if (this.level == null) return;
        this.recipe = CrushingRecipe.getRecipe(this.level, new SimpleContainer(ItemUtils.copyWithCount(items.get(0), 1))).orElse(null);
        if (this.recipe != null) {
            FluidHolder holder = this.recipe.output();
            if (getFluidContainer().internalInsert(holder, true) != holder.getFluidAmount()) {
                this.recipe = null;
            }

        }
    }

    public void increment() {
        if (this.level == null) return;
        checkRecipes();
        if (recipe == null) {
            presses = 0;
        } else {
            presses++;
            if (presses >= recipe.presses()) {
                finishRecipe();
            }
        }
    }

    public void finishRecipe() {
        if (this.level == null) return;
        this.items.get(0).shrink(1);

        Block.popResourceFromFace(level, this.worldPosition, Direction.UP, recipe.result().copy());

        getFluidContainer().internalInsert(recipe.output().copyHolder(), false);
        this.recipe = null;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        ContainerHelper.loadAllItems(tag, this.items);
        this.presses = tag.getInt("presses");
    }

    @Override
    public void setLevel(Level level) {
        super.setLevel(level);
        checkRecipes();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.items);
        tag.putInt("presses", this.presses);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getItem(int slot) {
        return this.items.get(slot);
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        ItemStack stack = ContainerHelper.removeItem(this.items, slot, amount);
        update();
        return stack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        ItemStack stack = ContainerHelper.takeItem(this.items, slot);
        update();
        return stack;
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        this.items.set(slot, stack);
        update();
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        this.items.clear();
        update();
    }

    @Override
    public void update() {
        if (this.level == null) return;
        checkRecipes();
        this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
    }

    @Override
    public ExtractOnlyUpdatingFluidContainer getFluidContainer() {
        if (this.fluidContainer == null) {
            this.fluidContainer = new ExtractOnlyUpdatingFluidContainer(this, i -> FluidHooks.buckets(2), 1, (a, b) -> true);
        }
        return this.fluidContainer;
    }
}
