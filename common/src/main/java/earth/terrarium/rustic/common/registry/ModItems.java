package earth.terrarium.rustic.common.registry;

import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.blocks.PotBlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class ModItems {
    public static final CreativeModeTab ITEM_GROUP = ModRegistryHelpers.createTab(new ResourceLocation(Rustic.MOD_ID, "main"), () -> new ItemStack(Items.BOWL));

    public static final RegistryHolder<Item> ITEMS = new RegistryHolder<>(Registry.ITEM, Rustic.MOD_ID);

    public static final Supplier<Item> BLACK_PAINTED_WOOD = ITEMS.register("black_painted_wood", () -> new BlockItem(ModBlocks.BLACK_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_PAINTED_WOOD = ITEMS.register("blue_painted_wood", () -> new BlockItem(ModBlocks.BLUE_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BROWN_PAINTED_WOOD = ITEMS.register("brown_painted_wood", () -> new BlockItem(ModBlocks.BROWN_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CYAN_PAINTED_WOOD = ITEMS.register("cyan_painted_wood", () -> new BlockItem(ModBlocks.CYAN_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GRAY_PAINTED_WOOD = ITEMS.register("gray_painted_wood", () -> new BlockItem(ModBlocks.GRAY_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GREEN_PAINTED_WOOD = ITEMS.register("green_painted_wood", () -> new BlockItem(ModBlocks.GREEN_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIGHT_BLUE_PAINTED_WOOD = ITEMS.register("light_blue_painted_wood", () -> new BlockItem(ModBlocks.LIGHT_BLUE_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIGHT_GRAY_PAINTED_WOOD = ITEMS.register("light_gray_painted_wood", () -> new BlockItem(ModBlocks.LIGHT_GRAY_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> LIME_PAINTED_WOOD = ITEMS.register("lime_painted_wood", () -> new BlockItem(ModBlocks.LIME_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MAGENTA_PAINTED_WOOD = ITEMS.register("magenta_painted_wood", () -> new BlockItem(ModBlocks.MAGENTA_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ORANGE_PAINTED_WOOD = ITEMS.register("orange_painted_wood", () -> new BlockItem(ModBlocks.ORANGE_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> PINK_PAINTED_WOOD = ITEMS.register("pink_painted_wood", () -> new BlockItem(ModBlocks.PINK_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> PURPLE_PAINTED_WOOD = ITEMS.register("purple_painted_wood", () -> new BlockItem(ModBlocks.PURPLE_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> RED_PAINTED_WOOD = ITEMS.register("red_painted_wood", () -> new BlockItem(ModBlocks.RED_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_PAINTED_WOOD = ITEMS.register("white_painted_wood", () -> new BlockItem(ModBlocks.WHITE_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> YELLOW_PAINTED_WOOD = ITEMS.register("yellow_painted_wood", () -> new BlockItem(ModBlocks.YELLOW_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> IRONBERRIES = ITEMS.register("ironberries", () -> new Item(new Item.Properties().tab(ITEM_GROUP).food(Foods.SWEET_BERRIES)));
    public static final Supplier<Item> OLIVES = ITEMS.register("olives", () -> new Item(new Item.Properties().tab(ITEM_GROUP).food(Foods.SWEET_BERRIES)));
    public static final Supplier<Item> TOMATO = ITEMS.register("tomato", () -> new Item(new Item.Properties().tab(ITEM_GROUP).food(Foods.SWEET_BERRIES)));
    public static final Supplier<Item> CHILI_PEPPER = ITEMS.register("chili_pepper", () -> new Item(new Item.Properties().tab(ITEM_GROUP).food(Foods.SWEET_BERRIES)));
    public static final Supplier<Item> GRAPES = ITEMS.register("grapes", () -> new Item(new Item.Properties().tab(ITEM_GROUP).food(Foods.SWEET_BERRIES)));
    public static final Supplier<Item> ALMANAC = ITEMS.register("almanac", () -> new Item(new Item.Properties().tab(ITEM_GROUP).stacksTo(1)));

    public static final Supplier<Item> IRONWOOD_PLANKS = ITEMS.register("ironwood_planks", () -> new BlockItem(ModBlocks.IRONWOOD_PLANKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_PLANKS = ITEMS.register("olivewood_planks", () -> new BlockItem(ModBlocks.OLIVEWOOD_PLANKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_LOG = ITEMS.register("ironwood_log", () -> new BlockItem(ModBlocks.IRONWOOD_LOG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_LOG = ITEMS.register("olivewood_log", () -> new BlockItem(ModBlocks.OLIVEWOOD_LOG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_LEAVES = ITEMS.register("ironwood_leaves", () -> new BlockItem(ModBlocks.IRONWOOD_LEAVES.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_LEAVES = ITEMS.register("olivewood_leaves", () -> new BlockItem(ModBlocks.OLIVEWOOD_LEAVES.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_SAPLING = ITEMS.register("ironwood_sapling", () -> new BlockItem(ModBlocks.IRONWOOD_SAPLING.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_SAPLING = ITEMS.register("olivewood_sapling", () -> new BlockItem(ModBlocks.OLIVEWOOD_SAPLING.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_STAIRS = ITEMS.register("ironwood_stairs", () -> new BlockItem(ModBlocks.IRONWOOD_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_STAIRS = ITEMS.register("olivewood_stairs", () -> new BlockItem(ModBlocks.OLIVEWOOD_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_SLAB = ITEMS.register("ironwood_slab", () -> new BlockItem(ModBlocks.IRONWOOD_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_SLAB = ITEMS.register("olivewood_slab", () -> new BlockItem(ModBlocks.OLIVEWOOD_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_FENCE = ITEMS.register("ironwood_fence", () -> new BlockItem(ModBlocks.IRONWOOD_FENCE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_FENCE = ITEMS.register("olivewood_fence", () -> new BlockItem(ModBlocks.OLIVEWOOD_FENCE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_FENCE_GATE = ITEMS.register("ironwood_fence_gate", () -> new BlockItem(ModBlocks.IRONWOOD_FENCE_GATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_FENCE_GATE = ITEMS.register("olivewood_fence_gate", () -> new BlockItem(ModBlocks.OLIVEWOOD_FENCE_GATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_BUTTON = ITEMS.register("ironwood_button", () -> new BlockItem(ModBlocks.IRONWOOD_BUTTON.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_BUTTON = ITEMS.register("olivewood_button", () -> new BlockItem(ModBlocks.OLIVEWOOD_BUTTON.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_PRESSURE_PLATE = ITEMS.register("ironwood_pressure_plate", () -> new BlockItem(ModBlocks.IRONWOOD_PRESSURE_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_PRESSURE_PLATE = ITEMS.register("olivewood_pressure_plate", () -> new BlockItem(ModBlocks.OLIVEWOOD_PRESSURE_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_DOOR = ITEMS.register("ironwood_door", () -> new BlockItem(ModBlocks.IRONWOOD_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_DOOR = ITEMS.register("olivewood_door", () -> new BlockItem(ModBlocks.OLIVEWOOD_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_TRAPDOOR = ITEMS.register("ironwood_trapdoor", () -> new BlockItem(ModBlocks.IRONWOOD_TRAPDOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_TRAPDOOR = ITEMS.register("olivewood_trapdoor", () -> new BlockItem(ModBlocks.OLIVEWOOD_TRAPDOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_SIGN = ITEMS.register("ironwood_sign", () -> new SignItem(new Item.Properties().tab(ITEM_GROUP), ModBlocks.IRONWOOD_SIGN.get(), ModBlocks.IRONWOOD_WALL_SIGN.get()));
    public static final Supplier<Item> OLIVEWOOD_SIGN = ITEMS.register("olivewood_sign", () -> new SignItem(new Item.Properties().tab(ITEM_GROUP), ModBlocks.OLIVEWOOD_SIGN.get(), ModBlocks.OLIVEWOOD_WALL_SIGN.get()));
    public static final Supplier<Item> IRONWOOD_WOOD = ITEMS.register("ironwood_wood", () -> new BlockItem(ModBlocks.IRONWOOD_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_WOOD = ITEMS.register("olivewood_wood", () -> new BlockItem(ModBlocks.OLIVEWOOD_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_STRIPPED_LOG = ITEMS.register("ironwood_stripped_log", () -> new BlockItem(ModBlocks.IRONWOOD_STRIPPED_LOG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_STRIPPED_LOG = ITEMS.register("olivewood_stripped_log", () -> new BlockItem(ModBlocks.OLIVEWOOD_STRIPPED_LOG.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> STONE_PILLAR = ITEMS.register("stone_pillar", () -> new BlockItem(ModBlocks.STONE_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ANDESITE_PILLAR = ITEMS.register("andesite_pillar", () -> new BlockItem(ModBlocks.ANDESITE_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DIORITE_PILLAR = ITEMS.register("diorite_pillar", () -> new BlockItem(ModBlocks.DIORITE_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GRANITE_PILLAR = ITEMS.register("granite_pillar", () -> new BlockItem(ModBlocks.GRANITE_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DEEPSLATE_PILLAR = ITEMS.register("deepslate_pillar", () -> new BlockItem(ModBlocks.DEEPSLATE_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> CLAY_WALL = ITEMS.register("clay_wall", () -> new BlockItem(ModBlocks.CLAY_WALL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CLAY_CROSS_WALL = ITEMS.register("clay_cross_wall", () -> new BlockItem(ModBlocks.CLAY_CROSS_WALL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CLAY_DIAGONAL_LEFT_CROSS_WALL = ITEMS.register("clay_diagonal_left_cross_wall", () -> new BlockItem(ModBlocks.CLAY_DIAGONAL_LEFT_CROSS_WALL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CLAY_DIAGONAL_RIGHT_CROSS_WALL = ITEMS.register("clay_diagonal_right_cross_wall", () -> new BlockItem(ModBlocks.CLAY_DIAGONAL_RIGHT_CROSS_WALL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> CRUSHING_TUB = ITEMS.register("crushing_tub", () -> new BlockItem(ModBlocks.CRUSHING_TUB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> ACACIA_BARREL = ITEMS.register("acacia_fluid_barrel", () -> new BlockItem(ModBlocks.ACACIA_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BIRCH_BARREL = ITEMS.register("birch_fluid_barrel", () -> new BlockItem(ModBlocks.BIRCH_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> CRIMSON_BARREL = ITEMS.register("crimson_fluid_barrel", () -> new BlockItem(ModBlocks.CRIMSON_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> DARK_OAK_BARREL = ITEMS.register("dark_oak_fluid_barrel", () -> new BlockItem(ModBlocks.DARK_OAK_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> JUNGLE_BARREL = ITEMS.register("jungle_fluid_barrel", () -> new BlockItem(ModBlocks.JUNGLE_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> MANGROVE_BARREL = ITEMS.register("mangrove_fluid_barrel", () -> new BlockItem(ModBlocks.MANGROVE_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OAK_BARREL = ITEMS.register("oak_fluid_barrel", () -> new BlockItem(ModBlocks.OAK_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_BARREL = ITEMS.register("ironwood_fluid_barrel", () -> new BlockItem(ModBlocks.IRONWOOD_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_BARREL = ITEMS.register("olivewood_fluid_barrel", () -> new BlockItem(ModBlocks.OLIVEWOOD_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> SPRUCE_BARREL = ITEMS.register("spruce_fluid_barrel", () -> new BlockItem(ModBlocks.SPRUCE_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WARPED_BARREL = ITEMS.register("warped_fluid_barrel", () -> new BlockItem(ModBlocks.WARPED_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final Supplier<Item> TERRACOTTA_POT = ITEMS.register("terracotta_pot", () -> new BlockItem(ModBlocks.TERRACOTTA_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> WHITE_TERRACOTTA_POT = ITEMS.register("white_terracotta_pot", () -> new BlockItem(ModBlocks.WHITE_TERRACOTTA_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> RED_TERRACOTTA_POT = ITEMS.register("red_terracotta_pot", () -> new BlockItem(ModBlocks.RED_TERRACOTTA_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> GREEN_TERRACOTTA_POT = ITEMS.register("green_terracotta_pot", () -> new BlockItem(ModBlocks.GREEN_TERRACOTTA_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLUE_TERRACOTTA_POT = ITEMS.register("blue_terracotta_pot", () -> new BlockItem(ModBlocks.BLUE_TERRACOTTA_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> BLACK_TERRACOTTA_POT = ITEMS.register("black_terracotta_pot", () -> new BlockItem(ModBlocks.BLACK_TERRACOTTA_POT.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static void init() {
        ITEMS.initialize();
    }
}