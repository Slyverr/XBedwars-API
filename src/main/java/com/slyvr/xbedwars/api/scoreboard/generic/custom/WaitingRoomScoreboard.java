package com.slyvr.xbedwars.api.scoreboard.generic.custom;

import org.jetbrains.annotations.NotNull;

import com.slyvr.xbedwars.api.room.WaitingRoomUser;
import com.slyvr.xbedwars.api.scoreboard.generic.GenericScoreboard;
import com.slyvr.xbedwars.api.scoreboard.generic.GenericScoreboardPlaceholder;
import com.slyvr.xbedwars.api.scoreboard.generic.GenericScoreboardType;


public interface WaitingRoomScoreboard extends GenericScoreboard<WaitingRoomUser> {


    abstract class WaitingRoomScoreboardPlaceholder extends GenericScoreboardPlaceholder<WaitingRoomUser> {


        public WaitingRoomScoreboardPlaceholder(@NotNull String placeholder) {
            super(GenericScoreboardType.WAITING_ROOM, placeholder);
        }

    }

}