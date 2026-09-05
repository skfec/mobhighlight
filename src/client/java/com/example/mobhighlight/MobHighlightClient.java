package com.example.mobhighlight;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;

public class MobHighlightClient implements ClientModInitializer {

    private static final double REACH = 6.0;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.world == null) return;

            HitResult hit = client.crosshairTarget;
            if (hit instanceof EntityHitResult entityHit) {
                if (entityHit.getEntity() instanceof LivingEntity target
                        && !(target instanceof PlayerEntity)
                        && target.squaredDistanceTo(client.player) <= REACH * REACH) {

                    target.addStatusEffect(new StatusEffectInstance(
                            StatusEffects.GLOWING, 5, 0, false, false, false));
                }
            }
        });
    }
}
