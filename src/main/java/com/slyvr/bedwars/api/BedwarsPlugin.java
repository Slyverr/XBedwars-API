package com.slyvr.bedwars.api;

import com.slyvr.bedwars.api.manager.ArenasManager;
import com.slyvr.bedwars.api.manager.GamesManager;
import com.slyvr.bedwars.api.manager.LobbiesManager;
import com.slyvr.bedwars.api.manager.ScoreboardsManager;
import com.slyvr.bedwars.api.manager.TrapsManager;
import com.slyvr.bedwars.api.manager.UpgradesManager;
import com.slyvr.bedwars.api.manager.UsersManager;
import com.slyvr.bedwars.api.user.level.UserPrestige;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;


public interface BedwarsPlugin extends Plugin {

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
    BedwarsPluginUtils getUtils();

}