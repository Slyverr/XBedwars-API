package com.slyvr.bedwars.api.event.game;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import com.slyvr.bedwars.api.game.Game;


public class GameEndEvent extends GameEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Map<Player, Integer> top_players;
    private final Set<Player> winners;
    private final Set<Player> losers;


    public GameEndEvent(@NotNull Game game, @NotNull Map<Player, Integer> players, @NotNull Set<Player> winners, @NotNull Set<Player> losers) {
        super(game);

        this.top_players = Collections.unmodifiableMap(players);

        this.winners = Collections.unmodifiableSet(winners);
        this.losers = Collections.unmodifiableSet(losers);
    }


    @NotNull
    public Map<Player, Integer> getTopPlayers() {
        return top_players;
    }


    @NotNull
    public Set<Player> getWinners() {
        return winners;
    }


    @NotNull
    public Set<Player> getLosers() {
        return losers;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return GameEndEvent.HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return GameEndEvent.HANDLERS;
    }

}