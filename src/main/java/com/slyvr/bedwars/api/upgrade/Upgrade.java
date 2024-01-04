package com.slyvr.bedwars.api.upgrade;

import com.slyvr.bedwars.api.team.GameTeam;
import org.jetbrains.annotations.NotNull;


public interface Upgrade {


    @NotNull
    String getName();

    boolean apply(@NotNull GameTeam team);

}