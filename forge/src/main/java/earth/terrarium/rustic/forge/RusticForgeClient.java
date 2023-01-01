package earth.terrarium.rustic.forge;

import earth.terrarium.rustic.client.RusticClient;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RusticForgeClient {
    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(RusticForgeClient::onRegisterRenderers);
        bus.addListener(RusticForgeClient::onRegisterBlockColorHandlers);
        bus.addListener(RusticForgeClient::onRegisterItemColorHandlers);
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

    public static void onRegisterBlockColorHandlers(RegisterColorHandlersEvent.Block event) {
        RusticClient.onRegisterTints(block -> event.register((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(), block));
    }

    public static void onRegisterItemColorHandlers(RegisterColorHandlersEvent.Item event) {
        RusticClient.onRegisterTints(block -> event.register((itemStack, i) -> FoliageColor.getDefaultColor(), block));
    }
}
