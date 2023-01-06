package earth.terrarium.rustic.fabric;

import earth.terrarium.rustic.Rustic;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.server.packs.PackType;

public class RusticFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Rustic.init();
        Rustic.onRegisterReloadListener((id, listener) ->
            ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new CustomReloadListener(id, listener))
        );
    }
}