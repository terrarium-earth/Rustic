package earth.terrarium.rustic.common.registry;

import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeType;
import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.recipes.AlchemicCondenserRecipe;
import earth.terrarium.rustic.common.recipes.BrewingRecipe;
import earth.terrarium.rustic.common.recipes.CrushingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

public class ModRecipeTypes {
    public static final RegistryHolder<RecipeType<?>> RECIPES = new RegistryHolder<>(Registry.RECIPE_TYPE, Rustic.MOD_ID);
    public static final Supplier<RecipeType<CrushingRecipe>> CRUSHING = RECIPES.register("crushing", () -> CodecRecipeType.of("crushing"));
    public static final Supplier<RecipeType<BrewingRecipe>> BREWING = RECIPES.register("brewing", () -> CodecRecipeType.of("brewing"));
    public static final Supplier<RecipeType<AlchemicCondenserRecipe>> ALCHEMIC_CONDENSER = RECIPES.register("alchemic_condenser", () -> CodecRecipeType.of("alchemic_condenser"));
}
