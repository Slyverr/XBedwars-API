package com.slyvr.bedwars.api.arena;

import com.slyvr.bedwars.api.arena.generator.ArenaResourceGeneratorManager;
import com.slyvr.bedwars.api.arena.team.ArenaTeam;
import com.slyvr.bedwars.api.game.GameMode;
import com.slyvr.bedwars.api.game.phase.GamePhasePreset;
import com.slyvr.bedwars.api.team.TeamColor;
import com.slyvr.bedwars.utils.Region;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;


public interface Arena {


    @NotNull
    String getName();


    @Nullable
    String getMapName();


    void setMapName(@NotNull String name);


    int getTime();


    void setTime(int time);


    @Nullable
    GameMode getMode();


    void setMode(@NotNull GameMode mode);


    @NotNull
    GamePhasePreset getPhasesPreset();


    void setPhasesPreset(@NotNull GamePhasePreset preset);


    @NotNull
    Set<ArenaTeam> getReadyTeams();


    @NotNull
    ArenaTeam getTeam(@NotNull TeamColor color);


    @NotNull
    ArenaResourceGeneratorManager getResourceGeneratorManager();


    @Nullable
    Location getBossSpawnLocation();


    void setBossSpawnLocation(@NotNull Location loc);


    @Nullable
    Location getSpectatorSpawnLocation();


    void setSpectatorSpawnLocation(@NotNull Location loc);


    @Nullable
    Location getWaitingRoomSpawnLocation();


    void setWaitingRoomSpawnLocation(@NotNull Location loc);


    @Nullable
    Region getRegion();


    void setRegion(@NotNull Region region);


    @Nullable
    Region getWaitingRoomRegion();


    void setWaitingRoomRegion(@NotNull Region region);


    int getReadyTeamsCount();


    boolean isEnabled();


    void setEnabled(boolean enabled);


    void loadData();


    void saveData();


    boolean isReady();

}