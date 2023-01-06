package earth.terrarium.rustic.client.fabric;

import earth.terrarium.rustic.client.RusticClient;
import earth.terrarium.rustic.client.utils.ClientRegistrars;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;

public class RusticClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RusticClient.init();
        RusticClient.registerBlockEntityRenderers();
        RusticClient.onRegisterFluidRenderTypes(RusticClientFabric::registerFluidRenderTypes);
        RusticClient.onRegisterFluidRenderTypes(RusticClientFabric::registerFluidRenderTypes);
        RusticClient.onRegisterMenuScreens(RusticClientFabric::menuBridge);
        RusticClient.onAddItemColors(ColorProviderRegistry.ITEM::register);
        RusticClient.onAddBlockColors(ColorProviderRegistry.BLOCK::register);
        RusticClient.onRegisterItemProperties((items, id, property) -> {
            for (ItemLike item : items) {
                ItemProperties.register(item.asItem(), id, property);
            }
        });
    }

    // This is a bridge method because you cant use a lambda with a generic type
    private static <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void menuBridge(MenuType<? extends M> type, ClientRegistrars.ScreenConstructor<M, U> factory) {
        MenuScreens.register(type, factory::create);
    }

    private static void registerFluidRenderTypes(RenderType type, Fluid fluid1, Fluid fluid2) {
        BlockRenderLayerMap.INSTANCE.putFluids(type, fluid1, fluid2);
    }
}
