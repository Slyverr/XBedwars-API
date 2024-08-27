package com.slyvr.xbedwars.api.team;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.slyvr.xbedwars.api.trap.Trap;


public interface GameTeamTrapManager {


    @NotNull
    List<Trap> getTraps();

    boolean addTrap(@NotNull Trap trap);

    // TODO: Documentation
    boolean removeTrap(@NotNull Trap trap);


    boolean contains(@NotNull Trap trap);


    int size();

}