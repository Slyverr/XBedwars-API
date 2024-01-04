package com.slyvr.bedwars.api.event.shop;

import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.api.shop.Shop;
import com.slyvr.bedwars.api.shop.ShopCategory;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;


public class ShopClickEvent extends ShopEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();


    private final GamePlayer player;
    private final int slot;

    private boolean isCancelled;

    public ShopClickEvent(@NotNull Shop<?> shop, @Nullable ShopCategory category, @NotNull GamePlayer player, @Range(from = 0, to = 53) int slot) {
        super(shop, category);

        this.player = player;
        this.slot = slot;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @NotNull
    public GamePlayer getWhoClicked() {
        return player;
    }

    @Range(from = 0, to = 53)
    public int getClickedSlot() {
        return slot;
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

}