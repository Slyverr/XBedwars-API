package com.slyvr.bedwars.api.event.room;

import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import com.slyvr.bedwars.api.room.WaitingRoom;


public abstract class WaitingRoomEvent extends Event {

    protected WaitingRoom room;


    public WaitingRoomEvent(@NotNull WaitingRoom room, boolean async) {
        super(async);

        this.room = room;
    }


    public WaitingRoomEvent(@NotNull WaitingRoom room) {
        this.room = room;
    }


    @NotNull
    public WaitingRoom getWaitingRoom() {
        return room;
    }

}
