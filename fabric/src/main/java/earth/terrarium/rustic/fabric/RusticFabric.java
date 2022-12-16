package earth.terrarium.rustic.fabric;

import earth.terrarium.rustic.Rustic;
import net.fabricmc.api.ModInitializer;

public class RusticFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Rustic.init();
    }
}