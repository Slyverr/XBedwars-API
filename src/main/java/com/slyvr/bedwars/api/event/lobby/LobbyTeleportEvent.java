package com.slyvr.bedwars.api.event.lobby;

import com.slyvr.bedwars.api.event.EventMessageHandler;
import com.slyvr.bedwars.api.lang.Message;
import com.slyvr.bedwars.api.lobby.Lobby;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class LobbyTeleportEvent extends LobbyEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final EventMessageHandler message_handler = new EventMessageHandler(Message.LOBBY_TELEPORT_SUCCESS);
    private final Player player;

    private boolean isCancelled;

    public LobbyTeleportEvent(@NotNull Lobby lobby, @NotNull Player player) {
        super(lobby);

        this.player = player;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    @NotNull
    public EventMessageHandler getEliminationMessageHandler() {
        return message_handler;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}