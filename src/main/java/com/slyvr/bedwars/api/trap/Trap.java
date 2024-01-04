package com.slyvr.bedwars.api.trap;

import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.api.team.TeamColor;
import org.jetbrains.annotations.NotNull;


public interface Trap {


    @NotNull
    String getName();


    @NotNull
    TrapTarget getTarget();


    int getDuration();


    boolean onTrigger(@NotNull GamePlayer player, @NotNull TeamColor color);

}