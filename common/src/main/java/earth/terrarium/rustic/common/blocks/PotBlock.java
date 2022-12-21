package earth.terrarium.rustic.common.blocks;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class PotBlock extends Block {
    public static final VoxelShape SHAPE = Stream.of(
            Block.box(2, 0, 2, 14, 11, 14),
            Block.box(4, 14, 4, 12, 16, 12),
            Block.box(5, 11, 5, 11, 14, 11)
    ).reduce(Shapes::or).get();

    public PotBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
