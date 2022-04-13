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
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LaoTanSuanCaiNoodles extends Item {
    public LaoTanSuanCaiNoodles(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //user.playSound(LaotanSounds.EAT, 1f, 1f);
        return super.use(world, user, hand);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user.isPlayer()) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 3000, 1));
        }
        user.playSound(LaotanSounds.FINISH_EAT, 1f, 1f);
        return user.eatFood(world, stack);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        entity.eatFood(user.getWorld(), stack);
        //entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20, 1), user);
        entity.damage(DamageSource.player(user), 0);
        return ActionResult.PASS;
    }
}
