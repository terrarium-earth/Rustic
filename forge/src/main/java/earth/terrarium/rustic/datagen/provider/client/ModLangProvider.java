package earth.terrarium.rustic.datagen.provider.client;

import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.registry.ModBlocks;
import earth.terrarium.rustic.common.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.codehaus.plexus.util.StringUtils;

import java.util.function.Supplier;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(DataGenerator pGenerator) {
        super(pGenerator, Rustic.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.rustic.main", "Rustic");

        for (Supplier<Block> block : ModBlocks.BLOCKS.getRegistries()) {
            ResourceLocation blockId = ForgeRegistries.BLOCKS.getKey(block.get());
            if (block.get() instanceof WallSignBlock) continue;
            if (blockId.getNamespace().equals(Rustic.MOD_ID)) {
                addBlock(block, StringUtils.capitaliseAllWords(blockId.getPath().replace("_", " ")));
            }
        }

        ModItems.ITEMS.getRegistries().forEach(item -> {
            if (!(item.get() instanceof BlockItem)) {
                ResourceLocation blockId = ForgeRegistries.ITEMS.getKey(item.get());
                if (blockId.getNamespace().equals(Rustic.MOD_ID)) {
                    addItem(item, StringUtils.capitaliseAllWords(blockId.getPath().replace("_", " ")));
                }
            }
        });
    }
}
