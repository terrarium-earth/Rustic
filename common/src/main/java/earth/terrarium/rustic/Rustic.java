package earth.terrarium.rustic;

import com.mojang.logging.LogUtils;
import earth.terrarium.rustic.common.recipes.InternalRecipeBuilder;
import earth.terrarium.rustic.common.registry.*;
import earth.terrarium.rustic.common.util.PlatformUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import org.slf4j.Logger;

import java.util.function.BiConsumer;

public class Rustic {
    public static final String MOD_ID = "rustic";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        ModFluids.FLUIDS.initialize();
        ModFluidProperties.FLUID_PROPERTIES.initialize();
        ModBlocks.BLOCKS.initialize();
        ModBlockEntities.BLOCK_ENTITIES.initialize();
        ModItems.ITEMS.initialize();
        ModRecipeTypes.RECIPES.initialize();
        ModRecipeSerializers.SERIALIZERS.initialize();
        ModFeatures.FEATURES.initialize();
    }

    public static void postInit() {
        PlatformUtils.registerStrippedLog(ModBlocks.IRONWOOD_LOG.get(), ModBlocks.STRIPPED_IRONWOOD_LOG.get());
        PlatformUtils.registerStrippedLog(ModBlocks.OLIVEWOOD_LOG.get(), ModBlocks.STRIPPED_OLIVEWOOD_LOG.get());
        ModBlockEntities.postInit();
    }

    public static void onRegisterReloadListener(BiConsumer<ResourceLocation, ResourceManagerReloadListener> consumer) {
        consumer.accept(new ResourceLocation(Rustic.MOD_ID, "internal_recipes"), InternalRecipeBuilder.getInstance());
    }
}