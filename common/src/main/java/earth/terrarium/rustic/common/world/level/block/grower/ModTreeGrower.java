package earth.terrarium.rustic.common.world.level.block.grower;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
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
        level.setBlock(pos, blockState, 4);
        if (configuredFeature.place(level, generator, random, pos)) {
            if (level.getBlockState(pos) == blockState) {
                level.sendBlockUpdated(pos, state, blockState, 2);
            }

            return true;
        } else {
            level.setBlock(pos, state, 4);
            return false;
        }
    }
}