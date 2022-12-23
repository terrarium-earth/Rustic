package earth.terrarium.rustic.common.blockentities;

import earth.terrarium.botarium.api.fluid.FluidHoldingBlock;
import earth.terrarium.botarium.api.item.ItemContainerBlock;
import earth.terrarium.botarium.api.item.SimpleItemContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class FermentingBarrelBlockEntity extends BlockEntity implements FluidHoldingBlock, ItemContainerBlock {
    private IOFluidContainer fluidContainer;
    private SimpleItemContainer itemContainer;

    public FermentingBarrelBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    public void update() {

    }

    @Override
    public SimpleItemContainer getContainer() {
        if (itemContainer == null) {
            itemContainer = new SimpleItemContainer(this, 1);
        }
        return itemContainer;
    }

    @Override
    public IOFluidContainer getFluidContainer() {
        if (fluidContainer == null) {
            fluidContainer = new IOFluidContainer(this, 1000, (i, fluidHolder) -> true, (i, fluidHolder) -> true);
        }
        return fluidContainer;
    }
}
