package earth.terrarium.rustic.common.recipes;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import earth.terrarium.botarium.api.fluid.utils.FluidIngredient;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.util.PlatformUtils;
import earth.terrarium.rustic.mixin.RecipeManagerAccessor;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.material.Fluids;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class InternalRecipeBuilder implements ResourceManagerReloadListener {

    private static final InternalRecipeBuilder INSTANCE = new InternalRecipeBuilder();
    private static RecipeManager recipeManager;

    public static InternalRecipeBuilder getInstance() {
        return INSTANCE;
    }

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
        Multimap<Potion, Pair<Ingredient, Potion>> mixes = ArrayListMultimap.create();
        PlatformUtils.getBrewingRecipes().forEach(mix -> mixes.put(mix.getLeft(), Pair.of(mix.getMiddle(), mix.getRight())));

        for (Pair<Ingredient, Potion> recipe : mixes.get(Potions.AWKWARD)) {
            String path = Registry.POTION.getKey(recipe.getValue()).getPath();
            addRecipe(new AlchemicCondenserRecipe(
                    generateUniqueId(path),
                    List.of(recipe.getKey()),
                    FluidIngredient.of(Fluids.WATER),
                    0.1f,
                    recipe.getValue(),
                    ItemStack.EMPTY
            ));
            Collection<Pair<Ingredient, Potion>> otherMixes = mixes.get(recipe.getValue());
            for (Pair<Ingredient, Potion> otherMix : otherMixes) {
                addRecipe(new AlchemicCondenserRecipe(
                        generateUniqueId(path + "_extended"),
                        List.of(recipe.getKey(), otherMix.getKey()),
                        FluidIngredient.of(Fluids.WATER),
                        0.1f,
                        otherMix.getValue(),
                        ItemStack.EMPTY
                ));
            }
        }
    }

    private ResourceLocation generateUniqueId(String name) {
        return new ResourceLocation(Rustic.MOD_ID, name + "_generated_" + UUID.randomUUID());
    }

    private void addRecipe(Recipe<?> recipe) {
        getRecipeManager().getRecipes()
            .computeIfAbsent(recipe.getType(), t -> new HashMap<>())
            .put(recipe.getId(), recipe);
    }

    public static void setRecipeManager(RecipeManager recipeManager) {
        InternalRecipeBuilder.recipeManager = recipeManager;
    }

    private static RecipeManagerAccessor getRecipeManager() {
        RecipeManagerAccessor accessor = (RecipeManagerAccessor)recipeManager;
        if (!accessor.getRecipes().getClass().equals(HashMap.class)) {
            accessor.setRecipes(new HashMap<>(accessor.getRecipes()));
            accessor.getRecipes().replaceAll((t, v) -> new HashMap<>(accessor.getRecipes().get(t)));
        }

        return accessor;
    }
}
