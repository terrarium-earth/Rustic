package earth.terrarium.rustic.common.events;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public final class ItemEvents {

    public static void onFoodEaten(ItemStack food, FoodData data) {
        if (food.isEdible() && food.hasTag() && food.getOrCreateTag().contains("RusticOiled")) {
            data.eat(2, 0.3f);
        }
    }

    public static void onTooltip(ItemStack stack, List<Component> tooltip) {
        if (stack.isEdible() && stack.hasTag() && stack.getOrCreateTag().contains("RusticOiled")) {
            tooltip.add(Component.translatable("tooltip.rustic.oiled").withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.ITALIC));
        }
    }
}
