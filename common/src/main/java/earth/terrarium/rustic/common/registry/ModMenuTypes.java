package earth.terrarium.rustic.common.registry;

import earth.terrarium.botarium.api.registry.RegistryHelpers;
import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.menus.AlchemicCondenserMenu;
import net.minecraft.core.Registry;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class ModMenuTypes {

    public static final RegistryHolder<MenuType<?>> MENU_TYPES = new RegistryHolder<>(Registry.MENU, Rustic.MOD_ID);

    public static final Supplier<MenuType<AlchemicCondenserMenu>> ALCHEMIC_CONDENSER = MENU_TYPES.register("alchemic_condenser", () -> RegistryHelpers.createMenuType(AlchemicCondenserMenu::new));
}
