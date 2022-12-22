package earth.terrarium.rustic.common.registry;

import dev.architectury.injectables.targets.ArchitecturyTarget;
import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.botarium.api.registry.fluid.BotariumLiquidBlock;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.blocks.CrushingTubBlock;
import earth.terrarium.rustic.common.blocks.FluidBarrelBlock;
import earth.terrarium.rustic.common.blocks.PotBlock;
import earth.terrarium.rustic.common.world.level.block.grower.ModTreeGrower;
import earth.terrarium.rustic.mixin.WoodTypeInvoker;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryHolder<Block> BLOCKS = new RegistryHolder<>(Registry.BLOCK, Rustic.MOD_ID);

    public static final WoodType IRONWOOD_SIGN_TYPE = WoodTypeInvoker.invokeRegister(WoodTypeInvoker.init(ArchitecturyTarget.getCurrentTarget().equals("forge") ? "rustic:ironwood" : "ironwood"));
    public static final WoodType OLIVEWOOD_SIGN_TYPE = WoodTypeInvoker.invokeRegister(WoodTypeInvoker.init(ArchitecturyTarget.getCurrentTarget().equals("forge") ? "rustic:olivewood" : "olive"));

    public static final Supplier<Block> BLACK_PAINTED_WOOD = BLOCKS.register("black_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_BLACK)));
    public static final Supplier<Block> BLUE_PAINTED_WOOD = BLOCKS.register("blue_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_BLUE)));
    public static final Supplier<Block> BROWN_PAINTED_WOOD = BLOCKS.register("brown_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_BROWN)));
    public static final Supplier<Block> CYAN_PAINTED_WOOD = BLOCKS.register("cyan_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_CYAN)));
    public static final Supplier<Block> GRAY_PAINTED_WOOD = BLOCKS.register("gray_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_GRAY)));
    public static final Supplier<Block> GREEN_PAINTED_WOOD = BLOCKS.register("green_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_GREEN)));
    public static final Supplier<Block> LIGHT_BLUE_PAINTED_WOOD = BLOCKS.register("light_blue_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_LIGHT_BLUE)));
    public static final Supplier<Block> LIGHT_GRAY_PAINTED_WOOD = BLOCKS.register("light_gray_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final Supplier<Block> LIME_PAINTED_WOOD = BLOCKS.register("lime_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_LIGHT_GREEN)));
    public static final Supplier<Block> MAGENTA_PAINTED_WOOD = BLOCKS.register("magenta_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_MAGENTA)));
    public static final Supplier<Block> ORANGE_PAINTED_WOOD = BLOCKS.register("orange_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_ORANGE)));
    public static final Supplier<Block> PINK_PAINTED_WOOD = BLOCKS.register("pink_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_PINK)));
    public static final Supplier<Block> PURPLE_PAINTED_WOOD = BLOCKS.register("purple_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_PURPLE)));
    public static final Supplier<Block> RED_PAINTED_WOOD = BLOCKS.register("red_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_RED)));
    public static final Supplier<Block> WHITE_PAINTED_WOOD = BLOCKS.register("white_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> YELLOW_PAINTED_WOOD = BLOCKS.register("yellow_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_YELLOW)));

    public static final Supplier<Block> IRONWOOD_PLANKS = BLOCKS.register("ironwood_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> IRONWOOD_LOG = BLOCKS.register("ironwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final Supplier<Block> IRONWOOD_STRIPPED_LOG = BLOCKS.register("ironwood_stripped_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Supplier<Block> IRONWOOD_WOOD = BLOCKS.register("ironwood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final Supplier<Block> IRONWOOD_LEAVES = BLOCKS.register("ironwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final Supplier<Block> IRONWOOD_SAPLING = BLOCKS.register("ironwood_sapling", () -> new SaplingBlock(new ModTreeGrower(ModFeatures.IRONWOOD_KEY), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)) {});
    public static final Supplier<Block> IRONWOOD_STAIRS = BLOCKS.register("ironwood_stairs", () -> new StairBlock(IRONWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)) {});
    public static final Supplier<Block> IRONWOOD_SLAB = BLOCKS.register("ironwood_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final Supplier<Block> IRONWOOD_FENCE = BLOCKS.register("ironwood_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final Supplier<Block> IRONWOOD_FENCE_GATE = BLOCKS.register("ironwood_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
    public static final Supplier<Block> IRONWOOD_BUTTON = BLOCKS.register("ironwood_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)) {});
    public static final Supplier<Block> IRONWOOD_PRESSURE_PLATE = BLOCKS.register("ironwood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)) {});
    public static final Supplier<Block> IRONWOOD_DOOR = BLOCKS.register("ironwood_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)) {});
    public static final Supplier<Block> IRONWOOD_TRAPDOOR = BLOCKS.register("ironwood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)) {});
    public static final Supplier<Block> IRONWOOD_SIGN = BLOCKS.register("ironwood_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), IRONWOOD_SIGN_TYPE));
    public static final Supplier<Block> IRONWOOD_WALL_SIGN = BLOCKS.register("ironwood_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), IRONWOOD_SIGN_TYPE));

    public static final Supplier<Block> OLIVEWOOD_PLANKS = BLOCKS.register("olivewood_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> OLIVEWOOD_LOG = BLOCKS.register("olivewood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final Supplier<Block> OLIVEWOOD_STRIPPED_LOG = BLOCKS.register("olivewood_stripped_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Supplier<Block> OLIVEWOOD_WOOD = BLOCKS.register("olivewood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final Supplier<Block> OLIVEWOOD_LEAVES = BLOCKS.register("olivewood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final Supplier<Block> OLIVEWOOD_SAPLING = BLOCKS.register("olivewood_sapling", () -> new SaplingBlock(new ModTreeGrower(ModFeatures.OLIVEWOOD_KEY), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)) {});
    public static final Supplier<Block> OLIVEWOOD_STAIRS = BLOCKS.register("olivewood_stairs", () -> new StairBlock(OLIVEWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)) {});
    public static final Supplier<Block> OLIVEWOOD_SLAB = BLOCKS.register("olivewood_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final Supplier<Block> OLIVEWOOD_FENCE = BLOCKS.register("olivewood_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final Supplier<Block> OLIVEWOOD_FENCE_GATE = BLOCKS.register("olivewood_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
    public static final Supplier<Block> OLIVEWOOD_BUTTON = BLOCKS.register("olivewood_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)) {});
    public static final Supplier<Block> OLIVEWOOD_PRESSURE_PLATE = BLOCKS.register("olivewood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)) {});
    public static final Supplier<Block> OLIVEWOOD_DOOR = BLOCKS.register("olivewood_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)) {});
    public static final Supplier<Block> OLIVEWOOD_TRAPDOOR = BLOCKS.register("olivewood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)) {});
    public static final Supplier<Block> OLIVEWOOD_SIGN = BLOCKS.register("olivewood_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), OLIVEWOOD_SIGN_TYPE));
    public static final Supplier<Block> OLIVEWOOD_WALL_SIGN = BLOCKS.register("olivewood_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), OLIVEWOOD_SIGN_TYPE));

    public static final Supplier<Block> GOLD_CHAIN = BLOCKS.register("gold_chain", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final Supplier<Block> COPPER_CHAIN = BLOCKS.register("copper_chain", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final Supplier<Block> GOLD_LANTERN = BLOCKS.register("gold_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final Supplier<Block> COPPER_LANTERN = BLOCKS.register("copper_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));

    public static final Supplier<Block> STONE_PILLAR = BLOCKS.register("stone_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final Supplier<Block> ANDESITE_PILLAR = BLOCKS.register("andesite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));
    public static final Supplier<Block> DIORITE_PILLAR = BLOCKS.register("diorite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final Supplier<Block> GRANITE_PILLAR = BLOCKS.register("granite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE)));
    public static final Supplier<Block> DEEPSLATE_PILLAR = BLOCKS.register("deepslate_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

    public static final Supplier<Block> CLAY_WALL = BLOCKS.register("clay_wall", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CLAY)));
    public static final Supplier<Block> CLAY_CROSS_WALL = BLOCKS.register("clay_cross_wall", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CLAY)));
    public static final Supplier<Block> CLAY_DIAGONAL_LEFT_CROSS_WALL = BLOCKS.register("clay_diagonal_left_cross_wall", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CLAY)));
    public static final Supplier<Block> CLAY_DIAGONAL_RIGHT_CROSS_WALL = BLOCKS.register("clay_diagonal_right_cross_wall", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CLAY)));

    public static final Supplier<Block> CRUSHING_TUB = BLOCKS.register("crushing_tub", () -> new CrushingTubBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> ACACIA_BARREL = BLOCKS.register("acacia_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> BIRCH_BARREL = BLOCKS.register("birch_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> CRIMSON_BARREL = BLOCKS.register("crimson_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> DARK_OAK_BARREL = BLOCKS.register("dark_oak_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> IRONWOOD_BARREL = BLOCKS.register("ironwood_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> JUNGLE_BARREL = BLOCKS.register("jungle_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> MANGROVE_BARREL = BLOCKS.register("mangrove_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> OAK_BARREL = BLOCKS.register("oak_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> OLIVEWOOD_BARREL = BLOCKS.register("olivewood_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_BARREL = BLOCKS.register("spruce_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> WARPED_BARREL = BLOCKS.register("warped_fluid_barrel", () -> new FluidBarrelBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    public static final Supplier<Block> TERRACOTTA_POT = BLOCKS.register("terracotta_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final Supplier<Block> WHITE_TERRACOTTA_POT = BLOCKS.register("white_terracotta_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final Supplier<Block> RED_TERRACOTTA_POT = BLOCKS.register("red_terracotta_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final Supplier<Block> GREEN_TERRACOTTA_POT = BLOCKS.register("green_terracotta_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final Supplier<Block> BLUE_TERRACOTTA_POT = BLOCKS.register("blue_terracotta_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final Supplier<Block> BLACK_TERRACOTTA_POT = BLOCKS.register("black_terracotta_pot", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));

    public static final Supplier<Block> SWEET_BERRY_JUICE = BLOCKS.register("sweet_berry_juice", () -> new BotariumLiquidBlock(ModFluidProperties.SWEET_BERRY_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> SWEET_BERRY_WINE = BLOCKS.register("sweet_berry_wine", () -> new BotariumLiquidBlock(ModFluidProperties.SWEET_BERRY_WINE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> SUGAR_WATER = BLOCKS.register("sugar_water", () -> new BotariumLiquidBlock(ModFluidProperties.SUGAR_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> IRON_BERRY_JUICE = BLOCKS.register("iron_berry_juice", () -> new BotariumLiquidBlock(ModFluidProperties.IRON_BERRY_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> IRON_BERRY_WINE = BLOCKS.register("iron_berry_wine", () -> new BotariumLiquidBlock(ModFluidProperties.IRON_BERRY_WINE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> GRAPE_JUICE = BLOCKS.register("grape_juice", () -> new BotariumLiquidBlock(ModFluidProperties.GRAPE_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> RED_WINE = BLOCKS.register("red_wine", () -> new BotariumLiquidBlock(ModFluidProperties.RED_WINE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> APPLE_JUICE = BLOCKS.register("apple_juice", () -> new BotariumLiquidBlock(ModFluidProperties.APPLE_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> OLIVE_OIL = BLOCKS.register("olive_oil", () -> new BotariumLiquidBlock(ModFluidProperties.OLIVE_OIL, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> HONEY = BLOCKS.register("honey", () -> new BotariumLiquidBlock(ModFluidProperties.HONEY, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> CIDER = BLOCKS.register("cider", () -> new BotariumLiquidBlock(ModFluidProperties.CIDER, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> RUM = BLOCKS.register("rum", () -> new BotariumLiquidBlock(ModFluidProperties.RUM, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> STARCHY_WATER = BLOCKS.register("starchy_water", () -> new BotariumLiquidBlock(ModFluidProperties.STARCHY_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> ALE = BLOCKS.register("ale", () -> new BotariumLiquidBlock(ModFluidProperties.ALE, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> MEAD = BLOCKS.register("mead", () -> new BotariumLiquidBlock(ModFluidProperties.MEAD, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> VODKA = BLOCKS.register("vodka", () -> new BotariumLiquidBlock(ModFluidProperties.VODKA, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> WHISKEY = BLOCKS.register("whiskey", () -> new BotariumLiquidBlock(ModFluidProperties.WHISKEY, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<Block> TOMATO_JUICE = BLOCKS.register("tomato_juice", () -> new BotariumLiquidBlock(ModFluidProperties.TOMATO_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
}