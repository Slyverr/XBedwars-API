package com.slyvr.bedwars.api.event.game;

import com.slyvr.bedwars.api.game.Game;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;


public abstract class GameEvent extends Event {

    protected Game game;


    public GameEvent(@NotNull Game game, boolean async) {
        super(async);

        this.game = game;
    }


    public GameEvent(@NotNull Game game) {
        this.game = game;
    }


    @NotNull
    public Game getGame() {
        return game;
    }

}