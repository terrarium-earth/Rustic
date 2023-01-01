package earth.terrarium.rustic.common.registry;

import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.rustic.Rustic;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import java.util.function.Supplier;

public class ModMobEffects {
    public static final RegistryHolder<MobEffect> MOB_EFFECTS = new RegistryHolder<>(Registry.MOB_EFFECT, Rustic.MOD_ID);

    public static final Supplier<MobEffect> SHAME = MOB_EFFECTS.register("shame", () -> new MobEffect(MobEffectCategory.HARMFUL, 0xFF6347) {
    });
}
