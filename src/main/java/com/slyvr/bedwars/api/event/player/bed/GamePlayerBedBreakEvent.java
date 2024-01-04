package com.slyvr.bedwars.api.event.player.bed;

import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import com.slyvr.bedwars.api.arena.team.ArenaTeamBed;
import com.slyvr.bedwars.api.event.EventMessageHandler;
import com.slyvr.bedwars.api.event.player.GamePlayerEvent;
import com.slyvr.bedwars.api.lang.Message;
import com.slyvr.bedwars.api.player.GamePlayer;


public class GamePlayerBedBreakEvent extends GamePlayerEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final EventMessageHandler break_message_handler = new EventMessageHandler(Message.BED_BREAK);
    private final EventMessageHandler lost_message_handler = new EventMessageHandler(Message.BED_LOST);
    private final ArenaTeamBed bed;
    private String break_message;
    private String team_message;

    private boolean isCancelled;


    public GamePlayerBedBreakEvent(@NotNull GamePlayer player, @NotNull ArenaTeamBed bed) {
        super(player);

        this.bed = bed;
    }


    @NotNull
    public ArenaTeamBed getBed() {
        return bed;
    }


    @NotNull
    public EventMessageHandler getBedBreakMessageHandler() {
        return break_message_handler;
    }


    @NotNull
    public EventMessageHandler getBedLostMessageHandler() {
        return lost_message_handler;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}