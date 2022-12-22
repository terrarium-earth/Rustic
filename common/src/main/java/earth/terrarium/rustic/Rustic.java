package earth.terrarium.rustic;

import com.mojang.logging.LogUtils;
import earth.terrarium.rustic.common.registry.*;
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
    }

    public static void postInit() {
        ModBlockEntities.postInit();
    }
}