package com.slyvr.bedwars.api.event.player.damage;

import com.slyvr.bedwars.api.event.player.GamePlayerEvent;
import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.jetbrains.annotations.NotNull;


public class GamePlayerDamageEvent extends GamePlayerEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final DamageCause cause;
    private double damage;

    private boolean isCancelled;


    public GamePlayerDamageEvent(@NotNull GamePlayer player, @NotNull DamageCause cause, double damage) {
        super(player);

        this.cause = cause;
        this.damage = damage;
    }


    @NotNull
    public DamageCause getCause() {
        return cause;
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