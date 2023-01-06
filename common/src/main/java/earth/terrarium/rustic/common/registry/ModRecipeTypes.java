package earth.terrarium.rustic.common.registry;

import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeType;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.recipes.AlchemicCondenserRecipe;
import earth.terrarium.rustic.common.recipes.BrewingRecipe;
import earth.terrarium.rustic.common.recipes.CrushingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipeTypes {
    public static final ResourcefulRegistry<RecipeType<?>> RECIPE_TYPES = ResourcefulRegistries.create(Registry.RECIPE_TYPE, Rustic.MOD_ID);

    public static final RegistryEntry<RecipeType<CrushingRecipe>> CRUSHING = RECIPE_TYPES.register("crushing", () -> CodecRecipeType.of("crushing"));
    public static final RegistryEntry<RecipeType<BrewingRecipe>> BREWING = RECIPE_TYPES.register("brewing", () -> CodecRecipeType.of("brewing"));
    public static final RegistryEntry<RecipeType<AlchemicCondenserRecipe>> ALCHEMIC_CONDENSER = RECIPE_TYPES.register("alchemic_condenser", () -> CodecRecipeType.of("alchemic_condenser"));
}
