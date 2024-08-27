package com.slyvr.xbedwars.api.event.boss;

import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import com.slyvr.xbedwars.api.boss.GameBoss;


public abstract class GameBossEvent extends Event {

    protected GameBoss boss;


    public GameBossEvent(@NotNull GameBoss boss, boolean async) {
        super(async);

        this.boss = boss;
    }


    public GameBossEvent(@NotNull GameBoss boss) {
        this.boss = boss;
    }


    @NotNull
    public final GameBoss getBoss() {
        return boss;
    }

}
