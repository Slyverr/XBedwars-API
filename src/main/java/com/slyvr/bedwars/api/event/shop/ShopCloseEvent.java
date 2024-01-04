package com.slyvr.bedwars.api.event.shop;

import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.api.shop.Shop;
import com.slyvr.bedwars.api.shop.ShopCategory;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class ShopCloseEvent extends ShopEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final GamePlayer player;


    public ShopCloseEvent(@NotNull Shop<?> shop, @NotNull ShopCategory category, @NotNull GamePlayer player) {
        super(shop, category);

        this.player = player;
    }


    @NotNull
    public GamePlayer getPlayer() {
        return player;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}