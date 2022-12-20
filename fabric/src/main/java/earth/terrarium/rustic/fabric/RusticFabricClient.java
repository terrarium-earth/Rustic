package earth.terrarium.rustic.fabric;

import earth.terrarium.rustic.client.RusticClient;
import net.fabricmc.api.ClientModInitializer;

public class RusticFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RusticClient.registerBlockEntityRenderers();
    }
}
