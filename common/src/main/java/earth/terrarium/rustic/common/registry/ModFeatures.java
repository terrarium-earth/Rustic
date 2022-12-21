package earth.terrarium.rustic.common.registry;

import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.rustic.Rustic;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import java.util.function.Supplier;

public class ModFeatures {
    public static final RegistryHolder<Feature<?>> FEATURES = new RegistryHolder<>(Registry.FEATURE, Rustic.MOD_ID);

    public static final Supplier<Feature<TreeConfiguration>> IRONWOOD = FEATURES.register("ironwood", () -> new TreeFeature(TreeConfiguration.CODEC));
    public static final Supplier<Feature<TreeConfiguration>> OLIVEWOOD = FEATURES.register("olivewood", () -> new TreeFeature(TreeConfiguration.CODEC));

    public static final ResourceKey<ConfiguredFeature<?, ?>> IRONWOOD_KEY = ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation(Rustic.MOD_ID, "ironwood"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> OLIVEWOOD_KEY = ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation(Rustic.MOD_ID, "olivewood"));

    public static void init() {
        FEATURES.initialize();
    }
}