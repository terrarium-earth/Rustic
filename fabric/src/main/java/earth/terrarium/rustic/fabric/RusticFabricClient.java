package earth.terrarium.rustic.fabric;

import earth.terrarium.rustic.client.RusticClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.Fluid;

public class RusticFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RusticClient.registerBlockEntityRenderers();
        RusticClient.onRegisterFluidRenderTypes(RusticFabricClient::registerFluidRenderTypes);
    }

    private static void registerFluidRenderTypes(RenderType type, Fluid fluid1, Fluid fluid2) {
        BlockRenderLayerMap.INSTANCE.putFluids(type, fluid1, fluid2);
    }
}
