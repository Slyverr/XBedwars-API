package com.slyvr.bedwars.api.room;

import java.util.Map;
import java.util.Set;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.slyvr.bedwars.api.team.TeamColor;


public interface WaitingRoomTeamManager {


    @NotNull
    Map<Player, TeamColor> getPlayers();


    @NotNull
    Set<Player> getUnassignedPlayers();


    @NotNull
    Set<Player> getAssignedPlayers();


    @NotNull
    Set<Player> getAssignedPlayers(@NotNull TeamColor color);


    @Nullable
    TeamColor getAssignedColor(@NotNull Player player);


    void setAssignedColor(@NotNull Player player, @Nullable TeamColor color);


    int getAssignedCount(@NotNull TeamColor color);


    void clear();

}