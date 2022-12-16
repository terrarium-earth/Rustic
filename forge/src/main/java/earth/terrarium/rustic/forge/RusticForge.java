package earth.terrarium.rustic.forge;

import earth.terrarium.rustic.Rustic;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Rustic.MOD_ID)
public class RusticForge {
    public RusticForge() {
        Rustic.init();
    }
}