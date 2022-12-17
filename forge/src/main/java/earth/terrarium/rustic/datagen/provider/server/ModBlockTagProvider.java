package earth.terrarium.rustic.datagen.provider.server;

import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.registry.ModBlocks;
import earth.terrarium.rustic.common.registry.ModTags;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

@MethodsReturnNonnullByDefault
public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(DataGenerator pGenerator, ExistingFileHelper exFileHelper) {
        super(pGenerator, Rustic.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.IRONWOOD_LOGS).add(ModBlocks.IRONWOOD_LOG.get());
        tag(ModTags.Blocks.OLIVEWOOD_LOGS).add(ModBlocks.OLIVEWOOD_LOG.get());
        tag(ModTags.Blocks.PAINTED_WOOD).add(ModBlocks.BLACK_PAINTED_WOOD.get(), ModBlocks.BLUE_PAINTED_WOOD.get(), ModBlocks.BROWN_PAINTED_WOOD.get(), ModBlocks.CYAN_PAINTED_WOOD.get(), ModBlocks.GRAY_PAINTED_WOOD.get(), ModBlocks.GREEN_PAINTED_WOOD.get(), ModBlocks.LIGHT_BLUE_PAINTED_WOOD.get(), ModBlocks.LIGHT_GRAY_PAINTED_WOOD.get(), ModBlocks.LIME_PAINTED_WOOD.get(), ModBlocks.MAGENTA_PAINTED_WOOD.get(), ModBlocks.ORANGE_PAINTED_WOOD.get(), ModBlocks.PINK_PAINTED_WOOD.get(), ModBlocks.PURPLE_PAINTED_WOOD.get(), ModBlocks.RED_PAINTED_WOOD.get(), ModBlocks.WHITE_PAINTED_WOOD.get(), ModBlocks.YELLOW_PAINTED_WOOD.get());
    }
}
