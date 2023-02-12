package earth.terrarium.rustic.common.effects;

import earth.terrarium.rustic.common.registry.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ShameEffect extends MobEffect {

    public ShameEffect() {
        super(MobEffectCategory.HARMFUL, 0xFF6347);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 2 == 0;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.level instanceof ServerLevel level) {
            level.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, ModItems.TOMATO.get().getDefaultInstance()),
                    entity.getRandomX(1), entity.getRandomY(), entity.getRandomZ(1), 10, 0, 0, 0, -0.05);
        }
    }
}
