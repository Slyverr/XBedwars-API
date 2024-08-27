package com.slyvr.xbedwars.api.event.player.damage;

import com.slyvr.xbedwars.api.player.GamePlayer;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.jetbrains.annotations.NotNull;


public class GamePlayerDamageByGamePlayerEvent extends GamePlayerDamageEvent {

    private final GamePlayer damager;


    public GamePlayerDamageByGamePlayerEvent(@NotNull GamePlayer player, @NotNull GamePlayer damager, @NotNull DamageCause cause, double damage) {
        super(player, cause, damage);

        this.damager = damager;
    }


    @NotNull
    public GamePlayer getDamager() {
        return damager;
    }

}