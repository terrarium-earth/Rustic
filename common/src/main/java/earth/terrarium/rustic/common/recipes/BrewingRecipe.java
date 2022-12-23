package earth.terrarium.rustic.common.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipe;
import earth.terrarium.botarium.api.fluid.FluidHolder;
import earth.terrarium.botarium.api.fluid.utils.FluidIngredient;
import earth.terrarium.rustic.common.registry.ModRecipeSerializers;
import earth.terrarium.rustic.common.registry.ModRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public record BrewingRecipe(ResourceLocation id, FluidIngredient input, int inputBucketAmount, FluidHolder output) implements CodecRecipe<Container> {

    public static Codec<BrewingRecipe> codec(ResourceLocation id) {
        return RecordCodecBuilder.create(instance -> instance.group(
                RecordCodecBuilder.point(id),
                FluidIngredient.CODEC.fieldOf("input").forGetter(BrewingRecipe::input),
                Codec.INT.fieldOf("inputBucketAmount").orElse(1).forGetter(BrewingRecipe::inputBucketAmount),
                FluidHolder.CODEC.fieldOf("output").forGetter(BrewingRecipe::output)
        ).apply(instance, BrewingRecipe::new));
    }

    @Override
    public boolean matches(Container container, Level level) {
        return false;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.BREWING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.BREWING.get();
    }
}
