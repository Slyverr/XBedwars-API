package com.slyvr.bedwars.api.event.player;

import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;


public abstract class GamePlayerEvent extends Event {

    protected GamePlayer player;


    protected GamePlayerEvent(@NotNull GamePlayer player, boolean async) {
        super(async);

        this.player = player;
    }


    public GamePlayerEvent(@NotNull GamePlayer player) {
        this.player = player;
    }


    @NotNull
    public final GamePlayer getGamePlayer() {
        return player;
    }

}