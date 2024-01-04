package com.slyvr.bedwars.api.manager;

import java.util.Collection;
import java.util.function.Predicate;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.slyvr.bedwars.api.arena.Arena;
import com.slyvr.bedwars.api.game.Game;


public interface GamesManager {


    @NotNull
    Collection<Game> getGames();


    @NotNull
    Game create(@NotNull Arena arena, boolean prv) throws NullPointerException, IllegalStateException;


    @NotNull
    Game create(@NotNull Arena arena) throws NullPointerException, IllegalStateException;


    @Nullable
    Game getGame(@NotNull Arena arena);


    @Nullable
    Game getPlayerGame(@NotNull Player player);


    @Nullable
    Game addPlayerToRandomGame(@NotNull Player player, @Nullable Predicate<Game> predicate);


    @Nullable
    Game addPlayerToRandomGame(@NotNull Player player);


    @Nullable
    Game getRandomGame(@Nullable Predicate<Game> predicate);


    @Nullable
    Game getRandomGame();


    boolean inGame(@NotNull Player player);


    boolean inRunningGame(@NotNull Player player);

}