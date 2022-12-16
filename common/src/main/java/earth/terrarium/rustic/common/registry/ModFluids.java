package earth.terrarium.rustic.common.registry;

import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.rustic.Rustic;
import net.minecraft.core.Registry;
import net.minecraft.world.level.material.Fluid;

public class ModFluids {
    public static final RegistryHolder<Fluid> FLUIDS = new RegistryHolder<>(Registry.FLUID, Rustic.MOD_ID);

    public static void init() {
        FLUIDS.initialize();
    }
}