package earth.terrarium.rustic.client.forge;

import earth.terrarium.rustic.client.RusticClient;
import earth.terrarium.rustic.client.utils.ClientRegistrars;
import earth.terrarium.rustic.common.config.forge.ForgeMenuConfig;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RusticClientForge {
    public static void init() {
        ForgeMenuConfig.register();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(RusticClientForge::onRegisterRenderers);
        bus.addListener(RusticClientForge::onClientSetup);
        bus.addListener(RusticClientForge::onSetupItemColors);
        bus.addListener(RusticClientForge::onSetupBlockColors);
    }

    public static void postInit() {
        RusticClient.onRegisterFluidRenderTypes(RusticClientForge::onRegisterFluidRenderTypes);
    }

    private static void onRegisterFluidRenderTypes(RenderType type, Fluid fluid1, Fluid fluid2) {
        ItemBlockRenderTypes.setRenderLayer(fluid1, type);
        ItemBlockRenderTypes.setRenderLayer(fluid2, type);
    }

    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        RusticClient.registerBlockEntityRenderers();
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
        RusticClient.onRegisterMenuScreens(RusticClientForge::menuBridge);
        RusticClient.onRegisterItemProperties((items, id, properties) -> {
            for (ItemLike item : items) {
                ItemProperties.register(item.asItem(), id, properties);
            }
        });
    }

    public static void onSetupItemColors(RegisterColorHandlersEvent.Item event) {
        RusticClient.onAddItemColors(event::register);
    }

    public static void onSetupBlockColors(RegisterColorHandlersEvent.Block event) {
        RusticClient.onAddBlockColors(event::register);
    }

    // This is a bridge method because you cant use a lambda with a generic type
    private static <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void menuBridge(MenuType<? extends M> type, ClientRegistrars.ScreenConstructor<M, U> factory) {
        MenuScreens.register(type, factory::create);
    }
}
