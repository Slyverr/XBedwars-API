package com.slyvr.bedwars.api.arena.team;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.NotNull;

import com.slyvr.bedwars.api.team.TeamColor;

public interface ArenaTeamBed {


    @NotNull
    TeamColor getTeamColor();


    @NotNull
    Block getHead();


    @NotNull
    Block getFoot();


    @NotNull
    BlockFace getFacing();


    void place();


    boolean destroy();


    boolean isDestroyed();

}
