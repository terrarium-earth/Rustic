package earth.terrarium.rustic.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.botarium.api.registry.fluid.FluidBucketItem;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.items.TomatoItem;
import earth.terrarium.rustic.common.items.PotionFlaskItem;
import earth.terrarium.rustic.common.util.PlatformUtils;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;

@SuppressWarnings("unused")
public class ModItems {
    public static final CreativeModeTab ITEM_GROUP = PlatformUtils.createTab(new ResourceLocation(Rustic.MOD_ID, "main"), () -> new ItemStack(Items.BOWL));
    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(Registry.ITEM, Rustic.MOD_ID);

    public static final ResourcefulRegistry<Item> PAINTED_WOOD = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> PILLARS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> CLAY_WALLS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> BARRELS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> POTS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> BUCKETS = ResourcefulRegistries.create(ITEMS);

    public static final RegistryEntry<Item> BLACK_PAINTED_WOOD = PAINTED_WOOD.register("black_painted_wood", () -> new BlockItem(ModBlocks.BLACK_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> BLUE_PAINTED_WOOD = PAINTED_WOOD.register("blue_painted_wood", () -> new BlockItem(ModBlocks.BLUE_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> BROWN_PAINTED_WOOD = PAINTED_WOOD.register("brown_painted_wood", () -> new BlockItem(ModBlocks.BROWN_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CYAN_PAINTED_WOOD = PAINTED_WOOD.register("cyan_painted_wood", () -> new BlockItem(ModBlocks.CYAN_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GRAY_PAINTED_WOOD = PAINTED_WOOD.register("gray_painted_wood", () -> new BlockItem(ModBlocks.GRAY_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GREEN_PAINTED_WOOD = PAINTED_WOOD.register("green_painted_wood", () -> new BlockItem(ModBlocks.GREEN_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> LIGHT_BLUE_PAINTED_WOOD = PAINTED_WOOD.register("light_blue_painted_wood", () -> new BlockItem(ModBlocks.LIGHT_BLUE_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> LIGHT_GRAY_PAINTED_WOOD = PAINTED_WOOD.register("light_gray_painted_wood", () -> new BlockItem(ModBlocks.LIGHT_GRAY_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> LIME_PAINTED_WOOD = PAINTED_WOOD.register("lime_painted_wood", () -> new BlockItem(ModBlocks.LIME_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MAGENTA_PAINTED_WOOD = PAINTED_WOOD.register("magenta_painted_wood", () -> new BlockItem(ModBlocks.MAGENTA_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> ORANGE_PAINTED_WOOD = PAINTED_WOOD.register("orange_painted_wood", () -> new BlockItem(ModBlocks.ORANGE_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> PINK_PAINTED_WOOD = PAINTED_WOOD.register("pink_painted_wood", () -> new BlockItem(ModBlocks.PINK_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> PURPLE_PAINTED_WOOD = PAINTED_WOOD.register("purple_painted_wood", () -> new BlockItem(ModBlocks.PURPLE_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> RED_PAINTED_WOOD = PAINTED_WOOD.register("red_painted_wood", () -> new BlockItem(ModBlocks.RED_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> WHITE_PAINTED_WOOD = PAINTED_WOOD.register("white_painted_wood", () -> new BlockItem(ModBlocks.WHITE_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> YELLOW_PAINTED_WOOD = PAINTED_WOOD.register("yellow_painted_wood", () -> new BlockItem(ModBlocks.YELLOW_PAINTED_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> SLATE = PILLARS.register("slate", () -> new BlockItem(ModBlocks.SLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> SLATE_TILES = PILLARS.register("slate_tiles", () -> new BlockItem(ModBlocks.SLATE_TILES.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> SLATE_BRICKS = PILLARS.register("slate_bricks", () -> new BlockItem(ModBlocks.SLATE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> SLATE_POLISHED = PILLARS.register("polished_slate", () -> new BlockItem(ModBlocks.POLISHED_SLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> SLATE_ROOF = PILLARS.register("slate_roof", () -> new BlockItem(ModBlocks.SLATE_ROOF.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> STONE_PILLAR = PILLARS.register("stone_pillar", () -> new BlockItem(ModBlocks.STONE_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> ANDESITE_PILLAR = PILLARS.register("andesite_pillar", () -> new BlockItem(ModBlocks.ANDESITE_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DIORITE_PILLAR = PILLARS.register("diorite_pillar", () -> new BlockItem(ModBlocks.DIORITE_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GRANITE_PILLAR = PILLARS.register("granite_pillar", () -> new BlockItem(ModBlocks.GRANITE_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DEEPSLATE_PILLAR = PILLARS.register("deepslate_pillar", () -> new BlockItem(ModBlocks.DEEPSLATE_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> SLATE_PILLAR = PILLARS.register("slate_pillar", () -> new BlockItem(ModBlocks.SLATE_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> CLAY_WALL = CLAY_WALLS.register("clay_wall", () -> new BlockItem(ModBlocks.CLAY_WALL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CLAY_CROSS_WALL = CLAY_WALLS.register("clay_cross_wall", () -> new BlockItem(ModBlocks.CLAY_CROSS_WALL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CLAY_DIAGONAL_CROSS_WALL = CLAY_WALLS.register("clay_diagonal_cross_wall", () -> new BlockItem(ModBlocks.CLAY_DIAGONAL_LEFT_CROSS_WALL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> ACACIA_BARREL = BARRELS.register("acacia_fluid_barrel", () -> new BlockItem(ModBlocks.ACACIA_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> BIRCH_BARREL = BARRELS.register("birch_fluid_barrel", () -> new BlockItem(ModBlocks.BIRCH_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CRIMSON_BARREL = BARRELS.register("crimson_fluid_barrel", () -> new BlockItem(ModBlocks.CRIMSON_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DARK_OAK_BARREL = BARRELS.register("dark_oak_fluid_barrel", () -> new BlockItem(ModBlocks.DARK_OAK_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> JUNGLE_BARREL = BARRELS.register("jungle_fluid_barrel", () -> new BlockItem(ModBlocks.JUNGLE_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MANGROVE_BARREL = BARRELS.register("mangrove_fluid_barrel", () -> new BlockItem(ModBlocks.MANGROVE_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OAK_BARREL = BARRELS.register("oak_fluid_barrel", () -> new BlockItem(ModBlocks.OAK_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_BARREL = BARRELS.register("ironwood_fluid_barrel", () -> new BlockItem(ModBlocks.IRONWOOD_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_BARREL = BARRELS.register("olivewood_fluid_barrel", () -> new BlockItem(ModBlocks.OLIVEWOOD_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> SPRUCE_BARREL = BARRELS.register("spruce_fluid_barrel", () -> new BlockItem(ModBlocks.SPRUCE_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> WARPED_BARREL = BARRELS.register("warped_fluid_barrel", () -> new BlockItem(ModBlocks.WARPED_BARREL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> TERRACOTTA_POT = POTS.register("terracotta_pot", () -> new BlockItem(ModBlocks.TERRACOTTA_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> WHITE_TERRACOTTA_POT = POTS.register("white_terracotta_pot", () -> new BlockItem(ModBlocks.WHITE_TERRACOTTA_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> RED_TERRACOTTA_POT = POTS.register("red_terracotta_pot", () -> new BlockItem(ModBlocks.RED_TERRACOTTA_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GREEN_TERRACOTTA_POT = POTS.register("green_terracotta_pot", () -> new BlockItem(ModBlocks.GREEN_TERRACOTTA_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> BLUE_TERRACOTTA_POT = POTS.register("blue_terracotta_pot", () -> new BlockItem(ModBlocks.BLUE_TERRACOTTA_POT.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> BLACK_TERRACOTTA_POT = POTS.register("black_terracotta_pot", () -> new BlockItem(ModBlocks.BLACK_TERRACOTTA_POT.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> SWEET_BERRY_JUICE_BUCKET = BUCKETS.register("sweet_berry_juice_bucket", () -> new FluidBucketItem(ModFluidProperties.SWEET_BERRY_JUICE, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> SWEET_BERRY_WINE_BUCKET = BUCKETS.register("sweet_berry_wine_bucket", () -> new FluidBucketItem(ModFluidProperties.SWEET_BERRY_WINE, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> SUGAR_WATER_BUCKET = BUCKETS.register("sugar_water_bucket", () -> new FluidBucketItem(ModFluidProperties.SUGAR_WATER, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> IRON_BERRY_JUICE_BUCKET = BUCKETS.register("iron_berry_juice_bucket", () -> new FluidBucketItem(ModFluidProperties.IRON_BERRY_JUICE, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> IRON_BERRY_WINE_BUCKET = BUCKETS.register("iron_berry_wine_bucket", () -> new FluidBucketItem(ModFluidProperties.IRON_BERRY_WINE, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> GRAPE_JUICE_BUCKET = BUCKETS.register("grape_juice_bucket", () -> new FluidBucketItem(ModFluidProperties.GRAPE_JUICE, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> RED_WINE_BUCKET = BUCKETS.register("red_wine_bucket", () -> new FluidBucketItem(ModFluidProperties.RED_WINE, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> APPLE_JUICE_BUCKET = BUCKETS.register("apple_juice_bucket", () -> new FluidBucketItem(ModFluidProperties.APPLE_JUICE, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> OLIVE_OIL_BUCKET = BUCKETS.register("olive_oil_bucket", () -> new FluidBucketItem(ModFluidProperties.OLIVE_OIL, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> HONEY_BUCKET = BUCKETS.register("honey_bucket", () -> new FluidBucketItem(ModFluidProperties.HONEY, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> CIDER_BUCKET = BUCKETS.register("cider_bucket", () -> new FluidBucketItem(ModFluidProperties.CIDER, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> RUM_BUCKET = BUCKETS.register("rum_bucket", () -> new FluidBucketItem(ModFluidProperties.RUM, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> STARCHY_WATER_BUCKET = BUCKETS.register("starchy_water_bucket", () -> new FluidBucketItem(ModFluidProperties.STARCHY_WATER, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> ALE_BUCKET = BUCKETS.register("ale_bucket", () -> new FluidBucketItem(ModFluidProperties.ALE, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> MEAD_BUCKET = BUCKETS.register("mead_bucket", () -> new FluidBucketItem(ModFluidProperties.MEAD, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> VODKA_BUCKET = BUCKETS.register("vodka_bucket", () -> new FluidBucketItem(ModFluidProperties.VODKA, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> WHISKEY_BUCKET = BUCKETS.register("whiskey_bucket", () -> new FluidBucketItem(ModFluidProperties.WHISKEY, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> TOMATO_JUICE_BUCKET = BUCKETS.register("tomato_juice_bucket", () -> new FluidBucketItem(ModFluidProperties.TOMATO_JUICE, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryEntry<Item> IRONBERRIES = ITEMS.register("ironberries", () -> new Item(new Item.Properties().tab(ITEM_GROUP).food(Foods.SWEET_BERRIES)));
    public static final RegistryEntry<Item> OLIVES = ITEMS.register("olives", () -> new Item(new Item.Properties().tab(ITEM_GROUP).food(Foods.SWEET_BERRIES)));
    public static final RegistryEntry<Item> TOMATO = ITEMS.register("tomato", () -> new TomatoItem(new Item.Properties().tab(ITEM_GROUP).food(Foods.SWEET_BERRIES)));
    public static final RegistryEntry<Item> CHILI_PEPPER = ITEMS.register("chili_pepper", () -> new Item(new Item.Properties().tab(ITEM_GROUP).food(Foods.SWEET_BERRIES)));
    public static final RegistryEntry<Item> GRAPES = ITEMS.register("grapes", () -> new Item(new Item.Properties().tab(ITEM_GROUP).food(Foods.SWEET_BERRIES)));
    public static final RegistryEntry<Item> FLASK = ITEMS.register("flask", () -> new PotionFlaskItem(new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> IRONWOOD_PLANKS = ITEMS.register("ironwood_planks", () -> new BlockItem(ModBlocks.IRONWOOD_PLANKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_LOG = ITEMS.register("ironwood_log", () -> new BlockItem(ModBlocks.IRONWOOD_LOG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STRIPPED_IRONWOOD_LOG = ITEMS.register("stripped_ironwood_log", () -> new BlockItem(ModBlocks.STRIPPED_IRONWOOD_LOG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_WOOD = ITEMS.register("ironwood_wood", () -> new BlockItem(ModBlocks.IRONWOOD_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_LEAVES = ITEMS.register("ironwood_leaves", () -> new BlockItem(ModBlocks.IRONWOOD_LEAVES.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_SAPLING = ITEMS.register("ironwood_sapling", () -> new BlockItem(ModBlocks.IRONWOOD_SAPLING.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_STAIRS = ITEMS.register("ironwood_stairs", () -> new BlockItem(ModBlocks.IRONWOOD_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_SLAB = ITEMS.register("ironwood_slab", () -> new BlockItem(ModBlocks.IRONWOOD_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_FENCE = ITEMS.register("ironwood_fence", () -> new BlockItem(ModBlocks.IRONWOOD_FENCE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_FENCE_GATE = ITEMS.register("ironwood_fence_gate", () -> new BlockItem(ModBlocks.IRONWOOD_FENCE_GATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_BUTTON = ITEMS.register("ironwood_button", () -> new BlockItem(ModBlocks.IRONWOOD_BUTTON.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_PRESSURE_PLATE = ITEMS.register("ironwood_pressure_plate", () -> new BlockItem(ModBlocks.IRONWOOD_PRESSURE_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_DOOR = ITEMS.register("ironwood_door", () -> new BlockItem(ModBlocks.IRONWOOD_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_TRAPDOOR = ITEMS.register("ironwood_trapdoor", () -> new BlockItem(ModBlocks.IRONWOOD_TRAPDOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRONWOOD_SIGN = ITEMS.register("ironwood_sign", () -> new SignItem(new Item.Properties().tab(ITEM_GROUP), ModBlocks.IRONWOOD_SIGN.get(), ModBlocks.IRONWOOD_WALL_SIGN.get()));
    public static final RegistryEntry<Item> OLIVEWOOD_PLANKS = ITEMS.register("olivewood_planks", () -> new BlockItem(ModBlocks.OLIVEWOOD_PLANKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_LOG = ITEMS.register("olivewood_log", () -> new BlockItem(ModBlocks.OLIVEWOOD_LOG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STRIPPED_OLIVEWOOD_LOG = ITEMS.register("stripped_olivewood_log", () -> new BlockItem(ModBlocks.STRIPPED_OLIVEWOOD_LOG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_WOOD = ITEMS.register("olivewood_wood", () -> new BlockItem(ModBlocks.OLIVEWOOD_WOOD.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_LEAVES = ITEMS.register("olivewood_leaves", () -> new BlockItem(ModBlocks.OLIVEWOOD_LEAVES.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_SAPLING = ITEMS.register("olivewood_sapling", () -> new BlockItem(ModBlocks.OLIVEWOOD_SAPLING.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_STAIRS = ITEMS.register("olivewood_stairs", () -> new BlockItem(ModBlocks.OLIVEWOOD_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_SLAB = ITEMS.register("olivewood_slab", () -> new BlockItem(ModBlocks.OLIVEWOOD_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_FENCE = ITEMS.register("olivewood_fence", () -> new BlockItem(ModBlocks.OLIVEWOOD_FENCE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_FENCE_GATE = ITEMS.register("olivewood_fence_gate", () -> new BlockItem(ModBlocks.OLIVEWOOD_FENCE_GATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_BUTTON = ITEMS.register("olivewood_button", () -> new BlockItem(ModBlocks.OLIVEWOOD_BUTTON.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_PRESSURE_PLATE = ITEMS.register("olivewood_pressure_plate", () -> new BlockItem(ModBlocks.OLIVEWOOD_PRESSURE_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_DOOR = ITEMS.register("olivewood_door", () -> new BlockItem(ModBlocks.OLIVEWOOD_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_TRAPDOOR = ITEMS.register("olivewood_trapdoor", () -> new BlockItem(ModBlocks.OLIVEWOOD_TRAPDOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OLIVEWOOD_SIGN = ITEMS.register("olivewood_sign", () -> new SignItem(new Item.Properties().tab(ITEM_GROUP), ModBlocks.OLIVEWOOD_SIGN.get(), ModBlocks.OLIVEWOOD_WALL_SIGN.get()));

    public static final RegistryEntry<Item> GOLD_CHAIN = ITEMS.register("gold_chain", () -> new BlockItem(ModBlocks.GOLD_CHAIN.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> COPPER_CHAIN = ITEMS.register("copper_chain", () -> new BlockItem(ModBlocks.COPPER_CHAIN.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GOLD_LANTERN = ITEMS.register("gold_lantern", () -> new BlockItem(ModBlocks.GOLD_LANTERN.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> COPPER_LANTERN = ITEMS.register("copper_lantern", () -> new BlockItem(ModBlocks.COPPER_LANTERN.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GOLD_SOUL_LANTERN = ITEMS.register("gold_soul_lantern", () -> new BlockItem(ModBlocks.GOLD_SOUL_LANTERN.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> COPPER_SOUL_LANTERN = ITEMS.register("copper_soul_lantern", () -> new BlockItem(ModBlocks.COPPER_SOUL_LANTERN.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> CRUSHING_TUB = ITEMS.register("crushing_tub", () -> new BlockItem(ModBlocks.CRUSHING_TUB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> ALCHEMIC_CONDENSER = ITEMS.register("alchemic_condenser", () -> new BlockItem(ModBlocks.ALCHEMIC_CONDENSER.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> FERTILE_SOIL = ITEMS.register("fertile_soil", () -> new BlockItem(ModBlocks.FERTILE_SOIL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> CABINET = ITEMS.register("cabinet", () -> new BlockItem(ModBlocks.CABINET.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> IRON_CANDLE_HOLDER = ITEMS.register("iron_candle_holder", () -> new StandingAndWallBlockItem(ModBlocks.IRON_CANDLE_HOLDER.get(), ModBlocks.IRON_CANDLE_WALL_SCONCE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GOLD_CANDLE_HOLDER = ITEMS.register("gold_candle_holder", () -> new StandingAndWallBlockItem(ModBlocks.GOLD_CANDLE_HOLDER.get(), ModBlocks.GOLD_CANDLE_WALL_SCONCE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> COPPER_CANDLE_HOLDER = ITEMS.register("copper_candle_holder", () -> new StandingAndWallBlockItem(ModBlocks.COPPER_CANDLE_HOLDER.get(), ModBlocks.COPPER_CANDLE_WALL_SCONCE.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> IRON_CANDLE_HOLDER_LEVER = ITEMS.register("iron_candle_holder_lever", () -> new StandingAndWallBlockItem(ModBlocks.IRON_CANDLE_HOLDER_LEVER.get(), ModBlocks.IRON_CANDLE_WALL_SCONCE_LEVER.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GOLD_CANDLE_HOLDER_LEVER = ITEMS.register("gold_candle_holder_lever", () -> new StandingAndWallBlockItem(ModBlocks.GOLD_CANDLE_HOLDER_LEVER.get(), ModBlocks.GOLD_CANDLE_WALL_SCONCE_LEVER.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> COPPER_CANDLE_HOLDER_LEVER = ITEMS.register("copper_candle_holder_lever", () -> new StandingAndWallBlockItem(ModBlocks.COPPER_CANDLE_HOLDER_LEVER.get(), ModBlocks.COPPER_CANDLE_WALL_SCONCE_LEVER.get(), new Item.Properties().tab(ITEM_GROUP)));

}