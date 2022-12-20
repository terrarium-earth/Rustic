package earth.terrarium.rustic.forge;

import earth.terrarium.rustic.Rustic;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(Rustic.MOD_ID)
public class RusticForge {
    public RusticForge() {
        Rustic.init();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> RusticForgeClient::init);
    }
}