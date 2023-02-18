package earth.terrarium.rustic.common.blocks.candle;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("deprecation")
public class CandleWallHolderLeverBlock extends CandleWallHolderBlock {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public static final Iterable<Vec3> PARTICLES_OFFSET = ImmutableList.of(new Vec3(0.5, 0.8, 0.5));

    public CandleWallHolderLeverBlock(Properties properties) {
        super(properties.lightLevel(LIGHT_EMISSION));
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(COLOR, CandleColor.NONE)
                .setValue(FACING, Direction.NORTH)
                .setValue(LIT, false)
                .setValue(POWERED, false)
        );
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
        return state.getValue(POWERED) ? PARTICLES_OFFSET : super.getParticleOffsets(state);
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
        return state.getValue(POWERED) && state.getValue(FACING) == direction ? 15 : 0;
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
        level.updateNeighborsAt(pos.relative(state.getValue(FACING).getOpposite()), this);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COLOR, FACING, LIT, POWERED);
    }
}
