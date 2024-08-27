package com.slyvr.xbedwars.api.boss;

import com.slyvr.xbedwars.api.team.GameTeam;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public interface GameBoss {


    @NotNull
    GameTeam getGameTeam();


    @NotNull
    GameBossType<?> getBossType();


    @Nullable
    Entity getEntity();


    @NotNull
    Entity spawn();


    boolean remove();


    boolean isDead();

}