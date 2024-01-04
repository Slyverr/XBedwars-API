package com.slyvr.bedwars.api.lobby;

import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

public interface WorldLobby extends Lobby {

    @NotNull
    World getWorld();

    @NotNull
    Location getLocation();

}