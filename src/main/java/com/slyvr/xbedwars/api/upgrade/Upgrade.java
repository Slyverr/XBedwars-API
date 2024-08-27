package com.slyvr.xbedwars.api.upgrade;

import com.slyvr.xbedwars.api.team.GameTeam;
import org.jetbrains.annotations.NotNull;


public interface Upgrade {


    @NotNull
    String getName();

    boolean apply(@NotNull GameTeam team);

}