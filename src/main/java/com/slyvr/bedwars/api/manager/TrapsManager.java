package com.slyvr.bedwars.api.manager;

import com.slyvr.bedwars.api.trap.Trap;

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