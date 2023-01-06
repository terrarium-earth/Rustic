package earth.terrarium.rustic.common.util.fabric;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import earth.terrarium.rustic.mixin.PotionBrewingAccessor;
import earth.terrarium.rustic.mixin.fabric.PotionBrewingMixAccessor;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

import java.util.function.Supplier;

public class PlatformUtilsImpl {
    public static CreativeModeTab createTab(ResourceLocation loc, Supplier<ItemStack> icon) {
        return FabricItemGroupBuilder.build(loc, icon);
    }

    public static void registerStrippedLog(Block log, Block strippedLog) {
        StrippableBlockRegistry.register(log, strippedLog);
    }

    @SuppressWarnings("unchecked")
    public static List<Triple<Potion, Ingredient, Potion>> getBrewingRecipes() {
        List<PotionBrewing.Mix<Potion>> mixes = (List<PotionBrewing.Mix<Potion>>) PotionBrewingAccessor.getPotionMixes();
        return mixes.stream()
                .map(mix -> (PotionBrewingMixAccessor<Potion>)mix)
                .map(mix -> Triple.of(mix.getFrom(), mix.getIngredient(), mix.getTo()))
                .toList();
    }
}