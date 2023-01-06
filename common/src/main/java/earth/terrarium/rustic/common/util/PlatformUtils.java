package earth.terrarium.rustic.common.util;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

public class PlatformUtils {
    @ExpectPlatform
    public static void registerStrippedLog(Block log, Block strippedLog) {
        throw new NotImplementedException();
    }

    @ExpectPlatform
    public static List<Triple<Potion, Ingredient, Potion>> getBrewingRecipes() {
        throw new NotImplementedException();
    }
}
