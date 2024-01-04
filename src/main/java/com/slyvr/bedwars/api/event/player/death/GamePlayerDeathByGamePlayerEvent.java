package com.slyvr.bedwars.api.event.player.death;

import com.slyvr.bedwars.api.generator.Resource;
import com.slyvr.bedwars.api.lang.Message;
import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


public class GamePlayerDeathByGamePlayerEvent extends GamePlayerDeathEvent {

    private final GamePlayer killer;

    public GamePlayerDeathByGamePlayerEvent(@NotNull GamePlayer player, @NotNull GamePlayer killer, @NotNull Map<Resource, Integer> drops, @NotNull DamageCause cause, boolean isFinal) {
        super(player, drops, cause, isFinal);

        this.killer = killer;
    }

    @Override
    protected @NotNull Message getDeathMessage(@NotNull DamageCause cause) {
        if (isFinal)
            return cause == DamageCause.VOID ? Message.PLAYER_DEATH_VOID_THROWN_BY_PLAYER_FINAL : Message.PLAYER_DEATH_KILLED_BY_PLAYER_FINAL;
        else
            return cause == DamageCause.VOID ? Message.PLAYER_DEATH_VOID_THROWN_BY_PLAYER : Message.PLAYER_DEATH_KILLED_BY_PLAYER;
    }

    @NotNull
    public GamePlayer getKiller() {
        return killer;
    }

}