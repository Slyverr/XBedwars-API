package com.slyvr.bedwars.api.event.user.shop;

import com.slyvr.bedwars.api.shop.content.Purchasable;
import com.slyvr.bedwars.api.user.shop.UserQuickBuy;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class UserQuickBuyEditEvent extends UserQuickBuyEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Purchasable moved;
    private final QuickBuyAction action;
    private final int dest;

    private boolean isCancelled;


    public UserQuickBuyEditEvent(@NotNull UserQuickBuy qb, @NotNull QuickBuyAction action, @NotNull Purchasable moved, int dest) {
        super(qb);

        this.action = action;
        this.moved = moved;
        this.dest = dest;
    }


    @NotNull
    public QuickBuyAction getAction() {
        return action;
    }

    @NotNull
    public Purchasable getPurchasable() {
        return moved;
    }

    public int getDestination() {
        return dest;
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

    public enum QuickBuyAction {

        REPLACE,
        REMOVE,
        ADD

    }

}