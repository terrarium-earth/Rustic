package earth.terrarium.rustic.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.entity.projectile.Tomato;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntityTypes {
    public static final ResourcefulRegistry<EntityType<?>> ENTITY_TYPES = ResourcefulRegistries.create(Registry.ENTITY_TYPE, Rustic.MOD_ID);

    public static final RegistryEntry<EntityType<Tomato>> TOMATO = ENTITY_TYPES.register("tomato", () -> EntityType.Builder.<Tomato>of(Tomato::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).build(Rustic.MOD_ID));
}
