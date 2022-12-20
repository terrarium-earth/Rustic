package earth.terrarium.rustic.common.registry;

import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.rustic.Rustic;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

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

    public static final Supplier<Item> IRONWOOD_PLANKS = ITEMS.register("ironwood_planks", () -> new BlockItem(ModBlocks.IRONWOOD_PLANKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_PLANKS = ITEMS.register("olivewood_planks", () -> new BlockItem(ModBlocks.OLIVEWOOD_PLANKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> IRONWOOD_LOG = ITEMS.register("ironwood_log", () -> new BlockItem(ModBlocks.IRONWOOD_LOG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final Supplier<Item> OLIVEWOOD_LOG = ITEMS.register("olivewood_log", () -> new BlockItem(ModBlocks.OLIVEWOOD_LOG.get(), new Item.Properties().tab(ITEM_GROUP)));

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


    public static void init() {
        ITEMS.initialize();
    }
}