package com.slyvr.xbedwars.api.generator;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import com.slyvr.xbedwars.api.game.Game;


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