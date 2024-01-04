package com.slyvr.bedwars.api.generator.team;

import com.slyvr.bedwars.api.generator.Resource;
import com.slyvr.bedwars.api.generator.ResourceGenerator;
import com.slyvr.bedwars.api.team.TeamColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;


public interface TeamResourceGenerator extends ResourceGenerator {


    @NotNull
    TeamColor getTeamColor();


    @NotNull
    Set<TeamResourceGeneratorDrop> getDrops();


    @Nullable
    TeamResourceGeneratorDrop getDrop(@NotNull Resource resource);


    void addDrop(@NotNull TeamResourceGeneratorDrop drop);


    @Nullable
    TeamResourceGeneratorDrop removeDrop(@NotNull Resource resource);


    void updateDrop(@NotNull Resource resource);


    boolean hasDrop(@NotNull Resource resource);

}