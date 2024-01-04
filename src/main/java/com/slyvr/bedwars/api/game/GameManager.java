package com.slyvr.bedwars.api.game;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.slyvr.bedwars.api.game.phase.GamePhase;
import com.slyvr.bedwars.api.scoreboard.generic.custom.GameScoreboard;


public interface GameManager {


    @NotNull
    Game getGame();


    boolean start();


    boolean stop();


    @NotNull
    GameScoreboard getScoreboard();


    void setScoreboard(@NotNull GameScoreboard board);


    @Nullable
    GamePhase getPreviousPhase();


    @Nullable
    GamePhase getCurrentPhase();


    @Nullable
    GamePhase getNextPhase();


    long getGameLength();


    long getCurrentTime();


    long getTimeLeft();


    long getTimeLeftForNextPhase();

}