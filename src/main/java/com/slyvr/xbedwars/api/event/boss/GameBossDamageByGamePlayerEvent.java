package com.slyvr.xbedwars.api.event.boss;

import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import com.slyvr.xbedwars.api.boss.GameBoss;
import com.slyvr.xbedwars.api.player.GamePlayer;


public class GameBossDamageByGamePlayerEvent extends GameBossEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final GamePlayer damager;
    private double damage;

    private boolean isCancelled;


    public GameBossDamageByGamePlayerEvent(@NotNull GameBoss boss, @NotNull GamePlayer damager, double damage) {
        super(boss);

        this.damager = damager;
        this.damage = damage;
    }


    @NotNull
    public GamePlayer getDamager() {
        return damager;
    }


    public double getDamage() {
        return damage;
    }


    public void setDamage(double damage) {
        if (damage >= 0)
            this.damage = damage;
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