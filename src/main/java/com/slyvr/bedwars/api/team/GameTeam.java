package com.slyvr.bedwars.api.team;

import com.slyvr.bedwars.api.game.Game;
import com.slyvr.bedwars.api.generator.team.TeamResourceGenerator;
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