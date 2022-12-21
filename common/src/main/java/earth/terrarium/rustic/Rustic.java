package earth.terrarium.rustic;

import com.mojang.logging.LogUtils;
import earth.terrarium.rustic.common.registry.*;
import org.slf4j.Logger;

public class Rustic {
    public static final String MOD_ID = "rustic";
    public static final Logger LOGGER = LogUtils.getLogger();

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