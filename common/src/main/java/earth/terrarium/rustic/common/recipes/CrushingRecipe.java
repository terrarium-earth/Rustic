package earth.terrarium.rustic.common.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.resourcefullib.common.codecs.recipes.IngredientCodec;
import com.teamresourceful.resourcefullib.common.codecs.recipes.ItemStackCodec;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipe;
import earth.terrarium.botarium.api.fluid.FluidHolder;
import earth.terrarium.botarium.api.fluid.FluidHooks;
import earth.terrarium.rustic.common.registry.ModRecipeSerializers;
import earth.terrarium.rustic.common.registry.ModRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.Optional;

public record CrushingRecipe(ResourceLocation id, int presses, Ingredient ingredient, FluidHolder output, ItemStack result) implements CodecRecipe<Container> {

    public static Codec<CrushingRecipe> codec(ResourceLocation id) {
        return RecordCodecBuilder.create(instance -> instance.group(
                RecordCodecBuilder.point(id),
                Codec.INT.fieldOf("presses").orElse(4).forGetter(CrushingRecipe::presses),
                IngredientCodec.CODEC.fieldOf("ingredient").forGetter(CrushingRecipe::ingredient),
                FluidHolder.CODEC.fieldOf("result").orElse(FluidHooks.emptyFluid()).forGetter(CrushingRecipe::output),
                ItemStackCodec.CODEC.fieldOf("product").orElse(ItemStack.EMPTY).forGetter(CrushingRecipe::result)
        ).apply(instance, CrushingRecipe::new));
    }

    public static Optional<CrushingRecipe> getRecipe(Level level, Container container) {
        return level.getRecipeManager().getRecipeFor(ModRecipeTypes.CRUSHING.get(), container, level);
    }

    @Override
    public boolean matches(Container container, Level level) {
        return this.ingredient.test(container.getItem(0));
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.CRUSHING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.CRUSHING.get();
    }
}
