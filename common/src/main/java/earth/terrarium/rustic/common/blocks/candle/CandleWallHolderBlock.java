package earth.terrarium.rustic.common.blocks.candle;

import com.google.common.collect.ImmutableList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.Map;

public class CandleWallHolderBlock extends CandleHolderBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final Map<Direction, Iterable<Vec3>> PARTICLES_OFFSETS = Util.make(new EnumMap<>(Direction.class), map -> {
        map.put(Direction.NORTH,  ImmutableList.of(new Vec3(0.5, 1.0, 0.7)));
        map.put(Direction.SOUTH,  ImmutableList.of(new Vec3(0.5, 1.0, 0.3)));
        map.put(Direction.EAST,  ImmutableList.of(new Vec3(0.3, 1.0, 0.5)));
        map.put(Direction.WEST,  ImmutableList.of(new Vec3(0.7, 1.0, 0.5)));
    });

    public static final Map<Direction, VoxelShape> SHAPES_EMPTY = Util.make(new EnumMap<>(Direction.class), map -> {
        map.put(Direction.NORTH, Block.box(5.5, 1.0, 9.0, 10.5, 8.0, 16.0));
        map.put(Direction.SOUTH, Block.box(5.5, 1.0, 0.0, 10.5, 8.0, 7.0));
        map.put(Direction.WEST, Block.box(9.0, 1.0, 5.5, 16.0, 8.0, 10.5));
        map.put(Direction.EAST, Block.box(0.0, 1.0, 5.5, 7.0, 8.0, 10.5));
    });

    public static final Map<Direction, VoxelShape> SHAPES = Util.make(new EnumMap<>(Direction.class), map -> {
        map.put(Direction.NORTH, Block.box(5.5, 1.0, 9.0, 10.5, 14.0, 16.0));
        map.put(Direction.SOUTH, Block.box(5.5, 1.0, 0.0, 10.5, 14.0, 7.0));
        map.put(Direction.WEST, Block.box(9.0, 1.0, 5.5, 16.0, 14.0, 10.5));
        map.put(Direction.EAST, Block.box(0.0, 1.0, 5.5, 7.0, 14.0, 10.5));
    });

    public CandleWallHolderBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(COLOR) == CandleColor.NONE ? SHAPES_EMPTY.get(state.getValue(FACING)) : SHAPES.get(state.getValue(FACING));
    }

    @Override
    protected Iterable<Vec3> getParticleOffsets(BlockState state) {
        return PARTICLES_OFFSETS.getOrDefault(state.getValue(FACING), ImmutableList.of());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.relative(state.getValue(FACING).getOpposite())).getMaterial().isSolid();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = this.defaultBlockState();
        LevelReader level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        for (Direction direction : context.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                state = state.setValue(FACING, direction.getOpposite());
                if (state.canSurvive(level, pos)) {
                    return state;
                }
            }
        }
        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }
}
