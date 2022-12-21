package earth.terrarium.rustic.datagen.builders;

import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import earth.terrarium.botarium.api.fluid.FluidHolder;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.recipes.CrushingRecipe;
import earth.terrarium.rustic.common.registry.ModRecipeSerializers;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class CrushingTubRecipeBuilder implements RecipeBuilder {

    protected final Advancement.Builder advancement = Advancement.Builder.advancement();
    protected final Ingredient ingredient;
    protected final FluidHolder fluid;
    
    protected int presses = 4;
    protected ItemStack byProduct = ItemStack.EMPTY;

    public CrushingTubRecipeBuilder(Ingredient ingredient, FluidHolder fluid) {
        this.fluid = fluid;
        this.ingredient = ingredient;

        if (fluid.isEmpty()) throw new IllegalArgumentException("Fluid cannot be empty");
    }

    public CrushingTubRecipeBuilder presses(int presses) {
        this.presses = presses;
        return this;
    }

    public CrushingTubRecipeBuilder byProduct(ItemStack byProduct) {
        this.byProduct = byProduct;
        return this;
    }

    @Override
    public @NotNull CrushingTubRecipeBuilder unlockedBy(@NotNull String name, @NotNull CriterionTriggerInstance trigger) {
        this.advancement.addCriterion(name, trigger);
        return this;
    }

    @Override
    public @NotNull CrushingTubRecipeBuilder group(@Nullable String group) {
        return this;
    }

    @Override
    public @NotNull Item getResult() {
        return this.byProduct.getItem();
    }

    @Override
    public void save(@NotNull Consumer<FinishedRecipe> consumer, @NotNull ResourceLocation id) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT)
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(id))
                .requirements(RequirementsStrategy.OR);
        consumer.accept(new Result(
                id, this.ingredient,
                this.fluid, this.byProduct,
                this.presses,
                this.advancement, new ResourceLocation(id.getNamespace(), "recipes/crushing_tub/" + id.getPath()))
        );
    }

    public record Result(
            ResourceLocation id,
            Ingredient ingredient,
            FluidHolder fluid, ItemStack byProduct,
            int presses,
            Advancement.Builder advancement, ResourceLocation advancementId
    ) implements FinishedRecipe {

        @Override
        public void serializeRecipeData(@NotNull JsonObject json) {
            CrushingRecipe.codec(id)
                .encodeStart(JsonOps.INSTANCE, new CrushingRecipe(id, presses, ingredient, fluid, byProduct))
                .resultOrPartial(Rustic.LOGGER::error)
                .ifPresent(out ->
                        out.getAsJsonObject().entrySet().forEach(entry -> json.add(entry.getKey(), entry.getValue()))
                );
        }

        @Override
        public @NotNull ResourceLocation getId() {
            return this.id;
        }

        @Override
        public @NotNull RecipeSerializer<?> getType() {
            return ModRecipeSerializers.CRUSHING.get();
        }

        @Override
        public @NotNull JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
