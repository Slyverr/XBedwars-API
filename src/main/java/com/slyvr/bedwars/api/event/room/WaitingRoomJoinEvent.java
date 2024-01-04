package com.slyvr.bedwars.api.event.room;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import com.slyvr.bedwars.api.event.EventMessageHandler;
import com.slyvr.bedwars.api.lang.Message;
import com.slyvr.bedwars.api.room.WaitingRoom;


public class WaitingRoomJoinEvent extends WaitingRoomEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final EventMessageHandler message_handler = new EventMessageHandler(Message.WAITING_ROOM_JOIN);
    private final Player player;

    private boolean isCancelled;


    public WaitingRoomJoinEvent(@NotNull WaitingRoom room, @NotNull Player player) {
        super(room);

        this.player = player;
    }


    @NotNull
    public Player getPlayer() {
        return player;
    }


    @NotNull
    public EventMessageHandler getJoinMessageHandler() {
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