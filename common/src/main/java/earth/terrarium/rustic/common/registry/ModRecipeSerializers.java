package earth.terrarium.rustic.common.registry;

import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeSerializer;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.recipes.AlchemicCondenserRecipe;
import earth.terrarium.rustic.common.recipes.BrewingRecipe;
import earth.terrarium.rustic.common.recipes.CrushingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class ModRecipeSerializers {
    public static final ResourcefulRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = ResourcefulRegistries.create(Registry.RECIPE_SERIALIZER, Rustic.MOD_ID);

    public static final RegistryEntry<CodecRecipeSerializer<CrushingRecipe>> CRUSHING = RECIPE_SERIALIZERS.register("crushing", () -> new CodecRecipeSerializer<>(ModRecipeTypes.CRUSHING.get(), CrushingRecipe::codec));
    public static final RegistryEntry<CodecRecipeSerializer<BrewingRecipe>> BREWING = RECIPE_SERIALIZERS.register("brewing", () -> new CodecRecipeSerializer<>(ModRecipeTypes.BREWING.get(), BrewingRecipe::codec));
    public static final Supplier<CodecRecipeSerializer<AlchemicCondenserRecipe>> ALCHEMIC_CONDENSER = SERIALIZERS.register("alchemic_condenser", () -> new CodecRecipeSerializer<>(ModRecipeTypes.ALCHEMIC_CONDENSER.get(), AlchemicCondenserRecipe::codec));
}
