package com.slyvr.xbedwars.api.event.player.elimination;

import com.slyvr.xbedwars.api.event.player.GamePlayerEvent;
import com.slyvr.xbedwars.api.player.GamePlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class GamePlayerEliminateEvent extends GamePlayerEvent {

    private static final HandlerList HANDLERS = new HandlerList();


    public GamePlayerEliminateEvent(@NotNull GamePlayer player) {
        super(player);
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}