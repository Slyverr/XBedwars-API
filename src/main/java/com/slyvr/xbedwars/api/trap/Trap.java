package com.slyvr.xbedwars.api.trap;

import com.slyvr.xbedwars.api.player.GamePlayer;
import com.slyvr.xbedwars.api.team.TeamColor;
import org.jetbrains.annotations.NotNull;


public interface Trap {


    @NotNull
    String getName();


    @NotNull
    TrapTarget getTarget();


    int getDuration();


    boolean onTrigger(@NotNull GamePlayer player, @NotNull TeamColor color);

}