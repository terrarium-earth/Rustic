package earth.terrarium.rustic.common.blocks;

import earth.terrarium.rustic.common.blockentities.CrushingTubBlockEntity;
import earth.terrarium.rustic.common.recipes.CrushingRecipe;
import earth.terrarium.rustic.common.utils.ItemUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CrushingTubBlock extends BaseEntityBlock {

    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(0, 0, 0, 16, 3.5, 16),
            Shapes.join(
                    Block.box(1, 3.5, 1, 15, 10, 15),
                    Block.box(0, 3.5, 0, 16, 10, 16),
                    BooleanOp.NOT_SAME
            )
    );

    private static final VoxelShape VISUAL_SHAPE = Shapes.or(
            Block.box(0, 0, 0, 16, 1, 16),
            Shapes.join(
                    Block.box(1, 0, 1, 15, 10, 15),
                    Block.box(0, 0, 0, 16, 10, 16),
                    BooleanOp.NOT_SAME
            )
    );

    public CrushingTubBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return VISUAL_SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);

        if (level.getBlockEntity(pos) instanceof CrushingTubBlockEntity tub) {
            InteractionResult result = ItemUtils.pickupFluid(tub, player, hand);
            if (result.consumesAction()) {
                return result;
            }

            if (tub.getItem(0).isEmpty()) {
                Optional<CrushingRecipe> recipe = CrushingRecipe.getRecipe(level, new SimpleContainer(stack));
                if (recipe.isPresent()) {
                    ItemStack added = stack.copy();
                    tub.setItem(0, added);
                    stack.shrink(added.getCount());
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            } else if (ItemStack.isSameItemSameTags(stack, tub.getItem(0))) {
                int count = Math.min(stack.getCount(), tub.getItem(0).getMaxStackSize() - tub.getItem(0).getCount());
                tub.getItem(0).grow(count);
                stack.shrink(count);
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else if (stack.isEmpty()) {
                player.addItem(tub.removeItemNoUpdate(0));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (level.getBlockEntity(pos) instanceof CrushingTubBlockEntity tub) {
            tub.increment();
        }
        super.fallOn(level, state, pos, entity, fallDistance);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CrushingTubBlockEntity(pos, state);
    }
}
