package earth.terrarium.rustic.common.registry;

import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeType;
import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.recipes.CrushingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

public class ModRecipeTypes {
    public static final RegistryHolder<RecipeType<?>> RECIPES = new RegistryHolder<>(Registry.RECIPE_TYPE, Rustic.MOD_ID);
    public static final Supplier<RecipeType<CrushingRecipe>> CRUSHING = RECIPES.register("crushing", () -> CodecRecipeType.of("crushing"));
}
