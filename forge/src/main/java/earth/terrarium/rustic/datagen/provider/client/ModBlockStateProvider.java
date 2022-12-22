package earth.terrarium.rustic.datagen.provider.client;

import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.registry.ModBlocks;
import earth.terrarium.rustic.common.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStateProvider extends BlockStateProvider {

    private static final ResourceLocation BARREL = new ResourceLocation(Rustic.MOD_ID, "block/fluid_barrel");
    private static final ResourceLocation TERRACOTTA_POT = new ResourceLocation(Rustic.MOD_ID, "block/pot");

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
        logBlock((RotatedPillarBlock) ModBlocks.IRONWOOD_STRIPPED_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.OLIVEWOOD_STRIPPED_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.IRONWOOD_WOOD.get(), blockTexture(ModBlocks.IRONWOOD_LOG.get()), blockTexture(ModBlocks.IRONWOOD_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.OLIVEWOOD_WOOD.get(), blockTexture(ModBlocks.OLIVEWOOD_LOG.get()), blockTexture(ModBlocks.OLIVEWOOD_LOG.get()));
        simpleBlock(ModBlocks.IRONWOOD_LEAVES.get());
        simpleBlock(ModBlocks.OLIVEWOOD_LEAVES.get());
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

        logBlock((RotatedPillarBlock) ModBlocks.STONE_PILLAR.get());
        axisBlock((RotatedPillarBlock) ModBlocks.ANDESITE_PILLAR.get(), blockTexture(ModBlocks.ANDESITE_PILLAR.get()), blockTexture(Blocks.POLISHED_ANDESITE));
        axisBlock((RotatedPillarBlock) ModBlocks.DIORITE_PILLAR.get(), blockTexture(ModBlocks.DIORITE_PILLAR.get()), blockTexture(Blocks.POLISHED_DIORITE));
        axisBlock((RotatedPillarBlock) ModBlocks.GRANITE_PILLAR.get(), blockTexture(ModBlocks.GRANITE_PILLAR.get()), blockTexture(Blocks.POLISHED_GRANITE));
        axisBlock((RotatedPillarBlock) ModBlocks.DEEPSLATE_PILLAR.get(), blockTexture(ModBlocks.DEEPSLATE_PILLAR.get()), blockTexture(Blocks.POLISHED_DEEPSLATE));

        simpleBlock(ModBlocks.CLAY_WALL.get());
        simpleBlock(ModBlocks.CLAY_CROSS_WALL.get());
        simpleBlock(ModBlocks.CLAY_DIAGONAL_LEFT_CROSS_WALL.get());
        simpleBlock(ModBlocks.CLAY_DIAGONAL_RIGHT_CROSS_WALL.get());

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

        block(ModBlocks.SWEET_BERRY_JUICE.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.SWEET_BERRY_WINE.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.SUGAR_WATER.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.IRON_BERRY_JUICE.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.IRON_BERRY_WINE.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.GRAPE_JUICE.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.RED_WINE.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.APPLE_JUICE.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.OLIVE_OIL.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.HONEY.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.CIDER.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.RUM.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.STARCHY_WATER.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.ALE.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.MEAD.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.VODKA.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.WHISKEY.get(), "particle", "minecraft:block/water_still");
        block(ModBlocks.TOMATO_JUICE.get(), "particle", "minecraft:block/water_still");

        ModItems.ITEMS.getRegistries().forEach(item -> {
            if (item.get() instanceof BlockItem blockItem) {
                Block block = ForgeRegistries.BLOCKS.getValue(ForgeRegistries.ITEMS.getKey(blockItem));
                if (block instanceof TrapDoorBlock) {
                    simpleBlockItem(block, new ModelFile.UncheckedModelFile(extend(blockTexture(block), "_bottom")));
                } else if (block instanceof FenceBlock) {
                    simpleBlockItem(block, new ModelFile.UncheckedModelFile(extend(blockTexture(block), "_inventory")));
                } else if (block instanceof DoorBlock) {
                    // Door model is an item
                } else if (block instanceof SaplingBlock) {
                    // Sapling model is an item
                } else if (block instanceof SignBlock) {
                    // Sign model is an item
                } else {
                    simpleBlockItem(block, new ModelFile.UncheckedModelFile(blockTexture(block)));
                }
            }
        });
    }

    private ResourceLocation prefix(Block block, String prefix) {
        final ResourceLocation id = key(block);
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
        simpleBlock(block, models().getBuilder(name(block)).texture(texture, blockTexture(block)).parent(models().getExistingFile(parent)));
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
}