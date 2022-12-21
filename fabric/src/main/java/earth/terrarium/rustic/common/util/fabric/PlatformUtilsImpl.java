package earth.terrarium.rustic.common.util.fabric;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.world.level.block.Block;

public class PlatformUtilsImpl {
    public static void registerStrippedLog(Block log, Block strippedLog) {
        StrippableBlockRegistry.register(log, strippedLog);
    }
}