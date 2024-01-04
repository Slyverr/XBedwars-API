package com.slyvr.bedwars.api.event.team;

import com.slyvr.bedwars.api.boss.GameBossType;
import com.slyvr.bedwars.api.team.GameTeam;
import org.bukkit.Location;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class GameTeamBossCreationEvent extends GameTeamEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Location boss_loc;
    private GameBossType<?> boss_type;

    public GameTeamBossCreationEvent(@NotNull GameTeam team, @NotNull GameBossType<?> type, @NotNull Location loc) {
        super(team);

        this.boss_type = boss_type;
        this.boss_loc = loc;
    }


    @NotNull
    public GameBossType<?> getBossType() {
        return boss_type;
    }


    public void setBossType(@NotNull GameBossType<?> type) {
        if (type != null)
            this.boss_type = type;
    }

    @NotNull
    public Location getSpawnLocation() {
        return boss_loc.clone();
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}