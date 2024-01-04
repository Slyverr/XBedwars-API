package com.slyvr.bedwars.api.event.user.shop;

import com.slyvr.bedwars.api.user.shop.UserQuickBuy;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class UserQuickBuyOpenEvent extends UserQuickBuyEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private boolean isCancelled;

    public UserQuickBuyOpenEvent(@NotNull UserQuickBuy qb) {
        super(qb);
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