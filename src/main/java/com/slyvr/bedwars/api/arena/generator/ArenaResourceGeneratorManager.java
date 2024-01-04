package com.slyvr.bedwars.api.arena.generator;

import com.slyvr.bedwars.api.generator.Resource;
import com.slyvr.bedwars.api.generator.team.TeamResourceGeneratorPreset;
import com.slyvr.bedwars.api.generator.tiered.TieredResourceGeneratorPreset;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public interface ArenaResourceGeneratorManager {


    @NotNull
    List<Location> getResourceGeneratorLocations(@NotNull Resource resource);


    void addResourceGenerator(@NotNull Resource resource, @NotNull Location loc);


    boolean removeResourceGenerator(@NotNull Resource resource, int index);


    @Nullable
    TieredResourceGeneratorPreset getTieredResourceGeneratorPreset(@NotNull Resource resource);


    void setTieredResourceGeneratorPreset(@NotNull Resource resource, @NotNull TieredResourceGeneratorPreset preset);


    @Nullable
    TeamResourceGeneratorPreset getTeamResourceGeneratorPreset();


    void setTeamResourceGeneratorPreset(@NotNull TeamResourceGeneratorPreset preset);


    double getTeamResourceGeneratorSplittingRadius();


    void setTeamResourceGeneratorSplittingRadius(double radius);


    boolean isTeamResourceGeneratorSplitting();


    void setTeamResourceGeneratorSplitting(boolean split);

}