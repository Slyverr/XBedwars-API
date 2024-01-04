package com.slyvr.bedwars.api.scoreboard.generic;

import org.jetbrains.annotations.NotNull;

import com.slyvr.bedwars.api.scoreboard.Scoreboard;


public interface GenericScoreboard<T> extends Scoreboard {


    void updateTitle(@NotNull T type);


    void update(@NotNull T type);

}