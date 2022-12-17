package earth.terrarium.rustic.datagen;

import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.datagen.provider.client.ModBlockStateProvider;
import earth.terrarium.rustic.datagen.provider.client.ModItemModelProvider;
import earth.terrarium.rustic.datagen.provider.client.ModLangProvider;
import earth.terrarium.rustic.datagen.provider.server.ModBlockTagProvider;
import earth.terrarium.rustic.datagen.provider.server.ModItemTagProvider;
import earth.terrarium.rustic.datagen.provider.server.ModLootTableProvider;
import earth.terrarium.rustic.datagen.provider.server.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Rustic.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class RusticDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        System.out.println("Starting Rustic Datagen...");
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Client
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(generator, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModLangProvider(generator));

        // Server
        generator.addProvider(event.includeServer(), new ModLootTableProvider(generator));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(generator));
        ModBlockTagProvider blockTagProvider = new ModBlockTagProvider(generator, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagProvider);
        generator.addProvider(event.includeServer(), new ModItemTagProvider(generator, blockTagProvider, existingFileHelper));

        System.out.println("Finished Rustic Datagen");
    }
}
