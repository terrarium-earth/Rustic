package earth.terrarium.rustic.common.menus.slots;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import java.util.function.Predicate;

public class CustomSlot extends Slot {

    protected final Predicate<ItemStack> predicate;

    public CustomSlot(Container container, int slot, int x, int y, Predicate<ItemStack> predicate) {
        super(container, slot, x, y);
        this.predicate = predicate;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return this.predicate.test(stack);
    }
}
