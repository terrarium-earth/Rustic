package earth.terrarium.rustic.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.botarium.api.registry.RegistryHelpers;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.menus.AlchemicCondenserMenu;
import net.minecraft.core.Registry;
import net.minecraft.world.inventory.MenuType;

public class ModMenuTypes {

    public static final ResourcefulRegistry<MenuType<?>> MENU_TYPES = ResourcefulRegistries.create(Registry.MENU, Rustic.MOD_ID);

    public static final RegistryEntry<MenuType<AlchemicCondenserMenu>> ALCHEMIC_CONDENSER = MENU_TYPES.register("alchemic_condenser", () -> RegistryHelpers.createMenuType(AlchemicCondenserMenu::new));
}
