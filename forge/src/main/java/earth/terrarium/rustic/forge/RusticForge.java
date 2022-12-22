package earth.terrarium.rustic.forge;

import earth.terrarium.rustic.Rustic;
import net.minecraftforge.api.distmarker.Dist;
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
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> RusticForgeClient::init);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(RusticForge::onClientSetup);
        bus.addListener(RusticForge::commonSetup);
    }

    public static void commonSetup(FMLCommonSetupEvent event) {
        Rustic.postInit();
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
        RusticForgeClient.postInit();
    }
}