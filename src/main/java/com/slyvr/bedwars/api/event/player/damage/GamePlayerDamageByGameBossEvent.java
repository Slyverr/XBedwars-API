package com.slyvr.bedwars.api.event.player.damage;

import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.jetbrains.annotations.NotNull;

import com.slyvr.bedwars.api.boss.GameBoss;
import com.slyvr.bedwars.api.player.GamePlayer;


public class GamePlayerDamageByGameBossEvent extends GamePlayerDamageEvent {

    private final GameBoss damager;


    public GamePlayerDamageByGameBossEvent(@NotNull GamePlayer player, @NotNull GameBoss damager, @NotNull DamageCause cause, double damage) {
        super(player, cause, damage);

        this.damager = damager;
    }


    @NotNull
    public GameBoss getDamager() {
        return damager;
    }

}