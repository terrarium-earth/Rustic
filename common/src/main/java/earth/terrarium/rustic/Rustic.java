package earth.terrarium.rustic;

import com.mojang.logging.LogUtils;
import com.teamresourceful.resourcefulconfig.common.config.Configurator;
import earth.terrarium.rustic.common.config.RusticConfig;
import earth.terrarium.rustic.common.registry.*;
import earth.terrarium.rustic.common.util.PlatformUtils;
import org.slf4j.Logger;

public class Rustic {
    public static final String MOD_ID = "rustic";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final Configurator CONFIGURATOR = new Configurator();

    public static void init() {
        CONFIGURATOR.registerConfig(RusticConfig.class);

        ModFluids.FLUIDS.init();
        ModFluidProperties.FLUID_PROPERTIES.initialize();
        ModBlocks.BLOCKS.init();
        ModBlockEntities.BLOCK_ENTITY_TYPES.init();
        ModItems.ITEMS.init();
        ModRecipeTypes.RECIPE_TYPES.init();
        ModRecipeSerializers.RECIPE_SERIALIZERS.init();
        ModFeatures.FEATURES.init();
        ModEntityTypes.ENTITY_TYPES.init();
        ModMobEffects.MOB_EFFECTS.init();
    }

    public static void postInit() {
        PlatformUtils.registerStrippedLog(ModBlocks.IRONWOOD_LOG.get(), ModBlocks.STRIPPED_IRONWOOD_LOG.get());
        PlatformUtils.registerStrippedLog(ModBlocks.OLIVEWOOD_LOG.get(), ModBlocks.STRIPPED_OLIVEWOOD_LOG.get());
        ModBlockEntities.postInit();
    }
}