package earth.terrarium.rustic.common.world.grower;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ModTreeGrower extends AbstractTreeGrower {
    private final ResourceKey<ConfiguredFeature<?, ?>> key;

    public ModTreeGrower(ResourceKey<ConfiguredFeature<?, ?>> key) {
        this.key = key;
    }
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean largeHive) {
        return null;
    }

    @Override
    public boolean growTree(ServerLevel level, ChunkGenerator generator, BlockPos pos, BlockState state, RandomSource random) {
        Holder<? extends ConfiguredFeature<?, ?>> holder = level.registryAccess().registryOrThrow(Registry.CONFIGURED_FEATURE_REGISTRY).getHolderOrThrow(this.key);
        ConfiguredFeature<?, ?> configuredFeature = holder.value();
        BlockState blockState = level.getFluidState(pos).createLegacyBlock();
        level.setBlock(pos, blockState, Block.UPDATE_INVISIBLE);
        if (configuredFeature.place(level, generator, random, pos)) {
            if (level.getBlockState(pos) == blockState) {
                level.sendBlockUpdated(pos, state, blockState, Block.UPDATE_CLIENTS);
            }

            return true;
        } else {
            level.setBlock(pos, state, Block.UPDATE_INVISIBLE);
            return false;
        }
    }
}