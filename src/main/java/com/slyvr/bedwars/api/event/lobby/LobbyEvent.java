package com.slyvr.bedwars.api.event.lobby;

import com.slyvr.bedwars.api.lobby.Lobby;
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