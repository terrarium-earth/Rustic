package earth.terrarium.rustic.mixin;

import net.minecraft.world.item.alchemy.PotionBrewing;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(PotionBrewing.class)
public interface PotionBrewingAccessor {

    @Accessor("POTION_MIXES")
    static List<?> getPotionMixes() {
        throw new AssertionError();
    }
}
