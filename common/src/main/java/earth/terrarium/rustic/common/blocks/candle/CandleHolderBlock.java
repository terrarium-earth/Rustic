package earth.terrarium.rustic.common.blocks.candle;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.ToIntFunction;

public abstract class CandleHolderBlock extends AbstractCandleBlock {

    public static final EnumProperty<CandleColor> COLOR = EnumProperty.create("color", CandleColor.class);
    public static final ToIntFunction<BlockState> LIGHT_EMISSION = (state) -> state.getValue(LIT) ? 6 : 0;

    public CandleHolderBlock(Properties properties) {
        super(properties.lightLevel(LIGHT_EMISSION));
        this.registerDefaultState(this.stateDefinition.any().setValue(COLOR, CandleColor.NONE).setValue(LIT, false));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        final ItemStack item = player.getItemInHand(hand);
        final CandleColor color = state.getValue(COLOR);

        if (!player.getAbilities().mayBuild) {
            return InteractionResult.PASS;
        }

        if (color != CandleColor.NONE) {
            if (item.getItem() instanceof FlintAndSteelItem) {
                level.setBlock(pos, state.setValue(LIT, true), Block.UPDATE_ALL_IMMEDIATE);
                item.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else if (item.isEmpty() && state.getValue(LIT)) {
                extinguish(player, state, level, pos);
                return InteractionResult.sidedSuccess(level.isClientSide);
            }

            Block candle = color.getBlock();
            if (candle != null && (player.isShiftKeyDown() || player.getItemInHand(hand).isEmpty())) {
                level.setBlockAndUpdate(pos, state.setValue(COLOR, CandleColor.NONE));
                ItemStack drop = new ItemStack(candle);
                if (!player.addItem(drop)) {
                    player.drop(drop, false);
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        } else {
            Block block = Block.byItem(item.getItem());
            if (block instanceof CandleBlock) {
                CandleColor candleColor = CandleColor.fromBlock(block);
                if (candleColor != null) {
                    level.setBlockAndUpdate(pos, state.setValue(COLOR, candleColor));
                    if (!player.isCreative()) {
                        item.shrink(1);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
        }
        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COLOR, LIT);
    }
}
