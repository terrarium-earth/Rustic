package earth.terrarium.rustic.common.util.fabric;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class PlatformUtilsImpl {
    public static CreativeModeTab createTab(ResourceLocation loc, Supplier<ItemStack> icon) {
        return FabricItemGroupBuilder.build(loc, icon);
    }

    public static void registerStrippedLog(Block log, Block strippedLog) {
        StrippableBlockRegistry.register(log, strippedLog);
    }
}