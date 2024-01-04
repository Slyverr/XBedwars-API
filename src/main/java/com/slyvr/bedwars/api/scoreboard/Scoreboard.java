package com.slyvr.bedwars.api.scoreboard;

import com.slyvr.scoreboard.ScoreboardTitle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.List;


public interface Scoreboard {


    @NotNull
    ScoreboardTitle getTitle();


    @NotNull
    List<String> getLines();


    void setLines(@NotNull List<String> lines);


    @Nullable
    String getText(@Range(from = 1, to = 15) int line);


    void setText(@Range(from = 1, to = 15) int line, @Nullable String text);

}