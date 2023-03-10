package earth.terrarium.rustic.common.util.forge;

import earth.terrarium.rustic.mixin.PotionBrewingAccessor;
import earth.terrarium.rustic.mixin.forge.AxeItemAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.apache.commons.lang3.tuple.Triple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class PlatformUtilsImpl {
    public static CreativeModeTab createTab(ResourceLocation loc, Supplier<ItemStack> icon) {
        return new CreativeModeTab(loc.getNamespace() + "." + loc.getPath()) {
            @Override
            public @NotNull ItemStack makeIcon() {
                return icon.get();
            }
        };
    }

    public static void registerStrippedLog(Block log, Block strippedLog) {
        Map<Block, Block> strippedBlocks = new HashMap<>(AxeItemAccessor.getStrippables());
        strippedBlocks.put(log, strippedLog);
        AxeItemAccessor.setStrippables(strippedBlocks);
    }

    @SuppressWarnings("unchecked")
    public static List<Triple<Potion, Ingredient, Potion>> getBrewingRecipes() {
        List<PotionBrewing.Mix<Potion>> mixes = (List<PotionBrewing.Mix<Potion>>) PotionBrewingAccessor.getPotionMixes();
        return mixes.stream()
                .map(mix -> Triple.of(mix.f_43532_.get(), mix.ingredient, mix.f_43534_.get()))
                .toList();
    }
}
