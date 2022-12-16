package earth.terrarium.rustic;

import earth.terrarium.rustic.common.registry.ModBlockEntities;
import earth.terrarium.rustic.common.registry.ModBlocks;
import earth.terrarium.rustic.common.registry.ModFluids;
import earth.terrarium.rustic.common.registry.ModItems;

public class Rustic {
    public static final String MOD_ID = "rustic";

    public static void init() {
        ModFluids.init();
        ModBlocks.init();
        ModBlockEntities.init();
        ModItems.init();
    }
}