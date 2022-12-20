package earth.terrarium.rustic.client;

import earth.terrarium.botarium.client.ClientHooks;
import earth.terrarium.rustic.client.renderers.CrushingTubRenderer;
import earth.terrarium.rustic.client.renderers.FluidBarrelRenderer;
import earth.terrarium.rustic.common.registry.ModBlockEntities;

public class RusticClient {

    public static void registerBlockEntityRenderers() {
        ClientHooks.registerBlockEntityRenderers(ModBlockEntities.CRUSHING_TUB.get(), CrushingTubRenderer::new);
        ClientHooks.registerBlockEntityRenderers(ModBlockEntities.FLUID_BARREL.get(), FluidBarrelRenderer::new);
    }
}
