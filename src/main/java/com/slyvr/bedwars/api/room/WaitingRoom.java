package com.slyvr.bedwars.api.room;

import com.slyvr.bedwars.api.game.Game;
import com.slyvr.bedwars.api.scoreboard.generic.custom.WaitingRoomScoreboard;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Consumer;


public interface WaitingRoom {


    @NotNull
    Game getGame();


    @NotNull
    WaitingRoomCountdownManager getCountdownManager();


    @NotNull
    WaitingRoomTeamManager getTeamManager();


    @NotNull
    WaitingRoomScoreboard getScoreboard();


    void setScoreboard(@NotNull WaitingRoomScoreboard board);


    boolean addPlayer(@NotNull Player player);


    boolean removePlayer(@NotNull Player player);


    boolean addPlayers(@NotNull Collection<Player> players);


    boolean removePlayers(@NotNull Collection<Player> players);


    boolean contains(@NotNull Player player);

    boolean isReady();

    void broadcastMessage(@NotNull String message);

    void forEach(@NotNull Consumer<Player> action);

    void clear();

    int capacity();

    int size();

}