package com.slyvr.xbedwars.api.scoreboard.generic.custom;

import org.jetbrains.annotations.NotNull;

import com.slyvr.xbedwars.api.player.GamePlayer;
import com.slyvr.xbedwars.api.scoreboard.generic.GenericScoreboard;
import com.slyvr.xbedwars.api.scoreboard.generic.GenericScoreboardPlaceholder;
import com.slyvr.xbedwars.api.scoreboard.generic.GenericScoreboardType;


public interface GameScoreboard extends GenericScoreboard<GamePlayer> {


    abstract class GameScoreboardPlaceholder extends GenericScoreboardPlaceholder<GamePlayer> {


        public GameScoreboardPlaceholder(@NotNull String placeholder) {
            super(GenericScoreboardType.GAME, placeholder);
        }

    }

}