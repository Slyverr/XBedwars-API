package com.slyvr.bedwars.api.manager;

import com.slyvr.bedwars.api.game.GameMode;
import com.slyvr.bedwars.api.scoreboard.generic.GenericScoreboardType;
import com.slyvr.scoreboard.ScoreboardTitle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public interface ScoreboardsManager {

    @NotNull <T> T getMainScoreboard(@NotNull GenericScoreboardType<T, ?> type, @Nullable GameMode mode);

    @NotNull <T> T getMainScoreboard(@NotNull GenericScoreboardType<T, ?> type);

    @NotNull <T> T getNewScoreboard(@NotNull GenericScoreboardType<T, ?> type, @NotNull ScoreboardTitle title);

    @NotNull <T> T getNewScoreboard(@NotNull GenericScoreboardType<T, ?> type);

}