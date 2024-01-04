package com.slyvr.bedwars.api.event.player.death;

import com.slyvr.bedwars.api.boss.GameBoss;
import com.slyvr.bedwars.api.generator.Resource;
import com.slyvr.bedwars.api.lang.Message;
import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class GamePlayerDeathByGameBossEvent extends GamePlayerDeathEvent {

    private final GameBoss boss;

    public GamePlayerDeathByGameBossEvent(@NotNull GamePlayer player, @NotNull GameBoss boss, @NotNull Map<Resource, Integer> drops, @NotNull DamageCause cause, boolean isFinal) {
        super(player, drops, cause, isFinal);

        this.boss = boss;
    }

    @Override
    protected @NotNull Message getDeathMessage(@NotNull DamageCause cause) {
        return Message.PLAYER_DEATH;
    }

    @NotNull
    public GameBoss getKiller() {
        return boss;
    }

}