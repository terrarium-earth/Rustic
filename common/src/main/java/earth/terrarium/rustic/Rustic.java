package earth.terrarium.rustic;

import com.mojang.logging.LogUtils;
import earth.terrarium.rustic.common.registry.*;
import earth.terrarium.rustic.common.util.PlatformUtils;
import org.slf4j.Logger;

public class Rustic {
    public static final String MOD_ID = "rustic";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        ModFluids.FLUIDS.initialize();
        ModFluidProperties.FLUID_PROPERTIES.initialize();
        ModBlocks.BLOCKS.initialize();
        ModBlockEntities.BLOCK_ENTITIES.initialize();
        ModItems.ITEMS.initialize();
        ModRecipeTypes.RECIPES.initialize();
        ModRecipeSerializers.SERIALIZERS.initialize();
        ModFeatures.FEATURES.initialize();
        ModEntityTypes.ENTITY_TYPES.initialize();
        ModMobEffects.MOB_EFFECTS.initialize();
    }

    public static void postInit() {
        PlatformUtils.registerStrippedLog(ModBlocks.IRONWOOD_LOG.get(), ModBlocks.STRIPPED_IRONWOOD_LOG.get());
        PlatformUtils.registerStrippedLog(ModBlocks.OLIVEWOOD_LOG.get(), ModBlocks.STRIPPED_OLIVEWOOD_LOG.get());
        ModBlockEntities.postInit();
    }
}