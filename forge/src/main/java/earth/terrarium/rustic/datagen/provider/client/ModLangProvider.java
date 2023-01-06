package earth.terrarium.rustic.datagen.provider.client;

import com.google.gson.JsonObject;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.registry.ModBlocks;
import earth.terrarium.rustic.common.registry.ModEntityTypes;
import earth.terrarium.rustic.common.registry.ModItems;
import earth.terrarium.rustic.common.registry.ModMobEffects;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraftforge.common.data.LanguageProvider;
import org.codehaus.plexus.util.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class ModLangProvider extends LanguageProvider {

    private final Map<String, String> data = new TreeMap<>();
    private final DataGenerator gen;
    private final String modid;
    private final String locale;

    public ModLangProvider(DataGenerator pGenerator) {
        super(pGenerator, Rustic.MOD_ID, "en_us");
        this.gen = pGenerator;
        this.modid = Rustic.MOD_ID;
        this.locale = "en_us";
    }

    @Override
    public void run(@NotNull CachedOutput output) throws IOException {
        addTranslations();
        if (!data.isEmpty()) {
            JsonObject json = new JsonObject();
            data.forEach(json::addProperty);
            DataProvider.saveStable(output, json, this.gen.getOutputFolder().resolve("assets/" + modid + "/lang/" + locale + ".json"));
        }
    }

    @Override
    public void add(@NotNull String key, @NotNull String value) {
        data.put(key, value); //Don't care about duplicates
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.rustic.main", "Rustic");

        ModBlocks.BLOCKS.stream().forEach(entry -> addBlock(entry, StringUtils.capitaliseAllWords(entry.getId().getPath().replace("_", " "))));
        ModItems.ITEMS.stream().forEach(entry -> addItem(entry, StringUtils.capitaliseAllWords(Objects.requireNonNull(entry.getId()).getPath().replace("_", " "))));
        ModEntityTypes.ENTITY_TYPES.stream().forEach(entry -> addEntityType(entry, StringUtils.capitaliseAllWords(Objects.requireNonNull(entry.getId()).getPath().replace("_", " "))));
        ModMobEffects.MOB_EFFECTS.stream().forEach(entry -> addEffect(entry, StringUtils.capitaliseAllWords(Objects.requireNonNull(entry.getId()).getPath().replace("_", " "))));
    }
}
