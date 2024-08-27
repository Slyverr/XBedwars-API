package com.slyvr.xbedwars.api.entity;

import com.slyvr.xbedwars.api.player.GamePlayer;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public interface GameEntity {


    @NotNull
    GamePlayer getOwner();


    @NotNull
    GameEntityType<?> getGameEntityType();


    @Nullable
    Entity getEntity();


    @NotNull
    Entity spawn();


    boolean remove();


    boolean isDead();

}