package earth.terrarium.rustic.common.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.resourcefullib.common.codecs.recipes.IngredientCodec;
import com.teamresourceful.resourcefullib.common.item.OptionalItemStack;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipe;
import earth.terrarium.botarium.api.fluid.FluidHolder;
import earth.terrarium.botarium.api.fluid.FluidHooks;
import earth.terrarium.botarium.api.fluid.UpdatingFluidContainer;
import earth.terrarium.botarium.api.fluid.utils.FluidIngredient;
import earth.terrarium.rustic.common.blockentities.AlchemicCondenserBlockEntity;
import earth.terrarium.rustic.common.registry.ModRecipeSerializers;
import earth.terrarium.rustic.common.registry.ModRecipeTypes;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public record AlchemicCondenserRecipe(ResourceLocation id, List<Ingredient> inputs, FluidIngredient fluid, float buckets, Potion output, ItemStack byProduct) implements CodecRecipe<AlchemicCondenserBlockEntity> {

    public static Codec<AlchemicCondenserRecipe> codec(ResourceLocation id) {
        return RecordCodecBuilder.create(instance -> instance.group(
                RecordCodecBuilder.point(id),
                IngredientCodec.CODEC.listOf().fieldOf("inputs").forGetter(AlchemicCondenserRecipe::inputs),
                FluidIngredient.CODEC.fieldOf("fluid").forGetter(AlchemicCondenserRecipe::fluid),
                Codec.FLOAT.fieldOf("buckets").forGetter(AlchemicCondenserRecipe::buckets),
                Registry.POTION.byNameCodec().fieldOf("output").forGetter(AlchemicCondenserRecipe::output),
                ItemStack.CODEC.optionalFieldOf("by_product").forGetter(recipe -> OptionalItemStack.of(recipe.byProduct()))
        ).apply(instance, AlchemicCondenserRecipe::of));
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static AlchemicCondenserRecipe of(ResourceLocation id, List<Ingredient> inputs, FluidIngredient fluid, float buckets, Potion output, Optional<ItemStack> byProduct) {
        return new AlchemicCondenserRecipe(id, inputs, fluid, buckets, output, byProduct.orElse(ItemStack.EMPTY));
    }

    @Override
    public boolean matches(AlchemicCondenserBlockEntity container, Level level) {
        UpdatingFluidContainer<?> fluidContainer = container.getFluidContainer();
        FluidHolder fluid = fluidContainer.getFluids().get(0);
        if (fluid.getFluidAmount() < FluidHooks.buckets(buckets)) return false;
        if (!this.fluid.test(fluid)) return false;
        IntList toTest = new IntArrayList(new int[]{0, 1, 2});
        outer:
        for (int i = 0; i < Math.min(inputs.size(), 3); i++) {
            var iterator = toTest.iterator();
            while (iterator.hasNext()) {
                int index = iterator.nextInt();
                if (inputs.get(i).test(container.getItem(index))) {
                    iterator.remove();
                    continue outer;
                }
            }
            return false;
        }
        if (toTest.intStream().mapToObj(container::getItem).anyMatch(Predicate.not(ItemStack::isEmpty))) return false;
        ItemStack byProductSlot = container.getItem(5);
        if (byProductSlot.isEmpty() || this.byProduct.isEmpty()) return true;
        return ItemStack.isSameItemSameTags(byProductSlot, this.byProduct) && byProductSlot.getCount() + this.byProduct.getCount() <= byProductSlot.getMaxStackSize();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.ALCHEMIC_CONDENSER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.ALCHEMIC_CONDENSER.get();
    }
}
