package earth.terrarium.rustic.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.effects.ShameEffect;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;

public class ModMobEffects {
    public static final ResourcefulRegistry<MobEffect> MOB_EFFECTS = ResourcefulRegistries.create(Registry.MOB_EFFECT, Rustic.MOD_ID);

    public static final RegistryEntry<MobEffect> SHAME = MOB_EFFECTS.register("shame", ShameEffect::new);
}
