package earth.terrarium.rustic.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.architectury.injectables.targets.ArchitecturyTarget;
import earth.terrarium.botarium.api.registry.fluid.BotariumLiquidBlock;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.blocks.*;
import earth.terrarium.rustic.common.blocks.cabinet.CabinetBlock;
import earth.terrarium.rustic.common.blocks.candle.CandleStickHolderLeverBlock;
import earth.terrarium.rustic.common.blocks.candle.CandleWallHolderLeverBlock;
import earth.terrarium.rustic.common.blocks.candle.CandleStickHolderBlock;
import earth.terrarium.rustic.common.blocks.candle.CandleWallHolderBlock;
import earth.terrarium.rustic.common.blocks.sign.CustomStandingSignBlock;
import earth.terrarium.rustic.common.blocks.sign.CustomWallSignBlock;
import earth.terrarium.rustic.common.world.grower.ModTreeGrower;
import earth.terrarium.rustic.mixin.WoodTypeInvoker;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class ModBlocks {
    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(Registry.BLOCK, Rustic.MOD_ID);
    public static final ResourcefulRegistry<Block> CLAY_WALLS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> BARRELS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> POTS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> FLUIDS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> PILLARS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> PAINTED_WOOD = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> SIGNS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> STANDING_SIGNS = ResourcefulRegistries.create(SIGNS);
    public static final ResourcefulRegistry<Block> CANDLE_HOLDERS = ResourcefulRegistries.create(BLOCKS);

    public static final WoodType IRONWOOD_SIGN_TYPE = WoodTypeInvoker.invokeRegister(new WoodType(ArchitecturyTarget.getCurrentTarget().equals("forge") ? "rustic:ironwood" : "ironwood"){});
    public static final WoodType OLIVEWOOD_SIGN_TYPE = WoodTypeInvoker.invokeRegister(new WoodType(ArchitecturyTarget.getCurrentTarget().equals("forge") ? "rustic:olivewood" : "olive"){});

    public static final RegistryEntry<Block> IRONWOOD_SIGN = STANDING_SIGNS.register("ironwood_sign", () -> new CustomStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), IRONWOOD_SIGN_TYPE));
    public static final RegistryEntry<Block> OLIVEWOOD_SIGN = STANDING_SIGNS.register("olivewood_sign", () -> new CustomStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), OLIVEWOOD_SIGN_TYPE));
    public static final ResourcefulRegistry<Block> WALL_SIGNS = ResourcefulRegistries.create(SIGNS);

    public static final RegistryEntry<Block> BLACK_PAINTED_WOOD = PAINTED_WOOD.register("black_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_BLACK)));
    public static final RegistryEntry<Block> BLUE_PAINTED_WOOD = PAINTED_WOOD.register("blue_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_BLUE)));
    public static final RegistryEntry<Block> BROWN_PAINTED_WOOD = PAINTED_WOOD.register("brown_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_BROWN)));
    public static final RegistryEntry<Block> CYAN_PAINTED_WOOD = PAINTED_WOOD.register("cyan_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_CYAN)));
    public static final RegistryEntry<Block> GRAY_PAINTED_WOOD = PAINTED_WOOD.register("gray_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_GRAY)));
    public static final RegistryEntry<Block> GREEN_PAINTED_WOOD = PAINTED_WOOD.register("green_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_GREEN)));
    public static final RegistryEntry<Block> LIGHT_BLUE_PAINTED_WOOD = PAINTED_WOOD.register("light_blue_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_LIGHT_BLUE)));
    public static final RegistryEntry<Block> LIGHT_GRAY_PAINTED_WOOD = PAINTED_WOOD.register("light_gray_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final RegistryEntry<Block> LIME_PAINTED_WOOD = PAINTED_WOOD.register("lime_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_LIGHT_GREEN)));
    public static final RegistryEntry<Block> MAGENTA_PAINTED_WOOD = PAINTED_WOOD.register("magenta_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_MAGENTA)));
    public static final RegistryEntry<Block> ORANGE_PAINTED_WOOD = PAINTED_WOOD.register("orange_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_ORANGE)));
    public static final RegistryEntry<Block> PINK_PAINTED_WOOD = PAINTED_WOOD.register("pink_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_PINK)));
    public static final RegistryEntry<Block> PURPLE_PAINTED_WOOD = PAINTED_WOOD.register("purple_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_PURPLE)));
    public static final RegistryEntry<Block> RED_PAINTED_WOOD = PAINTED_WOOD.register("red_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_RED)));
    public static final RegistryEntry<Block> WHITE_PAINTED_WOOD = PAINTED_WOOD.register("white_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryEntry<Block> YELLOW_PAINTED_WOOD = PAINTED_WOOD.register("yellow_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_YELLOW)));

    public static final RegistryEntry<Block> SLATE = BLOCKS.register("slate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryEntry<Block> SLATE_TILES = BLOCKS.register("slate_tiles", () -> new Block(BlockBehaviour.Properties.copy(SLATE.get())));
    public static final RegistryEntry<Block> SLATE_BRICKS = BLOCKS.register("slate_bricks", () -> new Block(BlockBehaviour.Properties.copy(SLATE.get())));
    public static final RegistryEntry<Block> POLISHED_SLATE = BLOCKS.register("polished_slate", () -> new Block(BlockBehaviour.Properties.copy(SLATE.get())));
    public static final RegistryEntry<Block> SLATE_ROOF = BLOCKS.register("slate_roof", () -> new Block(BlockBehaviour.Properties.copy(SLATE.get())));

    public static final RegistryEntry<Block> STONE_PILLAR = PILLARS.register("stone_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryEntry<Block> ANDESITE_PILLAR = PILLARS.register("andesite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));
    public static final RegistryEntry<Block> DIORITE_PILLAR = PILLARS.register("diorite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final RegistryEntry<Block> GRANITE_PILLAR = PILLARS.register("granite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE)));
    public static final RegistryEntry<Block> DEEPSLATE_PILLAR = PILLARS.register("deepslate_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryEntry<Block> SLATE_PILLAR = PILLARS.register("slate_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

    public static final RegistryEntry<Block> CLAY_WALL = CLAY_WALLS.register("clay_wall", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CLAY)));
    public static final RegistryEntry<Block> CLAY_CROSS_WALL = CLAY_WALLS.register("clay_cross_wall", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CLAY)));
    public static final RegistryEntry<Block> CLAY_DIAGONAL_LEFT_CROSS_WALL = CLAY_WALLS.register("clay_diagonal_left_cross_wall", () -> new CrossBlock(BlockBehaviour.Properties.copy(Blocks.CLAY)));
    public static final RegistryEntry<Block> CLAY_DIAGONAL_RIGHT_CROSS_WALL = CLAY_WALLS.register("clay_diagonal_right_cross_wall", () -> new CrossBlock(BlockBehaviour.Properties.copy(Blocks.CLAY)));
    public static final RegistryEntry<Block> IRONWOOD_WALL_SIGN = WALL_SIGNS.register("ironwood_wall_sign", () -> new CustomWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), IRONWOOD_SIGN_TYPE));
    public static final RegistryEntry<Block> OLIVEWOOD_WALL_SIGN = WALL_SIGNS.register("olivewood_wall_sign", () -> new CustomWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), OLIVEWOOD_SIGN_TYPE));

    public static final RegistryEntry<Block> IRONWOOD_PLANKS = BLOCKS.register("ironwood_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryEntry<Block> IRONWOOD_STAIRS = BLOCKS.register("ironwood_stairs", () -> new StairBlock(IRONWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryEntry<Block> IRONWOOD_LOG = BLOCKS.register("ironwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryEntry<Block> STRIPPED_IRONWOOD_LOG = BLOCKS.register("stripped_ironwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryEntry<Block> IRONWOOD_WOOD = BLOCKS.register("ironwood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryEntry<Block> IRONWOOD_LEAVES = BLOCKS.register("ironwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryEntry<Block> IRONWOOD_SAPLING = BLOCKS.register("ironwood_sapling", () -> new SaplingBlock(new ModTreeGrower(ModFeatures.IRONWOOD_KEY), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryEntry<Block> IRONWOOD_SLAB = BLOCKS.register("ironwood_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryEntry<Block> IRONWOOD_FENCE = BLOCKS.register("ironwood_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryEntry<Block> IRONWOOD_FENCE_GATE = BLOCKS.register("ironwood_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
    public static final RegistryEntry<Block> IRONWOOD_BUTTON = BLOCKS.register("ironwood_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)));
    public static final RegistryEntry<Block> IRONWOOD_PRESSURE_PLATE = BLOCKS.register("ironwood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryEntry<Block> IRONWOOD_DOOR = BLOCKS.register("ironwood_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)));
    public static final RegistryEntry<Block> IRONWOOD_TRAPDOOR = BLOCKS.register("ironwood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryEntry<Block> OLIVEWOOD_PLANKS = BLOCKS.register("olivewood_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryEntry<Block> OLIVEWOOD_STAIRS = BLOCKS.register("olivewood_stairs", () -> new StairBlock(OLIVEWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryEntry<Block> OLIVEWOOD_LOG = BLOCKS.register("olivewood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryEntry<Block> STRIPPED_OLIVEWOOD_LOG = BLOCKS.register("stripped_olivewood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryEntry<Block> OLIVEWOOD_WOOD = BLOCKS.register("olivewood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryEntry<Block> OLIVEWOOD_LEAVES = BLOCKS.register("olivewood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryEntry<Block> OLIVEWOOD_SAPLING = BLOCKS.register("olivewood_sapling", () -> new SaplingBlock(new ModTreeGrower(ModFeatures.OLIVEWOOD_KEY), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryEntry<Block> OLIVEWOOD_SLAB = BLOCKS.register("olivewood_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryEntry<Block> OLIVEWOOD_FENCE = BLOCKS.register("olivewood_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryEntry<Block> OLIVEWOOD_FENCE_GATE = BLOCKS.register("olivewood_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
    public static final RegistryEntry<Block> OLIVEWOOD_BUTTON = BLOCKS.register("olivewood_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)));
    public static final RegistryEntry<Block> OLIVEWOOD_PRESSURE_PLATE = BLOCKS.register("olivewood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryEntry<Block> OLIVEWOOD_DOOR = BLOCKS.register("olivewood_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)));
    public static final RegistryEntry<Block> OLIVEWOOD_TRAPDOOR = BLOCKS.register("olivewood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryEntry<Block> FERTILE_SOIL = BLOCKS.register("fertile_soil", () -> new FertileSoilBlock(BlockBehaviour.Properties.copy(Blocks.FARMLAND)));
    public static final RegistryEntry<Block> CRUSHING_TUB = BLOCKS.register("crushing_tub", () -> new CrushingTubBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryEntry<Block> ALCHEMIC_CONDENSER = BLOCKS.register("alchemic_condenser", () -> new AlchemicCondenserBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)));

    public static final RegistryEntry<Block> ACACIA_BARREL = BARRELS.register("acacia_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistryEntry<Block> BIRCH_BARREL = BARRELS.register("birch_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryEntry<Block> CRIMSON_BARREL = BARRELS.register("crimson_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryEntry<Block> DARK_OAK_BARREL = BARRELS.register("dark_oak_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryEntry<Block> IRONWOOD_BARREL = BARRELS.register("ironwood_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryEntry<Block> JUNGLE_BARREL = BARRELS.register("jungle_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistryEntry<Block> MANGROVE_BARREL = BARRELS.register("mangrove_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistryEntry<Block> OAK_BARREL = BARRELS.register("oak_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryEntry<Block> OLIVEWOOD_BARREL = BARRELS.register("olivewood_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryEntry<Block> SPRUCE_BARREL = BARRELS.register("spruce_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryEntry<Block> WARPED_BARREL = BARRELS.register("warped_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    public static final RegistryEntry<Block> TERRACOTTA_POT = POTS.register("terracotta_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final RegistryEntry<Block> WHITE_TERRACOTTA_POT = POTS.register("white_terracotta_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final RegistryEntry<Block> RED_TERRACOTTA_POT = POTS.register("red_terracotta_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final RegistryEntry<Block> GREEN_TERRACOTTA_POT = POTS.register("green_terracotta_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final RegistryEntry<Block> BLUE_TERRACOTTA_POT = POTS.register("blue_terracotta_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final RegistryEntry<Block> BLACK_TERRACOTTA_POT = POTS.register("black_terracotta_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));

    public static final RegistryEntry<Block> GOLD_CHAIN = BLOCKS.register("gold_chain", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final RegistryEntry<Block> COPPER_CHAIN = BLOCKS.register("copper_chain", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final RegistryEntry<Block> GOLD_LANTERN = BLOCKS.register("gold_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryEntry<Block> COPPER_LANTERN = BLOCKS.register("copper_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryEntry<Block> GOLD_SOUL_LANTERN = BLOCKS.register("gold_soul_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_LANTERN)));
    public static final RegistryEntry<Block> COPPER_SOUL_LANTERN = BLOCKS.register("copper_soul_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_LANTERN)));

    public static final RegistryEntry<Block> SWEET_BERRY_JUICE = FLUIDS.register("sweet_berry_juice", () -> new BotariumLiquidBlock(ModFluidProperties.SWEET_BERRY_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> SWEET_BERRY_WINE = FLUIDS.register("sweet_berry_wine", () -> new BotariumLiquidBlock(ModFluidProperties.SWEET_BERRY_WINE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> SUGAR_WATER = FLUIDS.register("sugar_water", () -> new BotariumLiquidBlock(ModFluidProperties.SUGAR_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> IRON_BERRY_JUICE = FLUIDS.register("iron_berry_juice", () -> new BotariumLiquidBlock(ModFluidProperties.IRON_BERRY_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> IRON_BERRY_WINE = FLUIDS.register("iron_berry_wine", () -> new BotariumLiquidBlock(ModFluidProperties.IRON_BERRY_WINE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> GRAPE_JUICE = FLUIDS.register("grape_juice", () -> new BotariumLiquidBlock(ModFluidProperties.GRAPE_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> RED_WINE = FLUIDS.register("red_wine", () -> new BotariumLiquidBlock(ModFluidProperties.RED_WINE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> APPLE_JUICE = FLUIDS.register("apple_juice", () -> new BotariumLiquidBlock(ModFluidProperties.APPLE_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> OLIVE_OIL = FLUIDS.register("olive_oil", () -> new BotariumLiquidBlock(ModFluidProperties.OLIVE_OIL, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> HONEY = FLUIDS.register("honey", () -> new BotariumLiquidBlock(ModFluidProperties.HONEY, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> CIDER = FLUIDS.register("cider", () -> new BotariumLiquidBlock(ModFluidProperties.CIDER, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> RUM = FLUIDS.register("rum", () -> new BotariumLiquidBlock(ModFluidProperties.RUM, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> STARCHY_WATER = FLUIDS.register("starchy_water", () -> new BotariumLiquidBlock(ModFluidProperties.STARCHY_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> ALE = FLUIDS.register("ale", () -> new BotariumLiquidBlock(ModFluidProperties.ALE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> MEAD = FLUIDS.register("mead", () -> new BotariumLiquidBlock(ModFluidProperties.MEAD, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> VODKA = FLUIDS.register("vodka", () -> new BotariumLiquidBlock(ModFluidProperties.VODKA, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> WHISKEY = FLUIDS.register("whiskey", () -> new BotariumLiquidBlock(ModFluidProperties.WHISKEY, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryEntry<Block> TOMATO_JUICE = FLUIDS.register("tomato_juice", () -> new BotariumLiquidBlock(ModFluidProperties.TOMATO_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> CABINET = BLOCKS.register("cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));

    public static final RegistryEntry<Block> IRON_CANDLE_WALL_SCONCE = CANDLE_HOLDERS.register("iron_candle_wall_sconce", () -> new CandleWallHolderBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).noOcclusion().strength(0.5F).sound(SoundType.CANDLE)));
    public static final RegistryEntry<Block> GOLD_CANDLE_WALL_SCONCE = CANDLE_HOLDERS.register("gold_candle_wall_sconce", () -> new CandleWallHolderBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).noOcclusion().strength(0.5F).sound(SoundType.CANDLE)));
    public static final RegistryEntry<Block> COPPER_CANDLE_WALL_SCONCE = CANDLE_HOLDERS.register("copper_candle_wall_sconce", () -> new CandleWallHolderBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).noOcclusion().strength(0.5F).sound(SoundType.CANDLE)));
    public static final RegistryEntry<Block> IRON_CANDLE_WALL_SCONCE_LEVER = CANDLE_HOLDERS.register("iron_candle_wall_sconce_lever", () -> new CandleWallHolderLeverBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).noOcclusion().strength(0.5F).sound(SoundType.CANDLE)));
    public static final RegistryEntry<Block> GOLD_CANDLE_WALL_SCONCE_LEVER = CANDLE_HOLDERS.register("gold_candle_wall_sconce_lever", () -> new CandleWallHolderLeverBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).noOcclusion().strength(0.5F).sound(SoundType.CANDLE)));
    public static final RegistryEntry<Block> COPPER_CANDLE_WALL_SCONCE_LEVER = CANDLE_HOLDERS.register("copper_candle_wall_sconce_lever", () -> new CandleWallHolderLeverBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).noOcclusion().strength(0.5F).sound(SoundType.CANDLE)));

    public static final RegistryEntry<Block> IRON_CANDLE_HOLDER = CANDLE_HOLDERS.register("iron_candle_holder", () -> new CandleStickHolderBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).noOcclusion().strength(0.5F).sound(SoundType.CANDLE)));
    public static final RegistryEntry<Block> GOLD_CANDLE_HOLDER = CANDLE_HOLDERS.register("gold_candle_holder", () -> new CandleStickHolderBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).noOcclusion().strength(0.5F).sound(SoundType.CANDLE)));
    public static final RegistryEntry<Block> COPPER_CANDLE_HOLDER = CANDLE_HOLDERS.register("copper_candle_holder", () -> new CandleStickHolderBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).noOcclusion().strength(0.5F).sound(SoundType.CANDLE)));
    public static final RegistryEntry<Block> IRON_CANDLE_HOLDER_LEVER = CANDLE_HOLDERS.register("iron_candle_holder_lever", () -> new CandleStickHolderLeverBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).noOcclusion().strength(0.5F).sound(SoundType.CANDLE)));
    public static final RegistryEntry<Block> GOLD_CANDLE_HOLDER_LEVER = CANDLE_HOLDERS.register("gold_candle_holder_lever", () -> new CandleStickHolderLeverBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).noOcclusion().strength(0.5F).sound(SoundType.CANDLE)));
    public static final RegistryEntry<Block> COPPER_CANDLE_HOLDER_LEVER = CANDLE_HOLDERS.register("copper_candle_holder_lever", () -> new CandleStickHolderLeverBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).noOcclusion().strength(0.5F).sound(SoundType.CANDLE)));

}