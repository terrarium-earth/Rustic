package earth.terrarium.rustic.common.blockentities;

import earth.terrarium.botarium.api.fluid.FluidHolder;
import earth.terrarium.botarium.api.fluid.FluidHoldingBlock;
import earth.terrarium.botarium.api.fluid.FluidHooks;
import earth.terrarium.botarium.api.fluid.SimpleUpdatingFluidContainer;
import earth.terrarium.rustic.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class FluidBarrelBlockEntity extends BlockEntity implements FluidHoldingBlock {

    private SimpleUpdatingFluidContainer fluidContainer;

    public FluidBarrelBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.FLUID_BARREL.get(), blockPos, blockState);
    }

    @Override
    public SimpleUpdatingFluidContainer getFluidContainer() {
        if (this.fluidContainer == null) {
            this.fluidContainer = new SimpleUpdatingFluidContainer(this, i -> FluidHooks.buckets(8), 1, (a, b) -> true);
        }
        return this.fluidContainer;
    }

    public FluidHolder getFluid() {
        return getFluidContainer().getFluids().get(0);
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
    public void update() {
        if (this.level == null) return;
        this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
    }
}
