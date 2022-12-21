package earth.terrarium.rustic.common.world.level.block.grower;

import earth.terrarium.rustic.common.registry.ModFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class IronwoodTreeGrower extends AbstractTreeGrower {
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean largeHive) {
        return BuiltinRegistries.CONFIGURED_FEATURE.getHolderOrThrow(ModFeatures.IRONWOOD_KEY);
    }
}
