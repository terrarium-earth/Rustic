package earth.terrarium.rustic.common.recipes;

import earth.terrarium.rustic.common.registry.ModItems;
import earth.terrarium.rustic.common.registry.ModRecipeSerializers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class OiledFoodRecipe extends CustomRecipe {

    public OiledFoodRecipe(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        int count = 0;
        boolean hasOil = false;
        boolean hasFood = false;

        for (int i = 0; i < container.getContainerSize(); i++) {
            ItemStack stack = container.getItem(i);
            if (stack.isEmpty()) continue;

            count++;
            if (stack.is(ModItems.OLIVE_OIL_BUCKET.get()) && !hasOil) {
                hasOil = true;
            } else if (stack.getItem().isEdible() && !hasFood) {
                hasFood = true;
            }  else {
                return false;
            }
        }
        return hasOil && hasFood && count == 2;
    }

    @Override
    public ItemStack assemble(CraftingContainer container) {
        boolean hasOil = false;
        boolean hasFood = false;

        for (int i = 0; i < container.getContainerSize(); i++) {
            ItemStack stack = container.getItem(i);
            if (stack.isEmpty()) continue;

            if (stack.is(ModItems.OLIVE_OIL_BUCKET.get()) && !hasOil) {
                hasOil = true;
            } else if (stack.getItem().isEdible() && !stack.getItem().hasCraftingRemainingItem() && !hasFood) {
                ItemStack result = stack.copy();
                result.setCount(1);
                result.getOrCreateTag().putBoolean("RusticOiled", true);
                return result;
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return (width >= 2 && height >= 1) || (width >= 1 && height >= 2);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.OILED_FOOD.get();
    }
}
