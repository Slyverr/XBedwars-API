package com.slyvr.bedwars.api.event.team;

import com.slyvr.bedwars.api.team.GameTeam;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;


public abstract class GameTeamEvent extends Event {

    protected GameTeam team;


    public GameTeamEvent(@NotNull GameTeam team) {
        this.team = team;
    }


    @NotNull
    public GameTeam getTeam() {
        return team;
    }

}