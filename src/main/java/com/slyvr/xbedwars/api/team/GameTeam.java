package com.slyvr.xbedwars.api.team;

import com.slyvr.xbedwars.api.game.Game;
import com.slyvr.xbedwars.api.generator.team.TeamResourceGenerator;
import org.jetbrains.annotations.NotNull;


public interface GameTeam {


    @NotNull
    Game getGame();


    @NotNull
    TeamColor getColor();


    @NotNull
    TeamResourceGenerator getResourceGenerator();


    @NotNull
    GameTeamUpgradeManager getUpgradeManager();


    @NotNull
    GameTeamTrapManager getTrapManager();

}