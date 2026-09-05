package com.example.mobhighlight;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;

public class MobHighlight implements ModInitializer {
    public static final String MOD_ID = "mobhighlight";

    @Override
    public void onInitialize() {
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (entity instanceof LivingEntity && !(entity instanceof PlayerEntity)) {
                world.playSound(
                        null,
                        entity.getBlockPos(),
                        SoundEvents.ENTITY_PLAYER_ATTACK_CRIT,
                        SoundCategory.PLAYERS,
                        1.0f,
                        1.0f
                );
            }
            return ActionResult.PASS;
        });
    }
}
