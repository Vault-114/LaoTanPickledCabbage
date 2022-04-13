package com.nazismhub.laotan.item;

import com.nazismhub.laotan.LaotanSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class LaoTanSuanCai extends Item {
    public LaoTanSuanCai(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.playSound(LaotanSounds.FINISH_EAT, 0.8f, 1f);
        return user.eatFood(world, stack);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        /*entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 3), user);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 6), user);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 5), user);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 10), user);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 500, 10), user);*/
        entity.eatFood(user.getWorld(), stack);
        entity.damage(DamageSource.player(user), 0);
        return ActionResult.PASS;
    }
}
