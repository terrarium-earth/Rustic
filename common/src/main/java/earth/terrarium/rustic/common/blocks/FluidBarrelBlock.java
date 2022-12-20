package earth.terrarium.rustic.common.blocks;

import earth.terrarium.botarium.api.fluid.FluidHolder;
import earth.terrarium.botarium.api.fluid.FluidHooks;
import earth.terrarium.botarium.api.item.ItemStackHolder;
import earth.terrarium.rustic.common.blockentities.FluidBarrelBlockEntity;
import earth.terrarium.rustic.common.utils.ItemUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class FluidBarrelBlock extends BaseEntityBlock {

    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 16, 14);

    public FluidBarrelBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (level.getBlockEntity(pos) instanceof FluidBarrelBlockEntity barrel) {
            ItemStack held = stack.copy();
            held.setCount(1);
            ItemStackHolder holder = new ItemStackHolder(held);
            InteractionResult result = ItemUtils.pickupFluid(barrel, player, hand);
            if (result.consumesAction()) {
                return result;
            }
            FluidHolder fluid = FluidHooks.safeGetItemFluidManager(holder.getStack()).map(h -> h.getFluidInTank(0)).orElse(null);

            if (fluid != null && !fluid.isEmpty() && FluidHooks.moveItemToBlockFluid(holder, barrel, null, fluid) != 0) {
                if (holder.isDirty() && !player.getAbilities().instabuild) {
                    stack.shrink(1);
                    if (!player.addItem(holder.getStack())) {
                        player.drop(holder.getStack(), false);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void handlePrecipitation(BlockState state, Level level, BlockPos pos, Biome.Precipitation precipitation) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof FluidBarrelBlockEntity barrel && precipitation == Biome.Precipitation.RAIN) {
            Fluid fluid = barrel.getFluid().getFluid();
            if (fluid.isSame(Fluids.WATER) || fluid.isSame(Fluids.EMPTY)) {
                long amount = barrel.getFluidContainer().internalInsert(FluidHooks.newFluidHolder(Fluids.WATER, 100, null), false);
                if (amount != 0) {
                    barrel.update();
                }
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FluidBarrelBlockEntity(pos, state);
    }
}
