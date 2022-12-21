package earth.terrarium.rustic;

import earth.terrarium.rustic.common.registry.*;

public class Rustic {
    public static final String MOD_ID = "rustic";

    public static void init() {
        ModFluids.init();
        ModBlocks.init();
        ModBlockEntities.init();
        ModItems.init();
        ModRecipeTypes.init();
        ModRecipeSerializers.init();
        ModFeatures.init();
    }

    public static void postInit() {
        ModBlockEntities.postInit();
    }
}