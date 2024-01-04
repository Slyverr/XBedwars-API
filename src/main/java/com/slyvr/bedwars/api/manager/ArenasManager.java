package com.slyvr.bedwars.api.manager;

import java.util.Collection;
import java.util.function.Predicate;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.slyvr.bedwars.api.arena.Arena;


public interface ArenasManager {


    @NotNull
    Collection<Arena> getArenas();


    @NotNull
    Collection<Arena> getReadyArenas();


    @Nullable
    Arena getRandomArena();


    @Nullable
    Arena getRandomArena(@Nullable Predicate<Arena> predicate);


    @Nullable
    Arena getArena(@NotNull String name);


    @NotNull
    Arena create(@NotNull String name) throws NullPointerException;


    boolean remove(@NotNull String name);


    boolean isOccupied(@NotNull Arena arena);

}