package earth.terrarium.rustic.datagen.provider.client;

import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.registry.ModBlocks;
import earth.terrarium.rustic.common.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStateProvider extends BlockStateProvider {

    private static final ResourceLocation BARREL = new ResourceLocation(Rustic.MOD_ID, "block/fluid_barrel" );

    public ModBlockStateProvider(DataGenerator pGenerator, ExistingFileHelper exFileHelper) {
        super(pGenerator, Rustic.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModItems.ITEMS.getRegistries().forEach(item -> {
            if (item.get() instanceof BlockItem blockItem) {
                Block block = ForgeRegistries.BLOCKS.getValue(ForgeRegistries.ITEMS.getKey(blockItem));
                simpleBlockItem(block, cubeAll(block));
            }
        });

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

        block(ModBlocks.ACACIA_BARREL.get(), BARREL);
        block(ModBlocks.BIRCH_BARREL.get(), BARREL);
        block(ModBlocks.CRIMSON_BARREL.get(), BARREL);
        block(ModBlocks.DARK_OAK_BARREL.get(), BARREL);
        block(ModBlocks.JUNGLE_BARREL.get(), BARREL);
        block(ModBlocks.MANGROVE_BARREL.get(), BARREL);
        block(ModBlocks.OAK_BARREL.get(), BARREL);
        block(ModBlocks.IRONWOOD_BARREL.get(), BARREL);
        block(ModBlocks.OLIVEWOOD_BARREL.get(), BARREL);
        block(ModBlocks.SPRUCE_BARREL.get(), BARREL);
        block(ModBlocks.WARPED_BARREL.get(), BARREL);
    }

    private ResourceLocation prefix(Block block, String prefix) {
        final ResourceLocation id = key(block);
        return new ResourceLocation(id.getNamespace(), prefix + id.getPath());
    }

    private void block(Block block, ResourceLocation parent) {
        simpleBlock(block, models().withExistingParent(name(block), parent));
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }
}
