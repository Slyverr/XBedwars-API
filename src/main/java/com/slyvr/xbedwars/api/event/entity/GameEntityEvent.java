package com.slyvr.xbedwars.api.event.entity;

import com.slyvr.xbedwars.api.entity.GameEntity;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;


public abstract class GameEntityEvent extends Event {

    protected GameEntity entity;


    public GameEntityEvent(@NotNull GameEntity entity, boolean async) {
        super(async);

        this.entity = entity;
    }


    public GameEntityEvent(@NotNull GameEntity entity) {
        this.entity = entity;
    }


    @NotNull
    public final GameEntity getGameEntity() {
        return entity;
    }

}