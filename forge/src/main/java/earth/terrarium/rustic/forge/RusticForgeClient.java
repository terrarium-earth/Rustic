package earth.terrarium.rustic.forge;

import earth.terrarium.rustic.client.RusticClient;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RusticForgeClient {

    public static void init() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(RusticForgeClient::onRegisterRenderers);
    }

    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        RusticClient.registerBlockEntityRenderers();
    }
}
