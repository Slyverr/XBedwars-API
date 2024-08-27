package com.slyvr.xbedwars.api.event.team;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import com.slyvr.xbedwars.api.event.EventMessageHandler;
import com.slyvr.xbedwars.api.lang.Message;
import com.slyvr.xbedwars.api.team.GameTeam;


public class GameTeamEliminateEvent extends GameTeamEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final EventMessageHandler message_handler = new EventMessageHandler(Message.GAME_TEAM_ELIMINATION);


    public GameTeamEliminateEvent(@NotNull GameTeam team) {
        super(team);
    }


    @NotNull
    public EventMessageHandler getEliminationMessageHandler() {
        return message_handler;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}