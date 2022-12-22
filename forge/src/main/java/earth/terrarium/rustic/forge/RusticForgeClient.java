package earth.terrarium.rustic.forge;

import earth.terrarium.rustic.client.RusticClient;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RusticForgeClient {

    public static void init() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(RusticForgeClient::onRegisterRenderers);
    }

    public static void postInit() {
        RusticClient.onRegisterFluidRenderTypes(RusticForgeClient::onRegisterFluidRenderTypes);
    }

    private static void onRegisterFluidRenderTypes(RenderType type, Fluid fluid1, Fluid fluid2) {
        ItemBlockRenderTypes.setRenderLayer(fluid1, type);
        ItemBlockRenderTypes.setRenderLayer(fluid2, type);
    }

    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        RusticClient.registerBlockEntityRenderers();
    }
}
