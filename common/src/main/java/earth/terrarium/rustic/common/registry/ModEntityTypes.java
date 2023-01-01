package earth.terrarium.rustic.common.registry;

import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.entity.projectile.Tomato;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class ModEntityTypes {
    public static final RegistryHolder<EntityType<?>> ENTITY_TYPES = new RegistryHolder<>(Registry.ENTITY_TYPE, Rustic.MOD_ID);

    public static final Supplier<EntityType<Tomato>> TOMATO = ENTITY_TYPES.register("tomato", () -> EntityType.Builder.<Tomato>of(Tomato::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).build(Rustic.MOD_ID));
}
