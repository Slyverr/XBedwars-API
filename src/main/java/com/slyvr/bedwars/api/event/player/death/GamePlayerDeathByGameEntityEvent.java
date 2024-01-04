package com.slyvr.bedwars.api.event.player.death;

import com.slyvr.bedwars.api.entity.GameEntity;
import com.slyvr.bedwars.api.generator.Resource;
import com.slyvr.bedwars.api.lang.Message;
import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


public class GamePlayerDeathByGameEntityEvent extends GamePlayerDeathEvent {

    private final GameEntity entity;

    public GamePlayerDeathByGameEntityEvent(@NotNull GamePlayer player, @NotNull GameEntity entity, @NotNull Map<Resource, Integer> drops, @NotNull DamageCause cause, boolean isFinal) {
        super(player, drops, cause, isFinal);

        this.entity = entity;
    }

    @Override
    protected @NotNull Message getDeathMessage(@NotNull DamageCause cause) {
        if (isFinal)
            return cause == DamageCause.VOID ? Message.PLAYER_DEATH_VOID_THROWN_BY_ENTITY_FINAL : Message.PLAYER_DEATH_KILLED_BY_ENTITY_FINAL;
        else
            return cause == DamageCause.VOID ? Message.PLAYER_DEATH_VOID_THROWN_BY_ENTITY : Message.PLAYER_DEATH_KILLED_BY_ENTITY;
    }

    @NotNull
    public GameEntity getKiller() {
        return entity;
    }


    @NotNull
    public GamePlayer getOwner() {
        return entity.getOwner();
    }

}