package earth.terrarium.rustic.common.registry;

import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.rustic.Rustic;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final RegistryHolder<Item> ITEMS = new RegistryHolder<>(Registry.ITEM, Rustic.MOD_ID);

    public static void init() {
        ITEMS.initialize();
    }
}