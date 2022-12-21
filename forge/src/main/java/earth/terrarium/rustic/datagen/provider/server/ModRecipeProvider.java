package earth.terrarium.rustic.datagen.provider.server;

import earth.terrarium.botarium.api.fluid.FluidHooks;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.registry.ModBlocks;
import earth.terrarium.rustic.common.registry.ModItems;
import earth.terrarium.rustic.common.registry.ModTags;
import earth.terrarium.rustic.datagen.builders.CrushingTubRecipeBuilder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        createColouredSetRecipe(consumer, "painted_wood", 8, r -> r
                .define('/', ItemTags.PLANKS)
                .pattern("///")
                .pattern("/#/")
                .pattern("///"));

        planksFromLog(consumer, ModBlocks.IRONWOOD_PLANKS.get(), ModTags.Items.IRONWOOD_LOGS);
        planksFromLog(consumer, ModBlocks.OLIVEWOOD_PLANKS.get(), ModTags.Items.OLIVEWOOD_LOGS);

        woodFromLogs(consumer, ModBlocks.IRONWOOD_WOOD.get(), ModBlocks.OLIVEWOOD_LOG.get());
        woodFromLogs(consumer, ModBlocks.OLIVEWOOD_WOOD.get(), ModBlocks.OLIVEWOOD_LOG.get());

        createBuilder(consumer, ModItems.IRONWOOD_STAIRS, ModItems.IRONWOOD_PLANKS, RecipeProvider::stairBuilder);
        createBuilder(consumer, ModItems.OLIVEWOOD_STAIRS, ModItems.OLIVEWOOD_PLANKS, RecipeProvider::stairBuilder);
        createBuilder(consumer, ModItems.IRONWOOD_SLAB, ModItems.IRONWOOD_PLANKS, RecipeProvider::slabBuilder);
        createBuilder(consumer, ModItems.OLIVEWOOD_SLAB, ModItems.OLIVEWOOD_PLANKS, RecipeProvider::slabBuilder);
        createBuilder(consumer, ModItems.IRONWOOD_FENCE, ModItems.IRONWOOD_PLANKS, RecipeProvider::fenceBuilder);
        createBuilder(consumer, ModItems.OLIVEWOOD_FENCE, ModItems.OLIVEWOOD_PLANKS, RecipeProvider::fenceBuilder);
        createBuilder(consumer, ModItems.IRONWOOD_FENCE_GATE, ModItems.IRONWOOD_PLANKS, RecipeProvider::fenceGateBuilder);
        createBuilder(consumer, ModItems.OLIVEWOOD_FENCE_GATE, ModItems.OLIVEWOOD_PLANKS, RecipeProvider::fenceGateBuilder);
        createBuilder(consumer, ModItems.IRONWOOD_DOOR, ModItems.IRONWOOD_PLANKS, RecipeProvider::doorBuilder);
        createBuilder(consumer, ModItems.OLIVEWOOD_DOOR, ModItems.OLIVEWOOD_PLANKS, RecipeProvider::doorBuilder);
        createBuilder(consumer, ModItems.IRONWOOD_TRAPDOOR, ModItems.IRONWOOD_PLANKS, RecipeProvider::trapdoorBuilder);
        createBuilder(consumer, ModItems.OLIVEWOOD_TRAPDOOR, ModItems.OLIVEWOOD_PLANKS, RecipeProvider::trapdoorBuilder);
        createBuilder(consumer, ModItems.IRONWOOD_BUTTON, ModItems.IRONWOOD_PLANKS, RecipeProvider::buttonBuilder);
        createBuilder(consumer, ModItems.OLIVEWOOD_BUTTON, ModItems.OLIVEWOOD_PLANKS, RecipeProvider::buttonBuilder);
        createBuilder(consumer, ModItems.IRONWOOD_PRESSURE_PLATE, ModItems.IRONWOOD_PLANKS, RecipeProvider::pressurePlateBuilder);
        createBuilder(consumer, ModItems.OLIVEWOOD_PRESSURE_PLATE, ModItems.OLIVEWOOD_PLANKS, RecipeProvider::pressurePlateBuilder);
        createBuilder(consumer, ModItems.IRONWOOD_SIGN, ModItems.IRONWOOD_PLANKS, RecipeProvider::signBuilder);
        createBuilder(consumer, ModItems.OLIVEWOOD_SIGN, ModItems.OLIVEWOOD_PLANKS, RecipeProvider::signBuilder);

        createSimple(consumer, ModItems.CRUSHING_TUB, 1, r -> r
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .define('#', ItemTags.PLANKS)
                .define('/', ItemTags.SLABS)
                .define('@', Items.IRON_INGOT)
                .pattern("# #")
                .pattern("@ @")
                .pattern("///"));

        createSimple(consumer, ModItems.CLAY_WALL, 8, r -> r
                .unlockedBy("has_clay", has(Items.CLAY))
                .define('#', Items.CLAY)
                .define('/', ItemTags.PLANKS)
                .pattern(" / ")
                .pattern("/#/")
                .pattern(" / "));

        createSimple(consumer, ModItems.CLAY_CROSS_WALL, 1, r -> r
                .unlockedBy("has_clay", has(Items.CLAY))
                .define('#', ModItems.CLAY_WALL.get())
                .define('/', ItemTags.PLANKS)
                .pattern("/ /")
                .pattern(" # ")
                .pattern("/ /"));

        createSimple(consumer, ModItems.CLAY_DIAGONAL_LEFT_CROSS_WALL, 1, r -> r
                .unlockedBy("has_clay", has(Items.CLAY))
                .define('#', ModItems.CLAY_WALL.get())
                .define('/', ItemTags.PLANKS)
                .pattern("/  ")
                .pattern(" # ")
                .pattern("  /"));

        createSimple(consumer, ModItems.CLAY_DIAGONAL_RIGHT_CROSS_WALL, 1, r -> r
                .unlockedBy("has_clay", has(Items.CLAY))
                .define('#', ModItems.CLAY_WALL.get())
                .define('/', ItemTags.PLANKS)
                .pattern("  /")
                .pattern(" # ")
                .pattern("/  "));

        createWoodSetRecipe(consumer, "fluid_barrel", 1, r -> r
                .define('/', ItemTags.SLABS)
                .define('@', Items.IRON_INGOT)
                .pattern("#/#")
                .pattern("@ @")
                .pattern("#/#"));

        createSimple(consumer, ModItems.STONE_PILLAR, 6, r -> r
                .unlockedBy("has_stone", has(Items.STONE))
                .define('#', Items.STONE)
                .pattern("## ")
                .pattern("## ")
                .pattern("## "));

        createSimple(consumer, ModItems.ANDESITE_PILLAR, 6, r -> r
                .unlockedBy("has_andesite", has(Items.ANDESITE))
                .define('#', Items.ANDESITE)
                .pattern("## ")
                .pattern("## ")
                .pattern("## "));

        createSimple(consumer, ModItems.DIORITE_PILLAR, 6, r -> r
                .unlockedBy("has_diorite", has(Items.DIORITE))
                .define('#', Items.DIORITE)
                .pattern("## ")
                .pattern("## ")
                .pattern("## "));

        createSimple(consumer, ModItems.GRANITE_PILLAR, 6, r -> r
                .unlockedBy("has_granite", has(Items.GRANITE))
                .define('#', Items.GRANITE)
                .pattern("## ")
                .pattern("## ")
                .pattern("## "));

        createSimple(consumer, ModItems.DEEPSLATE_PILLAR, 6, r -> r
                .unlockedBy("has_deepslate", has(Items.DEEPSLATE))
                .define('#', Items.DEEPSLATE)
                .pattern("## ")
                .pattern("## ")
                .pattern("## "));

        createSimple(consumer, ModItems.TERRACOTTA_POT, 6, r -> r
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .define('#', Items.TERRACOTTA)
                .pattern(" # ")
                .pattern("# #")
                .pattern("###"));

        createSimpleShapeless(consumer, ModItems.WHITE_TERRACOTTA_POT, 6, r -> r
                .unlockedBy("has_terracotta_pot", has(ModItems.TERRACOTTA_POT.get()))
                .requires(ModItems.TERRACOTTA_POT.get())
                .requires(Items.WHITE_DYE));

        createSimpleShapeless(consumer, ModItems.RED_TERRACOTTA_POT, 6, r -> r
                .unlockedBy("has_terracotta_pot", has(ModItems.TERRACOTTA_POT.get()))
                .requires(ModItems.TERRACOTTA_POT.get())
                .requires(Items.RED_DYE));

        createSimpleShapeless(consumer, ModItems.GREEN_TERRACOTTA_POT, 6, r -> r
                .unlockedBy("has_terracotta_pot", has(ModItems.TERRACOTTA_POT.get()))
                .requires(ModItems.TERRACOTTA_POT.get())
                .requires(Items.GREEN_DYE));

        createSimpleShapeless(consumer, ModItems.BLUE_TERRACOTTA_POT, 6, r -> r
                .unlockedBy("has_terracotta_pot", has(ModItems.TERRACOTTA_POT.get()))
                .requires(ModItems.TERRACOTTA_POT.get())
                .requires(Items.BLUE_DYE));

        createSimpleShapeless(consumer, ModItems.BLACK_TERRACOTTA_POT, 6, r -> r
                .unlockedBy("has_terracotta_pot", has(ModItems.TERRACOTTA_POT.get()))
                .requires(ModItems.TERRACOTTA_POT.get())
                .requires(Items.BLACK_DYE));

        stonecutterResultFromBase(consumer, ModItems.STONE_PILLAR.get(), Items.STONE);
        stonecutterResultFromBase(consumer, ModItems.ANDESITE_PILLAR.get(), Items.ANDESITE);
        stonecutterResultFromBase(consumer, ModItems.DIORITE_PILLAR.get(), Items.DIORITE);
        stonecutterResultFromBase(consumer, ModItems.GRANITE_PILLAR.get(), Items.GRANITE);
        stonecutterResultFromBase(consumer, ModItems.DEEPSLATE_PILLAR.get(), Items.DEEPSLATE);

        createSimpleCrushing(consumer, Items.SUGAR_CANE, Fluids.WATER, 0.25f, new ItemStack(Items.SUGAR, 2), 2);
    }

    public static void createBuilder(Consumer<FinishedRecipe> consumer, Supplier<Item> output, Supplier<Item> input, BiFunction<ItemLike, Ingredient, RecipeBuilder> func) {
        func.apply(output.get(), Ingredient.of(input.get())).unlockedBy(getHasName(input.get()), has(input.get())).save(consumer);
    }

    public static void createSimple(Consumer<FinishedRecipe> consumer, Supplier<Item> output, int count, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> func) {
        String name = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(output.get())).getPath();
        func.apply(ShapedRecipeBuilder.shaped(output.get(), count))
                .group(name)
                .save(consumer);
    }

    public static void createSimpleShapeless(Consumer<FinishedRecipe> consumer, Supplier<Item> output, int count, Function<ShapelessRecipeBuilder, ShapelessRecipeBuilder> func) {
        String name = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(output.get())).getPath();
        func.apply(ShapelessRecipeBuilder.shapeless(output.get(), count))
                .group(name)
                .save(consumer);
    }

    public static void createSimpleCrushing(Consumer<FinishedRecipe> consumer, ItemLike input, Fluid output, float buckets, ItemStack byProduct, int presses) {
        ResourceLocation id = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(input.asItem()));
        CrushingTubRecipeBuilder builder = new CrushingTubRecipeBuilder(Ingredient.of(input), FluidHooks.newFluidHolder(output, FluidHooks.buckets(buckets), null))
                .unlockedBy("has_" + id.getPath(), has(input))
                .byProduct(byProduct)
                .presses(presses);
        builder.save(consumer, new ResourceLocation(id.getNamespace(), id.getPath() + "_crushing"));
    }

    public static void createWoodSetRecipe(Consumer<FinishedRecipe> consumer, String suffix, int count, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> func) {
        for (Item wood : new Item[]{Items.ACACIA_PLANKS, Items.BIRCH_PLANKS, Items.DARK_OAK_PLANKS, Items.JUNGLE_PLANKS, Items.MANGROVE_PLANKS, Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.CRIMSON_PLANKS, Items.WARPED_PLANKS, ModItems.IRONWOOD_PLANKS.get(), ModItems.OLIVEWOOD_PLANKS.get()}) {
            String woodName = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(wood)).getPath().replace("_planks", "");
            Item output = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Rustic.MOD_ID, woodName + "_" + suffix));

            assert output != null;
            ShapedRecipeBuilder recipe = func.apply(ShapedRecipeBuilder.shaped(output, count)
                    .define('#', wood)
                    .group(suffix)
                    .unlockedBy("has_" + suffix, has(wood)));

            recipe.save(consumer);
        }
    }

    public static void createColouredSetRecipe(Consumer<FinishedRecipe> consumer, String suffix, int count, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> func) {
        for (Item wood : new Item[]{Items.BLACK_DYE, Items.BLUE_DYE, Items.BROWN_DYE, Items.CYAN_DYE, Items.GRAY_DYE, Items.GREEN_DYE, Items.LIGHT_BLUE_DYE, Items.LIGHT_GRAY_DYE, Items.LIME_DYE, Items.MAGENTA_DYE, Items.ORANGE_DYE, Items.PINK_DYE, Items.PURPLE_DYE, Items.RED_DYE, Items.WHITE_DYE, Items.YELLOW_DYE}) {
            String colour = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(wood)).getPath().replace("_dye", "");
            Item output = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Rustic.MOD_ID, colour + "_" + suffix));

            assert output != null;
            ShapedRecipeBuilder recipe = func.apply(ShapedRecipeBuilder.shaped(output, count)
                    .define('#', wood)
                    .group(suffix)
                    .unlockedBy("has_" + suffix, has(wood)));

            recipe.save(consumer);
        }
    }
}
