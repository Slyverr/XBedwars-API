package com.slyvr.bedwars.api.lobby;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface Lobby {

    @NotNull
    String getName();

    int getCapacity();

    int getPlayersCount();

    boolean send(@NotNull Player player, boolean force);

    boolean send(@NotNull Player player);

    boolean contains(@NotNull Player player);

    boolean isFull();

}