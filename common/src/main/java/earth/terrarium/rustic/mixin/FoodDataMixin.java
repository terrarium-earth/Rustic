package earth.terrarium.rustic.mixin;

import earth.terrarium.rustic.common.events.ItemEvents;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoodData.class)
public class FoodDataMixin {

    @Inject(method = "eat(Lnet/minecraft/world/item/Item;Lnet/minecraft/world/item/ItemStack;)V", at = @At("HEAD"))
    private void rustic$onEat(Item item, ItemStack stack, CallbackInfo ci) {
        ItemEvents.onFoodEaten(stack, (FoodData) (Object) this);
    }
}
