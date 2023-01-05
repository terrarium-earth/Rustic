package earth.terrarium.rustic.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.rustic.Rustic;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class ModFeatures {
    public static final ResourcefulRegistry<Feature<?>> FEATURES = ResourcefulRegistries.create(Registry.FEATURE, Rustic.MOD_ID);

    public static final RegistryEntry<Feature<TreeConfiguration>> IRONWOOD = FEATURES.register("ironwood", () -> new TreeFeature(TreeConfiguration.CODEC));
    public static final RegistryEntry<Feature<TreeConfiguration>> OLIVEWOOD = FEATURES.register("olivewood", () -> new TreeFeature(TreeConfiguration.CODEC));

    public static final ResourceKey<ConfiguredFeature<?, ?>> IRONWOOD_KEY = ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation(Rustic.MOD_ID, "ironwood"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> OLIVEWOOD_KEY = ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation(Rustic.MOD_ID, "olivewood"));
}