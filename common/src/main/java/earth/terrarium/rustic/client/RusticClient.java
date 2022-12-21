package earth.terrarium.rustic.client;

import earth.terrarium.botarium.client.ClientHooks;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.client.renderers.CrushingTubRenderer;
import earth.terrarium.rustic.client.renderers.FluidBarrelRenderer;
import earth.terrarium.rustic.common.registry.ModBlockEntities;
import earth.terrarium.rustic.common.registry.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

public class RusticClient {

    public static void registerBlockEntityRenderers() {
        ClientHooks.registerBlockEntityRenderers(ModBlockEntities.CRUSHING_TUB.get(), CrushingTubRenderer::new);
        ClientHooks.registerBlockEntityRenderers(ModBlockEntities.FLUID_BARREL.get(), FluidBarrelRenderer::new);
        ClientHooks.setRenderLayer(ModBlocks.IRONWOOD_LEAVES.get(), RenderType.translucent());
        ClientHooks.setRenderLayer(ModBlocks.OLIVEWOOD_LEAVES.get(), RenderType.translucent());
        ClientHooks.setRenderLayer(ModBlocks.IRONWOOD_SAPLING.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.OLIVEWOOD_SAPLING.get(), RenderType.cutout());

        Sheets.SIGN_MATERIALS.put(ModBlocks.IRONWOOD_SIGN_TYPE, new Material(Sheets.SIGN_SHEET, new ResourceLocation(Rustic.MOD_ID, "entity/signs/ironwood")));
        Sheets.SIGN_MATERIALS.put(ModBlocks.OLIVEWOOD_SIGN_TYPE, new Material(Sheets.SIGN_SHEET, new ResourceLocation(Rustic.MOD_ID, "entity/signs/olivewood")));
    }
}