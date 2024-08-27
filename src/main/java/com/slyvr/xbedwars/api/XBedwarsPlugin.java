package com.slyvr.xbedwars.api;

import com.slyvr.xbedwars.api.manager.ArenasManager;
import com.slyvr.xbedwars.api.manager.GamesManager;
import com.slyvr.xbedwars.api.manager.LobbiesManager;
import com.slyvr.xbedwars.api.manager.ScoreboardsManager;
import com.slyvr.xbedwars.api.manager.TrapsManager;
import com.slyvr.xbedwars.api.manager.UpgradesManager;
import com.slyvr.xbedwars.api.manager.UsersManager;
import com.slyvr.xbedwars.api.user.level.UserPrestige;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;


public interface XBedwarsPlugin extends Plugin {

    @NotNull
    UserPrestige getDefaultPrestige();


    @NotNull
    UsersManager getUsersManager();

    @NotNull
    LobbiesManager getLobbiesManager();

    @NotNull
    ArenasManager getArenasManager();

    @NotNull
    GamesManager getGamesManager();

    @NotNull
    ScoreboardsManager getScoreboardsManager();

    @NotNull
    UpgradesManager getUpgradesManager();

    @NotNull
    TrapsManager getTrapsManager();

    @NotNull
    XBedwarsUtils getUtils();

}