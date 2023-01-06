package earth.terrarium.rustic.mixin.fabric;

import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.crafting.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PotionBrewing.Mix.class)
public interface PotionBrewingMixAccessor<T> {

    @Accessor("from")
    T getFrom();

    @Accessor("ingredient")
    Ingredient getIngredient();

    @Accessor("to")
    T getTo();
}
