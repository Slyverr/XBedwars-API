package com.slyvr.xbedwars.api.event.lobby;

import com.slyvr.xbedwars.api.lobby.Lobby;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;


public abstract class LobbyEvent extends Event {

    protected final Lobby lobby;

    public LobbyEvent(@NotNull Lobby lobby) {
        this.lobby = lobby;
    }

    @NotNull
    public Lobby getLobby() {
        return lobby;
    }

}