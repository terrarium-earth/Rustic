package earth.terrarium.rustic.common.blocks.candle;

import com.google.common.collect.ImmutableList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.Map;

public class CandleStickHolderLeverBlock extends CandleStickHolderBlock {

    public static final Map<Direction, Iterable<Vec3>> PARTICLES_OFFSETS = Util.make(new EnumMap<>(Direction.class), map -> {
        map.put(Direction.NORTH,  ImmutableList.of(new Vec3(0.5, 1.0, 0.7)));
        map.put(Direction.SOUTH,  ImmutableList.of(new Vec3(0.5, 1.0, 0.3)));
        map.put(Direction.EAST,  ImmutableList.of(new Vec3(0.3, 1.0, 0.5)));
        map.put(Direction.WEST,  ImmutableList.of(new Vec3(0.7, 1.0, 0.5)));
    });

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public CandleStickHolderLeverBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(defaultBlockState().setValue(POWERED, false).setValue(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        final boolean isNone = state.getValue(COLOR) == CandleColor.NONE;
        final ItemStack stack = player.getItemInHand(hand);
        final Block block = Block.byItem(stack.getItem());
        if (isNone) {
            if (CandleColor.fromBlock(block) != null) {
                return super.use(state, level, pos, player, hand, hit);
            }
        } else if (player.isShiftKeyDown() || player.getItemInHand(hand).getItem() instanceof FlintAndSteelItem) {
            return super.use(state, level, pos, player, hand, hit);
        }
        this.press(state, level, pos);
        level.gameEvent(player, GameEvent.BLOCK_ACTIVATE, pos);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    protected Iterable<Vec3> getParticleOffsets(BlockState state) {
        return state.getValue(POWERED) ? PARTICLES_OFFSETS.get(state.getValue(FACING)) : super.getParticleOffsets(state);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!isMoving && !state.is(newState.getBlock())) {
            if (state.getValue(POWERED)) {
                this.updateNeighbours(state, level, pos);
            }

            super.onRemove(state, level, pos, newState, false);
        }
    }

    public void press(BlockState state, Level level, BlockPos pos) {
        level.setBlock(pos, state.setValue(POWERED, true), 3);
        this.updateNeighbours(state, level, pos);
        level.scheduleTick(pos, this, 30);
    }

    @Override
    public int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    @Override
    public int getDirectSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getValue(POWERED) && state.getValue(FACING).getOpposite() == direction || direction == Direction.DOWN ? 15 : 0;
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (state.getValue(POWERED)) {
            level.setBlock(pos, state.setValue(POWERED, false), 3);
            this.updateNeighbours(state, level, pos);
            level.gameEvent(null, GameEvent.BLOCK_DEACTIVATE, pos);
        }
    }

    private void updateNeighbours(BlockState state, Level level, BlockPos pos) {
        level.updateNeighborsAt(pos, this);
        level.updateNeighborsAt(pos.relative(state.getValue(FACING)), this);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED, FACING);
    }

}
