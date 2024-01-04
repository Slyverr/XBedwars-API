package com.slyvr.bedwars.api.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.slyvr.bedwars.api.game.Game;
import com.slyvr.bedwars.api.lang.Message;
import com.slyvr.bedwars.api.scoreboard.generic.custom.LobbyScoreboard;
import com.slyvr.bedwars.api.user.level.UserLevel;
import com.slyvr.bedwars.api.user.level.UserPrestige;


public interface User extends OfflineUser {


    @Nullable
    Game getGame();


    boolean hasDisplayLevel();


    @Nullable
    UserLevel getDisplayLevel();


    void setDisplayLevel(@Nullable UserLevel level);


    boolean hasDisplayPrestige();


    @Nullable
    UserPrestige getDisplayPrestige();


    void setDisplayPrestige(@Nullable UserPrestige prestige);


    @NotNull
    LobbyScoreboard getScoreboard();


    void setScoreboard(@NotNull LobbyScoreboard board);


    void sendMessage(@NotNull Message message, Object... args);


    void sendMessage(@NotNull String message);


    void update();

}