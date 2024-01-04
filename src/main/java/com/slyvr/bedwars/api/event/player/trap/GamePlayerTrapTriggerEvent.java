package com.slyvr.bedwars.api.event.player.trap;

import com.slyvr.bedwars.api.event.player.GamePlayerEvent;
import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.api.team.TeamColor;
import com.slyvr.bedwars.api.trap.Trap;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class GamePlayerTrapTriggerEvent extends GamePlayerEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Trap trap;
    private final TeamColor color;

    private boolean isCancelled;

    public GamePlayerTrapTriggerEvent(@NotNull GamePlayer player, @NotNull Trap trap, @NotNull TeamColor color) {
        super(player);

        this.trap = trap;
        this.color = color;
    }


    @NotNull
    public Trap getTrap() {
        return trap;
    }


    @NotNull
    public TeamColor getTrapTeamColor() {
        return color;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}