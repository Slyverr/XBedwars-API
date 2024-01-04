package com.slyvr.bedwars.api.event.shop;

import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.api.shop.Shop;
import com.slyvr.bedwars.api.shop.ShopCategory;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class ShopOpenEvent extends ShopEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final GamePlayer player;
    private boolean isCancelled;


    public ShopOpenEvent(@NotNull Shop<?> shop, @NotNull ShopCategory category, @NotNull GamePlayer player) {
        super(shop, category);

        this.player = player;
    }


    @NotNull
    public GamePlayer getPlayer() {
        return player;
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