package earth.terrarium.rustic.client.fabric;

import earth.terrarium.rustic.client.RusticClient;
import earth.terrarium.rustic.client.utils.ClientRegistrars;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class RusticClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RusticClient.init();
        RusticClient.registerBlockEntityRenderers();
        RusticClient.onRegisterFluidRenderTypes(RusticClientFabric::registerFluidRenderTypes);
        RusticClient.onRegisterTints(RusticClientFabric::onRegisterTints);
        RusticClient.onRegisterFluidRenderTypes(RusticFabricClient::registerFluidRenderTypes);
        RusticClient.onRegisterTints(RusticFabricClient::onRegisterTints);
        RusticClient.onRegisterMenuScreens(RusticFabricClient::menuBridge);
    }

    // This is a bridge method because you cant use a lambda with a generic type
    private static <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void menuBridge(MenuType<? extends M> type, ClientRegistrars.ScreenConstructor<M, U> factory) {
        MenuScreens.register(type, factory::create);
    }

    private static void registerFluidRenderTypes(RenderType type, Fluid fluid1, Fluid fluid2) {
        BlockRenderLayerMap.INSTANCE.putFluids(type, fluid1, fluid2);
    }

    private static void onRegisterTints(Block block) {
        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(), block);
        ColorProviderRegistry.ITEM.register((itemStack, i) -> FoliageColor.getDefaultColor(), block);
    }
}
