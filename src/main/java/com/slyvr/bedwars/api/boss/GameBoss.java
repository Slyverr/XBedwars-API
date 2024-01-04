package com.slyvr.bedwars.api.boss;

import com.slyvr.bedwars.api.team.GameTeam;
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