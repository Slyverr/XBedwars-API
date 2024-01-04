package com.slyvr.bedwars.api.event.room;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import com.slyvr.bedwars.api.event.EventMessageHandler;
import com.slyvr.bedwars.api.lang.Message;
import com.slyvr.bedwars.api.room.WaitingRoom;


public class WaitingRoomQuitEvent extends WaitingRoomEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final EventMessageHandler message_handler = new EventMessageHandler(Message.WAITING_ROOM_QUIT);
    private final Player player;


    public WaitingRoomQuitEvent(@NotNull WaitingRoom room, @NotNull Player player) {
        super(room);

        this.player = player;
    }


    @NotNull
    public Player getPlayer() {
        return player;
    }


    @NotNull
    public EventMessageHandler getQuitMessageHandler() {
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