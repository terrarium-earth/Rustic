package earth.terrarium.rustic.common.items;

import com.mojang.datafixers.util.Pair;
import earth.terrarium.rustic.common.config.AlchemyConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PotionFlask extends Item {

    private static final String TAG_AMOUNT = "Amount";
    private static final String TAG_COLOR = "Color";

    public PotionFlask(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);
        if (PotionUtils.getPotion(stack) == Potions.EMPTY) {
            return InteractionResultHolder.pass(stack);
        }
        return ItemUtils.startUsingInstantly(level, player, usedHand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player p ? p : null;
        if (player instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
        }

        if (!level.isClientSide) {
            for (MobEffectInstance instance : PotionUtils.getMobEffects(stack)) {
                if (instance.getEffect().isInstantenous()) {
                    instance.getEffect().applyInstantenousEffect(player, player, livingEntity, instance.getAmplifier(), 1.0);
                } else {
                    livingEntity.addEffect(new MobEffectInstance(instance));
                }
            }
        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                var potion = PotionFlask.getPotion(stack);
                PotionFlask.setPotion(stack, potion.getFirst(), potion.getSecond() - 1);
            }
        }

        livingEntity.gameEvent(GameEvent.DRINK);
        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public int getBarColor(ItemStack stack) {
        if (stack.hasTag() && stack.getOrCreateTag().contains(TAG_COLOR)) {
            return stack.getOrCreateTag().getInt(TAG_COLOR);
        }
        return 0;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        int amount = stack.getOrCreateTag().getInt(TAG_AMOUNT);
        return Math.round(((float)amount / (float)AlchemyConfig.FLASK_MAX_AMOUNT) * 13.0F);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        PotionUtils.addPotionTooltip(stack, tooltipComponents, 1.0F);
        tooltipComponents.add(CommonComponents.EMPTY);
        tooltipComponents.add(Component.literal("Amount: " + stack.getOrCreateTag().getInt(TAG_AMOUNT)).withStyle(ChatFormatting.GRAY));
    }

    public static boolean canSetPotion(ItemStack stack, Potion potion) {
        if (stack.getItem() instanceof PotionFlask) {
            var value = PotionFlask.getPotion(stack);
            return Potions.EMPTY.equals(value.getFirst()) || (potion.equals(value.getFirst()) && value.getSecond() < AlchemyConfig.FLASK_MAX_AMOUNT);
        }
        return false;
    }

    public static Pair<Potion, Integer> getPotion(ItemStack stack) {
        Potion potion = PotionUtils.getPotion(stack);
        int amount = stack.getOrCreateTag().getInt(TAG_AMOUNT);
        return Pair.of(potion, amount);
    }

    public static void setPotion(ItemStack stack, Potion potion, int amount) {
        if (amount > AlchemyConfig.FLASK_MAX_AMOUNT) return;
        if (amount <= 0 || Potions.EMPTY.equals(potion)) {
            stack.setTag(null);
        } else {
            PotionUtils.setPotion(stack, potion);
            if (Potions.EMPTY.equals(potion)) {
                stack.removeTagKey(TAG_AMOUNT);
            } else {
                stack.getOrCreateTag().putInt(TAG_AMOUNT, amount);
            }
            stack.getOrCreateTag().putInt(TAG_COLOR, potion.getEffects().isEmpty() ? 0 : potion.getEffects().get(0).getEffect().getColor());
        }
    }
}
