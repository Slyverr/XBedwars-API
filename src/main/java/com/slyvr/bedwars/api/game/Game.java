package com.slyvr.bedwars.api.game;

import com.slyvr.bedwars.api.arena.Arena;
import com.slyvr.bedwars.api.generator.Resource;
import com.slyvr.bedwars.api.generator.tiered.TieredResourceGenerator;
import com.slyvr.bedwars.api.lang.Language;
import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.api.room.WaitingRoom;
import com.slyvr.bedwars.api.team.GameTeam;
import com.slyvr.bedwars.api.team.TeamColor;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;


public interface Game {

    @NotNull
    Arena getArena();
    
    @NotNull
    UUID getUniqueId();

    boolean start();

    boolean stop();

    boolean stop(boolean force);

    @NotNull
    WaitingRoom getWaitingRoom();

    @NotNull
    GameManager getManager();

    @NotNull
    GameMode getMode();

    @NotNull
    GameState getState();

    void setState(@NotNull GameState state);

    @NotNull
    Collection<GameTeam> getGameTeams();

    @Nullable
    GameTeam getGameTeam(@NotNull TeamColor color);

    @NotNull
    Collection<GamePlayer> getGamePlayers();

    @NotNull
    Collection<GamePlayer> getTeamPlayers(@NotNull TeamColor color);

    @Nullable
    GamePlayer getGamePlayer(@NotNull Player player);

    @NotNull
    Collection<TieredResourceGenerator> getResourceGenerators(@NotNull Resource resource);


    boolean killPlayer(@NotNull Player player, @Nullable Entity killer, @Nullable DamageCause cause, int respawn);


    boolean killPlayer(@NotNull Player player, @Nullable Entity killer, @Nullable DamageCause cause);


    boolean killPlayer(@NotNull Player player, @Nullable Entity killer);


    boolean killPlayer(@NotNull Player player);

    boolean eliminatePlayer(@NotNull Player player);

    boolean isEliminated(@NotNull Player player);

    boolean eliminateTeam(@NotNull TeamColor color);

    boolean isEliminated(@NotNull TeamColor color);


    boolean reconnect(@NotNull Player player);


    boolean disconnect(@NotNull Player player);


    boolean isDisconnected(@NotNull Player player);


    @NotNull
    Collection<Player> getSpectators();


    boolean addSpectator(@NotNull Player player);


    boolean isSpectator(@NotNull Player player);


    boolean breakTeamBed(@NotNull TeamColor color, @Nullable Player destroyer);


    boolean breakTeamBed(@NotNull TeamColor color);


    boolean hasBed(@NotNull TeamColor color);


    void broadcastMessage(@NotNull String message, @Nullable Predicate<Player> predicate);


    void broadcastMessage(@NotNull String message);


    void forEach(@NotNull Consumer<GamePlayer> action);


    boolean contains(@NotNull Player player);


    boolean isPrivate();


    boolean isRunning();


    int size();

    enum GameState {

        WAITING("Waiting", ChatColor.AQUA),

        COUNTDOWN("Countdown", ChatColor.YELLOW),

        STARTING("Starting", ChatColor.GREEN),

        RUNNING("Running", ChatColor.BLUE),

        ENDING("Ending", ChatColor.RED),

        RESETTING("Resetting", ChatColor.DARK_PURPLE),

        ENDED("Ended", ChatColor.GRAY);

        private final String name;
        private final ChatColor color;

        GameState(@NotNull String name, @NotNull ChatColor color) {
            this.name = name;
            this.color = color;
        }


        @NotNull
        public String getName() {
            return name;
        }


        @NotNull
        public String getName(@NotNull Language lang) {
            if (lang == null)
                return name;

            String custom = lang.getCustomMessagePattern("bedwars.game.state." + name);
            return custom != null ? custom : name;
        }


        @NotNull
        public ChatColor getChatColor() {
            return color;
        }

        @Override
        public String toString() {
            return name;
        }

    }

}