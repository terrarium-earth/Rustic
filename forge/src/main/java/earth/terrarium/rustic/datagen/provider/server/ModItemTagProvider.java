package earth.terrarium.rustic.datagen.provider.server;

import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.registry.ModItems;
import earth.terrarium.rustic.common.registry.ModTags;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

@MethodsReturnNonnullByDefault
public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(DataGenerator pGenerator, BlockTagsProvider provider, ExistingFileHelper exFileHelper) {
        super(pGenerator, provider, Rustic.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Items.IRONWOOD_LOGS).add(ModItems.IRONWOOD_LOG.get());
        tag(ModTags.Items.OLIVEWOOD_LOGS).add(ModItems.OLIVEWOOD_LOG.get());
        tag(ModTags.Items.PAINTED_WOOD).add(ModItems.BLACK_PAINTED_WOOD.get(), ModItems.BLUE_PAINTED_WOOD.get(), ModItems.BROWN_PAINTED_WOOD.get(), ModItems.CYAN_PAINTED_WOOD.get(), ModItems.GRAY_PAINTED_WOOD.get(), ModItems.GREEN_PAINTED_WOOD.get(), ModItems.LIGHT_BLUE_PAINTED_WOOD.get(), ModItems.LIGHT_GRAY_PAINTED_WOOD.get(), ModItems.LIME_PAINTED_WOOD.get(), ModItems.MAGENTA_PAINTED_WOOD.get(), ModItems.ORANGE_PAINTED_WOOD.get(), ModItems.PINK_PAINTED_WOOD.get(), ModItems.PURPLE_PAINTED_WOOD.get(), ModItems.RED_PAINTED_WOOD.get(), ModItems.WHITE_PAINTED_WOOD.get(), ModItems.YELLOW_PAINTED_WOOD.get());
    }
}
