package earth.terrarium.rustic.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.rustic.Rustic;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ModMobEffects {
    public static final ResourcefulRegistry<MobEffect> MOB_EFFECTS = ResourcefulRegistries.create(Registry.MOB_EFFECT, Rustic.MOD_ID);

    public static final RegistryEntry<MobEffect> SHAME = MOB_EFFECTS.register("shame", () -> new MobEffect(MobEffectCategory.HARMFUL, 0xFF6347) {
    });
}
