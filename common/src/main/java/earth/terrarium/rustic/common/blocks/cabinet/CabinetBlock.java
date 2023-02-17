package earth.terrarium.rustic.common.blocks.cabinet;

import earth.terrarium.rustic.common.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CabinetBlock extends BaseEntityBlock {

    public static final EnumProperty<CabinetType> TYPE = EnumProperty.create("type", CabinetType.class);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final DoubleBlockCombiner.Combiner<CabinetBlockEntity, Optional<MenuProvider>> MENU_PROVIDER_COMBINER = new DoubleBlockCombiner.Combiner<>() {
        public Optional<MenuProvider> acceptDouble(final CabinetBlockEntity first, final CabinetBlockEntity second) {
            final Container container = new CompoundContainer(first, second);
            return Optional.of(new MenuProvider() {
                @Nullable
                @Override
                public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
                    if (first.canOpen(player) && second.canOpen(player)) {
                        first.unpackLootTable(inventory.player);
                        second.unpackLootTable(inventory.player);
                        return ChestMenu.sixRows(i, inventory, container);
                    }
                    return null;
                }

                @Override
                public Component getDisplayName() {
                    if (first.hasCustomName()) {
                        return first.getDisplayName();
                    }
                    return second.hasCustomName() ? second.getDisplayName() : CommonComponents.EMPTY;
                }
            });
        }

        public Optional<MenuProvider> acceptSingle(CabinetBlockEntity cabinet) {
            return Optional.of(cabinet);
        }

        public Optional<MenuProvider> acceptNone() {
            return Optional.empty();
        }
    };

    public CabinetBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(TYPE, CabinetType.SINGLE).setValue(FACING, Direction.NORTH));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getItemInHand(hand).getItem() instanceof BlockItem blockItem && blockItem.getBlock() == this) {
            return InteractionResult.PASS;
        }
        if (player.isShiftKeyDown()) {
            return InteractionResult.PASS;
        }
        MenuProvider menuProvider = this.getMenuProvider(state, level, pos);
        if (menuProvider != null) {
            player.openMenu(menuProvider);
        }

        return InteractionResult.CONSUME;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        if (context.getPlayer() == null || context.getPlayer().isShiftKeyDown()) {
            return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(TYPE, CabinetType.SINGLE);
        }
        final BlockPos pos = context.getClickedPos();
        final BlockState above = level.getBlockState(pos.above());
        final BlockState below = level.getBlockState(pos.below());
        if (above.is(this) && above.getValue(TYPE) == CabinetType.SINGLE && above.getValue(FACING) == context.getHorizontalDirection().getOpposite()) {
            level.setBlockAndUpdate(pos.above(), above.setValue(TYPE, CabinetType.TOP));
            return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(TYPE, CabinetType.BOTTOM);
        } else if (below.is(this) && below.getValue(TYPE) == CabinetType.SINGLE && below.getValue(FACING) == context.getHorizontalDirection()) {
            level.setBlockAndUpdate(pos.below(), below.setValue(TYPE, CabinetType.BOTTOM));
            return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(TYPE, CabinetType.TOP);
        }
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(TYPE, CabinetType.SINGLE);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (state.getValue(TYPE) == CabinetType.SINGLE) {
            return;
        }
        final BlockState other = level.getBlockState(state.getValue(TYPE) == CabinetType.TOP ? pos.below() : pos.above());
        if (!other.is(this) || other.getValue(FACING) != state.getValue(FACING)) {
            level.setBlock(pos, state.setValue(TYPE, CabinetType.SINGLE), Block.UPDATE_ALL);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, FACING);
    }

    @Nullable
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return this.combine(state, level, pos).apply(MENU_PROVIDER_COMBINER).orElse(null);
    }

    public DoubleBlockCombiner.NeighborCombineResult<? extends CabinetBlockEntity> combine(BlockState state, Level level, BlockPos pos) {
        return DoubleBlockCombiner.combineWithNeigbour(ModBlockEntities.CABINET.get(),
                CabinetBlock::getBlockType,
                CabinetBlock::getConnectedDirection, FACING, state, level, pos, ($1, $2) -> false);
    }

    public static DoubleBlockCombiner.BlockType getBlockType(BlockState state) {
        CabinetType type = state.getValue(TYPE);
        if (type == CabinetType.SINGLE) {
            return DoubleBlockCombiner.BlockType.SINGLE;
        }
        return type == CabinetType.BOTTOM ? DoubleBlockCombiner.BlockType.SECOND : DoubleBlockCombiner.BlockType.FIRST;
    }

    public static Direction getConnectedDirection(BlockState state) {
        return state.getValue(TYPE) == CabinetType.TOP ? Direction.DOWN : Direction.UP;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CabinetBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            if (level.getBlockEntity(pos) instanceof Container container) {
                Containers.dropContents(level, pos, container);
                level.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }
    }
}
