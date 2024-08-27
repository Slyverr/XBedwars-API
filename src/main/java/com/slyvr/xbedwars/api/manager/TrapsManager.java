package com.slyvr.xbedwars.api.manager;

import com.slyvr.xbedwars.api.trap.Trap;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;


public interface TrapsManager {


    @NotNull
    Collection<Trap> getTraps();


    @Nullable
    Trap getTrap(@NotNull String name);


    void registerTrap(@NotNull String name, @NotNull Trap trap);

}