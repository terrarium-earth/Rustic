package earth.terrarium.rustic.fabric;

import earth.terrarium.rustic.client.RusticClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class RusticFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RusticClient.registerBlockEntityRenderers();
        RusticClient.onRegisterFluidRenderTypes(RusticFabricClient::registerFluidRenderTypes);
        RusticClient.onRegisterTints(RusticFabricClient::onRegisterTints);
    }

    private static void registerFluidRenderTypes(RenderType type, Fluid fluid1, Fluid fluid2) {
        BlockRenderLayerMap.INSTANCE.putFluids(type, fluid1, fluid2);
    }

    private static void onRegisterTints(Block block) {
        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(), block);
        ColorProviderRegistry.ITEM.register((itemStack, i) -> FoliageColor.getDefaultColor(), block);
    }
}
