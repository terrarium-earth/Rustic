package earth.terrarium.rustic.common.blocks.candle;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CandleStickHolderBlock extends CandleHolderBlock {

    public static final Iterable<Vec3> PARTICLES_OFFSET = ImmutableList.of(new Vec3(0.5, 1, 0.5));
    public static final VoxelShape SHAPE_EMPTY = Block.box(6, 0.0, 6, 10, 8, 10);
    public static final VoxelShape SHAPE = Block.box(6, 0.0, 6, 10, 14, 10);

    public CandleStickHolderBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Iterable<Vec3> getParticleOffsets(BlockState state) {
        return PARTICLES_OFFSET;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(COLOR) == CandleColor.NONE ? SHAPE_EMPTY : SHAPE;
    }
}
