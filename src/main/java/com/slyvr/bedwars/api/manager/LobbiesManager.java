package com.slyvr.bedwars.api.manager;

import com.slyvr.bedwars.api.lobby.Lobby;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface LobbiesManager {

    @NotNull
    Collection<Lobby> getLobbies();

    @Nullable
    Lobby getLobby(@NotNull String name);

    @Nullable
    Lobby getRandomLobby(int places);

    @Nullable
    Lobby getRandomLobby();

    @Nullable
    Lobby sendToRandomLobby(@NotNull Player player);

}