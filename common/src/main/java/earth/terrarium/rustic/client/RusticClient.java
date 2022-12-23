package earth.terrarium.rustic.client;

import earth.terrarium.botarium.client.ClientHooks;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.client.renderers.CrushingTubRenderer;
import earth.terrarium.rustic.client.renderers.FluidBarrelRenderer;
import earth.terrarium.rustic.common.registry.ModBlockEntities;
import earth.terrarium.rustic.common.registry.ModBlocks;
import earth.terrarium.rustic.common.registry.ModFluids;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import org.apache.logging.log4j.util.TriConsumer;

import java.util.function.Consumer;

public class RusticClient {

    public static void registerBlockEntityRenderers() {
        ClientHooks.registerBlockEntityRenderers(ModBlockEntities.CRUSHING_TUB.get(), CrushingTubRenderer::new);
        ClientHooks.registerBlockEntityRenderers(ModBlockEntities.FLUID_BARREL.get(), FluidBarrelRenderer::new);
        ClientHooks.setRenderLayer(ModBlocks.IRONWOOD_LEAVES.get(), RenderType.translucent());
        ClientHooks.setRenderLayer(ModBlocks.OLIVEWOOD_LEAVES.get(), RenderType.translucent());
        ClientHooks.setRenderLayer(ModBlocks.IRONWOOD_SAPLING.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.OLIVEWOOD_SAPLING.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.IRONWOOD_DOOR.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.OLIVEWOOD_DOOR.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.IRONWOOD_TRAPDOOR.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.OLIVEWOOD_TRAPDOOR.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.GOLD_CHAIN.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.COPPER_CHAIN.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.GOLD_LANTERN.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.COPPER_LANTERN.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.GOLD_SOUL_LANTERN.get(), RenderType.cutout());
        ClientHooks.setRenderLayer(ModBlocks.COPPER_SOUL_LANTERN.get(), RenderType.cutout());

        Sheets.SIGN_MATERIALS.put(ModBlocks.IRONWOOD_SIGN_TYPE, new Material(Sheets.SIGN_SHEET, new ResourceLocation(Rustic.MOD_ID, "entity/signs/ironwood")));
        Sheets.SIGN_MATERIALS.put(ModBlocks.OLIVEWOOD_SIGN_TYPE, new Material(Sheets.SIGN_SHEET, new ResourceLocation(Rustic.MOD_ID, "entity/signs/olivewood")));
    }

    public static void onRegisterFluidRenderTypes(TriConsumer<RenderType, Fluid, Fluid> register) {
        register.accept(RenderType.translucent(), ModFluids.SWEET_BERRY_JUICE.get(), ModFluids.FLOWING_SWEET_BERRY_JUICE.get());
        register.accept(RenderType.translucent(), ModFluids.SWEET_BERRY_WINE.get(), ModFluids.FLOWING_SWEET_BERRY_WINE.get());
        register.accept(RenderType.translucent(), ModFluids.SUGAR_WATER.get(), ModFluids.FLOWING_SUGAR_WATER.get());
        register.accept(RenderType.translucent(), ModFluids.IRON_BERRY_JUICE.get(), ModFluids.FLOWING_IRON_BERRY_JUICE.get());
        register.accept(RenderType.translucent(), ModFluids.IRON_BERRY_WINE.get(), ModFluids.FLOWING_IRON_BERRY_WINE.get());
        register.accept(RenderType.translucent(), ModFluids.GRAPE_JUICE.get(), ModFluids.FLOWING_GRAPE_JUICE.get());
        register.accept(RenderType.translucent(), ModFluids.RED_WINE.get(), ModFluids.FLOWING_RED_WINE.get());
        register.accept(RenderType.translucent(), ModFluids.APPLE_JUICE.get(), ModFluids.FLOWING_APPLE_JUICE.get());
        register.accept(RenderType.translucent(), ModFluids.OLIVE_OIL.get(), ModFluids.FLOWING_OLIVE_OIL.get());
        register.accept(RenderType.translucent(), ModFluids.HONEY.get(), ModFluids.FLOWING_HONEY.get());
        register.accept(RenderType.translucent(), ModFluids.CIDER.get(), ModFluids.FLOWING_CIDER.get());
        register.accept(RenderType.translucent(), ModFluids.RUM.get(), ModFluids.FLOWING_RUM.get());
        register.accept(RenderType.translucent(), ModFluids.STARCHY_WATER.get(), ModFluids.FLOWING_STARCHY_WATER.get());
        register.accept(RenderType.translucent(), ModFluids.ALE.get(), ModFluids.FLOWING_ALE.get());
        register.accept(RenderType.translucent(), ModFluids.MEAD.get(), ModFluids.FLOWING_MEAD.get());
        register.accept(RenderType.translucent(), ModFluids.VODKA.get(), ModFluids.FLOWING_VODKA.get());
        register.accept(RenderType.translucent(), ModFluids.WHISKEY.get(), ModFluids.FLOWING_WHISKEY.get());
        register.accept(RenderType.translucent(), ModFluids.TOMATO_JUICE.get(), ModFluids.FLOWING_TOMATO_JUICE.get());
    }

    public static void onRegisterTints(Consumer<Block> register) {
        register.accept(ModBlocks.IRONWOOD_LEAVES.get());
        register.accept(ModBlocks.OLIVEWOOD_LEAVES.get());
    }
}