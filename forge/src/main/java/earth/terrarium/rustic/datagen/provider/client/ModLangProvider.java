package earth.terrarium.rustic.datagen.provider.client;

import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.registry.ModBlocks;
import earth.terrarium.rustic.common.registry.ModEntityTypes;
import earth.terrarium.rustic.common.registry.ModItems;
import earth.terrarium.rustic.common.registry.ModMobEffects;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraftforge.common.data.LanguageProvider;
import org.codehaus.plexus.util.StringUtils;

import java.util.Objects;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(DataGenerator pGenerator) {
        super(pGenerator, Rustic.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.rustic.main", "Rustic");

        ModBlocks.BLOCKS.stream().filter(e -> !(e instanceof WallSignBlock)).forEach(entry -> addBlock(entry, StringUtils.capitaliseAllWords(entry.getId().getPath().replace("_", " "))));
        ModItems.ITEMS.stream().filter(e -> !(e instanceof BlockItem)).forEach(entry -> addItem(entry, StringUtils.capitaliseAllWords(Objects.requireNonNull(entry.getId()).getPath().replace("_", " "))));
        ModEntityTypes.ENTITY_TYPES.stream().forEach(entry -> addEntityType(entry, StringUtils.capitaliseAllWords(Objects.requireNonNull(entry.getId()).getPath().replace("_", " "))));
        ModMobEffects.MOB_EFFECTS.stream().forEach(entry -> addEffect(entry, StringUtils.capitaliseAllWords(Objects.requireNonNull(entry.getId()).getPath().replace("_", " "))));
    }
}
