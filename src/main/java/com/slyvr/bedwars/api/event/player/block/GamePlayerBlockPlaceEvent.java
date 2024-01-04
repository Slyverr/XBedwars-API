package com.slyvr.bedwars.api.event.player.block;

import com.slyvr.bedwars.api.event.player.GamePlayerEvent;
import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class GamePlayerBlockPlaceEvent extends GamePlayerEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Block block;

    private boolean isCancelled;


    public GamePlayerBlockPlaceEvent(@NotNull GamePlayer player, @NotNull Block block) {
        super(player);

        this.block = block;
    }


    @NotNull
    public Block getBlock() {
        return block;
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