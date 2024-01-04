package com.slyvr.bedwars.api.event.player.connection;

import com.slyvr.bedwars.api.event.EventMessageHandler;
import com.slyvr.bedwars.api.event.player.GamePlayerEvent;
import com.slyvr.bedwars.api.lang.Message;
import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class GamePlayerReconnectEvent extends GamePlayerEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final EventMessageHandler message_handler = new EventMessageHandler(Message.PLAYER_CONNECTION_RECONNECT);
    private boolean isCancelled;

    public GamePlayerReconnectEvent(@NotNull GamePlayer player) {
        super(player);
    }

    @NotNull
    public EventMessageHandler getReconnectMessageHandler() {
        return message_handler;
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