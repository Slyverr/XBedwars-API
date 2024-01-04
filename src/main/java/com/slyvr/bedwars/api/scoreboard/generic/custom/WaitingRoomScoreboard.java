package com.slyvr.bedwars.api.scoreboard.generic.custom;

import org.jetbrains.annotations.NotNull;

import com.slyvr.bedwars.api.room.WaitingRoomUser;
import com.slyvr.bedwars.api.scoreboard.generic.GenericScoreboard;
import com.slyvr.bedwars.api.scoreboard.generic.GenericScoreboardPlaceholder;
import com.slyvr.bedwars.api.scoreboard.generic.GenericScoreboardType;


public interface WaitingRoomScoreboard extends GenericScoreboard<WaitingRoomUser> {


    abstract class WaitingRoomScoreboardPlaceholder extends GenericScoreboardPlaceholder<WaitingRoomUser> {


        public WaitingRoomScoreboardPlaceholder(@NotNull String placeholder) {
            super(GenericScoreboardType.WAITING_ROOM, placeholder);
        }

    }

}