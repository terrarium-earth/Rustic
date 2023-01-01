package earth.terrarium.rustic.datagen.provider.client;

import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.registry.ModBlocks;
import earth.terrarium.rustic.common.registry.ModEntityTypes;
import earth.terrarium.rustic.common.registry.ModItems;
import earth.terrarium.rustic.common.registry.ModMobEffects;
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
            ResourceLocation id = ForgeRegistries.BLOCKS.getKey(block.get());
            if (block.get() instanceof WallSignBlock) continue;
            addBlock(block, StringUtils.capitaliseAllWords(id.getPath().replace("_", " ")));
        }

        ModItems.ITEMS.getRegistries().forEach(reg -> {
            if (!(reg.get() instanceof BlockItem)) {
                ResourceLocation id = ForgeRegistries.ITEMS.getKey(reg.get());
                addItem(reg, StringUtils.capitaliseAllWords(id.getPath().replace("_", " ")));
            }
        });

        ModEntityTypes.ENTITY_TYPES.getRegistries().forEach(entity -> {
            ResourceLocation id = ForgeRegistries.ENTITY_TYPES.getKey(entity.get());
            assert id != null;
            addEntityType(entity, StringUtils.capitaliseAllWords(id.getPath().replace("_", " ")));
        });

        ModMobEffects.MOB_EFFECTS.getRegistries().forEach(effect -> {
            ResourceLocation id = ForgeRegistries.MOB_EFFECTS.getKey(effect.get());
            assert id != null;
            addEffect(effect, StringUtils.capitaliseAllWords(id.getPath().replace("_", " ")));
        });
    }
}
