package earth.terrarium.rustic.common.blocks;

import earth.terrarium.rustic.common.registry.ModBlocks;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class CrossBlock extends Block {

    public CrossBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Vec3 clickLocation = context.getClickLocation().subtract(Vec3.atLowerCornerOf(context.getClickedPos()));
        return switch (context.getHorizontalDirection()) {
            case NORTH -> (clickLocation.x > 0.5 ? ModBlocks.CLAY_DIAGONAL_RIGHT_CROSS_WALL : ModBlocks.CLAY_DIAGONAL_LEFT_CROSS_WALL).get().defaultBlockState();
            case EAST -> (clickLocation.z > 0.5 ? ModBlocks.CLAY_DIAGONAL_RIGHT_CROSS_WALL : ModBlocks.CLAY_DIAGONAL_LEFT_CROSS_WALL).get().defaultBlockState();
            case SOUTH -> (clickLocation.x > 0.5 ? ModBlocks.CLAY_DIAGONAL_LEFT_CROSS_WALL : ModBlocks.CLAY_DIAGONAL_RIGHT_CROSS_WALL).get().defaultBlockState();
            case WEST -> (clickLocation.z > 0.5 ? ModBlocks.CLAY_DIAGONAL_LEFT_CROSS_WALL : ModBlocks.CLAY_DIAGONAL_RIGHT_CROSS_WALL).get().defaultBlockState();
            default -> ModBlocks.CLAY_DIAGONAL_RIGHT_CROSS_WALL.get().defaultBlockState();
        };
    }
}
