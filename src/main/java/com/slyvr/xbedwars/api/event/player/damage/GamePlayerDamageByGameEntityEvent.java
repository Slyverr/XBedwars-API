package com.slyvr.xbedwars.api.event.player.damage;

import com.slyvr.xbedwars.api.entity.GameEntity;
import com.slyvr.xbedwars.api.player.GamePlayer;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.jetbrains.annotations.NotNull;


public class GamePlayerDamageByGameEntityEvent extends GamePlayerDamageEvent {

    private final GameEntity damager;


    public GamePlayerDamageByGameEntityEvent(@NotNull GamePlayer player, @NotNull GameEntity damager, @NotNull DamageCause cause, double damage) {
        super(player, cause, damage);

        this.damager = damager;
    }


    @NotNull
    public GameEntity getDamager() {
        return damager;
    }

}