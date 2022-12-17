package earth.terrarium.rustic.datagen.provider.client;

import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.registry.ModBlocks;
import earth.terrarium.rustic.common.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStateProvider extends BlockStateProvider {

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
    }
}
