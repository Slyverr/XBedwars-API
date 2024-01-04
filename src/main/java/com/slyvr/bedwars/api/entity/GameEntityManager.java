package com.slyvr.bedwars.api.entity;

import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public interface GameEntityManager {
    
    @NotNull <T extends GameEntity> T create(@NotNull GameEntityType<T> type, @NotNull GamePlayer owner, @NotNull Location loc);

    @Nullable
    GameEntity getEntity(@NotNull Entity entity);

}
