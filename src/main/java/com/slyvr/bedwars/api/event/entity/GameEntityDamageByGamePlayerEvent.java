package com.slyvr.bedwars.api.event.entity;

import com.slyvr.bedwars.api.entity.GameEntity;
import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent;
import org.jetbrains.annotations.NotNull;


public class GameEntityDamageByGamePlayerEvent extends GameEntityDamageEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final GamePlayer damager;
    private double damage;

    private boolean isCancelled;


    public GameEntityDamageByGamePlayerEvent(@NotNull GameEntity damaged, @NotNull GamePlayer damager, @NotNull EntityDamageEvent.DamageCause cause, double damage) {
        super(damaged, cause, damage);

        this.damager = damager;
    }


    @NotNull
    public GamePlayer getDamager() {
        return damager;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}