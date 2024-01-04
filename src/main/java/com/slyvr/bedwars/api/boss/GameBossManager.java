package com.slyvr.bedwars.api.boss;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.slyvr.bedwars.api.team.GameTeam;


public interface GameBossManager {


    @NotNull
    <T extends GameBoss> T createBoss(@NotNull GameBossType<T> type, @NotNull GameTeam team, @NotNull Location loc);


    @Nullable
    GameBoss getBoss(@NotNull Entity entity);

}