package com.slyvr.xbedwars.api.scoreboard.generic.custom;

import org.jetbrains.annotations.NotNull;

import com.slyvr.xbedwars.api.scoreboard.generic.GenericScoreboard;
import com.slyvr.xbedwars.api.scoreboard.generic.GenericScoreboardPlaceholder;
import com.slyvr.xbedwars.api.scoreboard.generic.GenericScoreboardType;
import com.slyvr.xbedwars.api.user.User;


public interface LobbyScoreboard extends GenericScoreboard<User> {


    abstract class LobbyScoreboardPlaceholder extends GenericScoreboardPlaceholder<User> {


        public LobbyScoreboardPlaceholder(@NotNull String placeholder) {
            super(GenericScoreboardType.LOBBY, placeholder);
        }

    }

}