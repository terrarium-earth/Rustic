package earth.terrarium.rustic.forge;

import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.recipes.InternalRecipeBuilder;
import earth.terrarium.rustic.client.RusticClient;
import earth.terrarium.rustic.client.forge.RusticClientForge;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Rustic.MOD_ID)
public class RusticForge {
    public RusticForge() {
        Rustic.init();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> RusticClientForge::init);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(RusticForge::onClientSetup);
        bus.addListener(RusticForge::commonSetup);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, RusticForge::onAddReloadListeners);
    }

    public static void commonSetup(FMLCommonSetupEvent event) {
        Rustic.postInit();
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
        RusticClient.init();
        RusticClientForge.postInit();
    }

    public static void onAddReloadListeners(AddReloadListenerEvent event) {
        Rustic.onRegisterReloadListener((id, listener) -> event.addListener(listener));
        InternalRecipeBuilder.setRecipeManager(event.getServerResources().getRecipeManager());
    }
}