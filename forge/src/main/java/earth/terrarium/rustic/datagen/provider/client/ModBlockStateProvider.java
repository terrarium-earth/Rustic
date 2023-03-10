package earth.terrarium.rustic.datagen.provider.client;

import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.blocks.cabinet.CabinetBlock;
import earth.terrarium.rustic.common.blocks.cabinet.CabinetType;
import earth.terrarium.rustic.common.blocks.candle.CandleColor;
import earth.terrarium.rustic.common.blocks.candle.CandleHolderBlock;
import earth.terrarium.rustic.common.registry.ModBlocks;
import earth.terrarium.rustic.common.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    private static final ResourceLocation BARREL = new ResourceLocation(Rustic.MOD_ID, "block/fluid_barrel");
    private static final ResourceLocation TERRACOTTA_POT = new ResourceLocation(Rustic.MOD_ID, "block/pot");
    private static final ResourceLocation LEAVES = new ResourceLocation("block/leaves");
    private static final ResourceLocation WATER_STILL = new ResourceLocation("block/water_still");

    public ModBlockStateProvider(DataGenerator pGenerator, ExistingFileHelper exFileHelper) {
        super(pGenerator, Rustic.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.BLACK_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.BLUE_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.BROWN_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.CYAN_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.GRAY_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.GREEN_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.LIGHT_BLUE_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.LIGHT_GRAY_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.LIME_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.MAGENTA_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.ORANGE_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.PINK_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.PURPLE_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.RED_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.WHITE_PAINTED_WOOD.get());
        simpleBlock(ModBlocks.YELLOW_PAINTED_WOOD.get());

        simpleBlock(ModBlocks.IRONWOOD_PLANKS.get());
        simpleBlock(ModBlocks.OLIVEWOOD_PLANKS.get());
        logBlock((RotatedPillarBlock) ModBlocks.IRONWOOD_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.OLIVEWOOD_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_IRONWOOD_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_OLIVEWOOD_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.IRONWOOD_WOOD.get(), blockTexture(ModBlocks.IRONWOOD_LOG.get()), blockTexture(ModBlocks.IRONWOOD_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.OLIVEWOOD_WOOD.get(), blockTexture(ModBlocks.OLIVEWOOD_LOG.get()), blockTexture(ModBlocks.OLIVEWOOD_LOG.get()));
        stairsBlock((StairBlock) ModBlocks.IRONWOOD_STAIRS.get(), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()));
        stairsBlock((StairBlock) ModBlocks.OLIVEWOOD_STAIRS.get(), blockTexture(ModBlocks.OLIVEWOOD_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.IRONWOOD_SLAB.get(), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.OLIVEWOOD_SLAB.get(), blockTexture(ModBlocks.OLIVEWOOD_PLANKS.get()), blockTexture(ModBlocks.OLIVEWOOD_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlocks.IRONWOOD_FENCE.get(), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlocks.OLIVEWOOD_FENCE.get(), blockTexture(ModBlocks.OLIVEWOOD_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.IRONWOOD_FENCE_GATE.get(), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.OLIVEWOOD_FENCE_GATE.get(), blockTexture(ModBlocks.OLIVEWOOD_PLANKS.get()));
        doorBlock((DoorBlock) ModBlocks.IRONWOOD_DOOR.get(), extend(blockTexture(ModBlocks.IRONWOOD_DOOR.get()), "_bottom"), extend(blockTexture(ModBlocks.IRONWOOD_DOOR.get()), "_top"));
        doorBlock((DoorBlock) ModBlocks.OLIVEWOOD_DOOR.get(), extend(blockTexture(ModBlocks.OLIVEWOOD_DOOR.get()), "_bottom"), extend(blockTexture(ModBlocks.OLIVEWOOD_DOOR.get()), "_top"));
        trapdoorBlock((TrapDoorBlock) ModBlocks.IRONWOOD_TRAPDOOR.get(), blockTexture(ModBlocks.IRONWOOD_TRAPDOOR.get()), false);
        trapdoorBlock((TrapDoorBlock) ModBlocks.OLIVEWOOD_TRAPDOOR.get(), blockTexture(ModBlocks.OLIVEWOOD_TRAPDOOR.get()), false);
        signBlock((StandingSignBlock) ModBlocks.IRONWOOD_SIGN.get(), (WallSignBlock) ModBlocks.IRONWOOD_WALL_SIGN.get(), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()));
        signBlock((StandingSignBlock) ModBlocks.OLIVEWOOD_SIGN.get(), (WallSignBlock) ModBlocks.OLIVEWOOD_WALL_SIGN.get(), blockTexture(ModBlocks.OLIVEWOOD_PLANKS.get()));
        buttonBlock((WoodButtonBlock) ModBlocks.IRONWOOD_BUTTON.get(), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()));
        buttonBlock((WoodButtonBlock) ModBlocks.OLIVEWOOD_BUTTON.get(), blockTexture(ModBlocks.OLIVEWOOD_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.IRONWOOD_PRESSURE_PLATE.get(), blockTexture(ModBlocks.IRONWOOD_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.OLIVEWOOD_PRESSURE_PLATE.get(), blockTexture(ModBlocks.OLIVEWOOD_PLANKS.get()));

        block(ModBlocks.IRONWOOD_LEAVES.get(), LEAVES, "all");
        block(ModBlocks.OLIVEWOOD_LEAVES.get(), LEAVES, "all");

        logBlock((RotatedPillarBlock) ModBlocks.STONE_PILLAR.get());
        axisBlock((RotatedPillarBlock) ModBlocks.ANDESITE_PILLAR.get(), blockTexture(ModBlocks.ANDESITE_PILLAR.get()), blockTexture(Blocks.POLISHED_ANDESITE));
        axisBlock((RotatedPillarBlock) ModBlocks.DIORITE_PILLAR.get(), blockTexture(ModBlocks.DIORITE_PILLAR.get()), blockTexture(Blocks.POLISHED_DIORITE));
        axisBlock((RotatedPillarBlock) ModBlocks.GRANITE_PILLAR.get(), blockTexture(ModBlocks.GRANITE_PILLAR.get()), blockTexture(Blocks.POLISHED_GRANITE));
        axisBlock((RotatedPillarBlock) ModBlocks.DEEPSLATE_PILLAR.get(), blockTexture(ModBlocks.DEEPSLATE_PILLAR.get()), blockTexture(Blocks.POLISHED_DEEPSLATE));
        axisBlock((RotatedPillarBlock) ModBlocks.SLATE_PILLAR.get(), blockTexture(ModBlocks.SLATE_PILLAR.get()), blockTexture(ModBlocks.POLISHED_SLATE.get()));

        axisBlock((RotatedPillarBlock) ModBlocks.SLATE.get(), blockTexture(ModBlocks.SLATE.get()));
        simpleBlock(ModBlocks.POLISHED_SLATE.get());
        simpleBlock(ModBlocks.SLATE_BRICKS.get());
        simpleBlock(ModBlocks.SLATE_ROOF.get());
        simpleBlock(ModBlocks.SLATE_TILES.get());

        simpleBlock(ModBlocks.CLAY_WALL.get());
        simpleBlock(ModBlocks.CLAY_CROSS_WALL.get());
        simpleBlock(ModBlocks.CLAY_DIAGONAL_LEFT_CROSS_WALL.get());
        simpleBlock(ModBlocks.CLAY_DIAGONAL_RIGHT_CROSS_WALL.get());

        simpleBlock(ModBlocks.ALCHEMIC_CONDENSER.get());

        block(ModBlocks.ACACIA_BARREL.get(), BARREL, "all");
        block(ModBlocks.BIRCH_BARREL.get(), BARREL, "all");
        block(ModBlocks.CRIMSON_BARREL.get(), BARREL, "all");
        block(ModBlocks.DARK_OAK_BARREL.get(), BARREL, "all");
        block(ModBlocks.JUNGLE_BARREL.get(), BARREL, "all");
        block(ModBlocks.MANGROVE_BARREL.get(), BARREL, "all");
        block(ModBlocks.OAK_BARREL.get(), BARREL, "all");
        block(ModBlocks.IRONWOOD_BARREL.get(), BARREL, "all");
        block(ModBlocks.OLIVEWOOD_BARREL.get(), BARREL, "all");
        block(ModBlocks.SPRUCE_BARREL.get(), BARREL, "all");
        block(ModBlocks.WARPED_BARREL.get(), BARREL, "all");
        block(ModBlocks.CRUSHING_TUB.get(), new ResourceLocation(Rustic.MOD_ID, "block/tub"));
        block(ModBlocks.IRONWOOD_SAPLING.get(), new ResourceLocation("block/cross"), "cross");
        block(ModBlocks.OLIVEWOOD_SAPLING.get(), new ResourceLocation("block/cross"), "cross");

        block(ModBlocks.TERRACOTTA_POT.get(), TERRACOTTA_POT, "all");
        block(ModBlocks.WHITE_TERRACOTTA_POT.get(), TERRACOTTA_POT, "all");
        block(ModBlocks.RED_TERRACOTTA_POT.get(), TERRACOTTA_POT, "all");
        block(ModBlocks.GREEN_TERRACOTTA_POT.get(), TERRACOTTA_POT, "all");
        block(ModBlocks.BLUE_TERRACOTTA_POT.get(), TERRACOTTA_POT, "all");
        block(ModBlocks.BLACK_TERRACOTTA_POT.get(), TERRACOTTA_POT, "all");

        block(ModBlocks.SWEET_BERRY_JUICE.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.SWEET_BERRY_WINE.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.SUGAR_WATER.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.IRON_BERRY_JUICE.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.IRON_BERRY_WINE.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.GRAPE_JUICE.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.RED_WINE.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.APPLE_JUICE.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.OLIVE_OIL.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.HONEY.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.CIDER.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.RUM.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.STARCHY_WATER.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.ALE.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.MEAD.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.VODKA.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.WHISKEY.get(), "particle", WATER_STILL.toString());
        block(ModBlocks.TOMATO_JUICE.get(), "particle", WATER_STILL.toString());

        farmland(ModBlocks.FERTILE_SOIL.get());

        horizontalBlock(ModBlocks.CABINET.get(), state -> {
            CabinetType type = state.getValue(CabinetBlock.TYPE);
            return models().orientable(
                    name(ModBlocks.CABINET.get()) + "_" + type.getSerializedName(),
                    type.format(Rustic.MOD_ID, "block/cabinet_side"),
                    type.format(Rustic.MOD_ID, "block/cabinet_front"),
                    extend(blockTexture(Blocks.BARREL), "_bottom")
            );
        }, 0);

        candleHolder(ModBlocks.IRON_CANDLE_WALL_SCONCE.get(), new ResourceLocation(Rustic.MOD_ID, "block/iron_candle_holder"), "candle_wall_sconce");
        candleHolder(ModBlocks.GOLD_CANDLE_WALL_SCONCE.get(), new ResourceLocation(Rustic.MOD_ID, "block/gold_candle_holder"), "candle_wall_sconce");
        candleHolder(ModBlocks.COPPER_CANDLE_WALL_SCONCE.get(), new ResourceLocation(Rustic.MOD_ID, "block/copper_candle_holder"), "candle_wall_sconce");
        candleHolder(ModBlocks.IRON_CANDLE_WALL_SCONCE_LEVER.get(), new ResourceLocation(Rustic.MOD_ID, "block/iron_candle_holder"), "candle_wall_sconce");
        candleHolder(ModBlocks.GOLD_CANDLE_WALL_SCONCE_LEVER.get(), new ResourceLocation(Rustic.MOD_ID, "block/gold_candle_holder"), "candle_wall_sconce");
        candleHolder(ModBlocks.COPPER_CANDLE_WALL_SCONCE_LEVER.get(), new ResourceLocation(Rustic.MOD_ID, "block/copper_candle_holder"), "candle_wall_sconce");

        candleHolder(ModBlocks.IRON_CANDLE_HOLDER.get(), new ResourceLocation(Rustic.MOD_ID, "block/iron_candle_holder"), "candle_holder");
        candleHolder(ModBlocks.GOLD_CANDLE_HOLDER.get(), new ResourceLocation(Rustic.MOD_ID, "block/gold_candle_holder"), "candle_holder");
        candleHolder(ModBlocks.COPPER_CANDLE_HOLDER.get(), new ResourceLocation(Rustic.MOD_ID, "block/copper_candle_holder"), "candle_holder");
        candleHolder(ModBlocks.IRON_CANDLE_HOLDER_LEVER.get(), new ResourceLocation(Rustic.MOD_ID, "block/iron_candle_holder"), "candle_holder");
        candleHolder(ModBlocks.GOLD_CANDLE_HOLDER_LEVER.get(), new ResourceLocation(Rustic.MOD_ID, "block/gold_candle_holder"), "candle_holder");
        candleHolder(ModBlocks.COPPER_CANDLE_HOLDER_LEVER.get(), new ResourceLocation(Rustic.MOD_ID, "block/copper_candle_holder"), "candle_holder");

        ModItems.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof BlockItem blockItem) {
                Block block = ForgeRegistries.BLOCKS.getValue(ForgeRegistries.ITEMS.getKey(blockItem));
                if (block instanceof TrapDoorBlock) {
                    simpleBlockItem(block, new ModelFile.UncheckedModelFile(extend(blockTexture(block), "_bottom")));
                } else if (block instanceof FenceBlock) {
                    simpleBlockItem(block, new ModelFile.UncheckedModelFile(extend(blockTexture(block), "_inventory")));
                } else if (block instanceof DoorBlock) {
                } else if (block instanceof SaplingBlock) {
                } else if (block instanceof SignBlock) {
                } else if (block instanceof ChainBlock) {
                } else if (block instanceof LanternBlock) {
                } else {
                    simpleBlockItem(block, new ModelFile.UncheckedModelFile(blockTexture(block)));
                }
            }
        });
    }

    private ResourceLocation prefix(ResourceLocation id, String prefix) {
        return new ResourceLocation(id.getNamespace(), prefix + id.getPath());
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }

    // references a parent model
    private void block(Block block, ResourceLocation parent) {
        simpleBlock(block, models().withExistingParent(name(block), parent));
    }

    // references a parent model with a texture
    private void block(Block block, ResourceLocation parent, String texture) {
        simpleBlock(block, models().getBuilder(name(block)).texture(texture, blockTexture(block)).texture("particle", blockTexture(block)).parent(models().getExistingFile(parent)));
    }

    private void farmland(Block block) {
        simpleBlock(block, models().getBuilder(name(block)).texture("dirt", blockTexture(block)).texture("top", "minecraft:block/farmland_moist").parent(models().getExistingFile(new ResourceLocation("block/template_farmland"))));
    }

    private void candleHolder(Block block, ResourceLocation texture, String parentId) {
        forAllStates(block, state -> {
            final CandleColor color = state.getValue(CandleHolderBlock.COLOR);
            final boolean lit = state.getValue(CandleHolderBlock.LIT);
            final boolean powered = state.hasProperty(BlockStateProperties.POWERED) && state.getValue(BlockStateProperties.POWERED);
            final String id = createCandleId(state);
            final ResourceLocation parent = new ResourceLocation(Rustic.MOD_ID, powered ? "block/" + parentId + "_powered" : "block/" + parentId);
            return models().withExistingParent(id, parent)
                    .texture("candle", prefix(color.format(lit ? "lit" : ""), "block/"))
                    .texture("holder", texture);
        });
    }

    private String createCandleId(BlockState state) {
        final CandleColor color = state.getValue(CandleHolderBlock.COLOR);
        final boolean lit = state.getValue(CandleHolderBlock.LIT);
        final boolean powered = state.hasProperty(BlockStateProperties.POWERED) && state.getValue(BlockStateProperties.POWERED);
        String id = name(state.getBlock());
        if (color != CandleColor.NONE) id += "_" + color.getSerializedName();
        if (lit) id += "_lit";
        if (powered) id += "_powered";
        return id;
    }

    // creates a model with a texture and no parent
    private void block(Block block, String texture, String loc) {
        simpleBlock(block, models().getBuilder(name(block)).texture(texture, loc));
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private void forAllStates(Block block, Function<BlockState, ModelFile> modelFunc) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    var model = ConfiguredModel.builder().modelFile(modelFunc.apply(state));
                    if (state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
                        model = model.rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()) % 360);
                    }
                    return model.build();
                });
    }
}