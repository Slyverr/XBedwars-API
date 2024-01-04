package com.slyvr.bedwars.api.event.player.connection;

import com.slyvr.bedwars.api.event.EventMessageHandler;
import com.slyvr.bedwars.api.event.player.GamePlayerEvent;
import com.slyvr.bedwars.api.lang.Message;
import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class GamePlayerDisconnectEvent extends GamePlayerEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final EventMessageHandler message_handler = new EventMessageHandler(Message.PLAYER_CONNECTION_DISCONNECT);


    public GamePlayerDisconnectEvent(@NotNull GamePlayer player) {
        super(player);
    }

    @NotNull
    public EventMessageHandler getDisconnectMessageHandler() {
        return message_handler;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}