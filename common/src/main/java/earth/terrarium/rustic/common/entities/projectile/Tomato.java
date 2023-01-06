package earth.terrarium.rustic.common.entities.projectile;

import earth.terrarium.rustic.common.registry.ModEntityTypes;
import earth.terrarium.rustic.common.registry.ModItems;
import earth.terrarium.rustic.common.registry.ModMobEffects;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class Tomato extends ThrowableItemProjectile {
    public Tomato(EntityType<? extends Tomato> entityType, Level level) {
        super(entityType, level);
    }

    public Tomato(Level level, LivingEntity entity) {
        super(ModEntityTypes.TOMATO.get(), entity, level);
    }

    public Tomato(Level arg, double d, double e, double f) {
        super(ModEntityTypes.TOMATO.get(), d, e, f, arg);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.TOMATO.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (result.getEntity() instanceof LivingEntity entity) {
            MobEffectInstance effect = new MobEffectInstance(ModMobEffects.SHAME.get(), 15 * 20);
            entity.addEffect(effect);
        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == EntityEvent.DEATH) {
            ParticleOptions particleOptions = new ItemParticleOption(ParticleTypes.ITEM, this.getItem());

            for (int i = 0; i < 8; ++i) {
                this.level.addParticle(particleOptions, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
        }

    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, EntityEvent.DEATH);
            this.discard();
        }
    }
}
