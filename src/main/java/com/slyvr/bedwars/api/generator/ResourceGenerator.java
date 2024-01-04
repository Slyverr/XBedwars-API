package com.slyvr.bedwars.api.generator;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import com.slyvr.bedwars.api.game.Game;


public interface ResourceGenerator {


    @NotNull
    Game getGame();


    void start();


    void stop();


    @NotNull
    Location getDropLocation();


    void setDropLocation(@NotNull Location loc);


    boolean isRunning();

}