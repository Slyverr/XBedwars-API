package com.slyvr.bedwars.api.event.game;

import com.slyvr.bedwars.api.game.Game;
import com.slyvr.bedwars.api.game.Game.GameState;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class GameStateChangeEvent extends GameEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final GameState oldState;
    private final GameState newState;


    public GameStateChangeEvent(@NotNull Game game, @NotNull GameState oldState, @NotNull GameState newState) {
        super(game);

        this.oldState = oldState;
        this.newState = newState;
    }


    @NotNull
    public GameState getOldState() {
        return oldState;
    }


    @NotNull
    public GameState getNewState() {
        return newState;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}