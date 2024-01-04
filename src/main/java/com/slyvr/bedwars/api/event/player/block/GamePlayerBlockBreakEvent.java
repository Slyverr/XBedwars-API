package com.slyvr.bedwars.api.event.player.block;

import com.slyvr.bedwars.api.event.player.GamePlayerEvent;
import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class GamePlayerBlockBreakEvent extends GamePlayerEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Block block;
    private final boolean isMapBlock;

    private boolean isCancelled;


    public GamePlayerBlockBreakEvent(@NotNull GamePlayer player, @NotNull Block block, boolean map) {
        super(player);

        this.block = block;
        this.isMapBlock = map;
    }


    public GamePlayerBlockBreakEvent(@NotNull GamePlayer player, @NotNull Block block) {
        this(player, block, false);
    }


    @NotNull
    public Block getBlock() {
        return block;
    }


    public boolean isMapBlock() {
        return isMapBlock;
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