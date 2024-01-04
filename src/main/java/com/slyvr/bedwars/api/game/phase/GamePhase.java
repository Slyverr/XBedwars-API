package com.slyvr.bedwars.api.game.phase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.game.Game;
import com.slyvr.bedwars.api.lang.Language;


public abstract class GamePhase {


    public static final GamePhase GAME_END = new GamePhase("Game End", 10 * 60) {

        @Override
        public boolean apply(@NotNull Game game) {
            return game.stop();
        }

    };

    private static final Map<String, GamePhase> BY_NAME = new HashMap<>();

    static {
        GamePhase.register(GAME_END);
    }

    private final String name;
    private final int time;


    public GamePhase(@NotNull String name, int wait) {
        Preconditions.checkNotNull(name, "Phase's name cannot be null!");
        Preconditions.checkArgument(wait > 0, "Phase's waiting time must be at least 1!");

        this.name = name;
        this.time = wait;
    }


    @NotNull
    public String getName() {
        return name;
    }


    @NotNull
    public String getName(@NotNull Language lang) {
        if (lang == null)
            return name;

        String custom = lang.getCustomMessagePattern("bedwars.game.phase." + name.replace(' ', '_'));
        return custom != null ? custom : name;
    }


    public int getTimeToWait() {
        return time;
    }


    public abstract boolean apply(@NotNull Game game);

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof GamePhase))
            return false;

        GamePhase other = (GamePhase) obj;
        return time == other.time && name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), time);
    }

    @Override
    public String toString() {
        return "GamePhase{Name='" + name + "', WaitingTime=" + time + '}';
    }


    @Nullable
    public static GamePhase getByName(@NotNull String name) {
        return name != null ? GamePhase.BY_NAME.get(name.toLowerCase()) : null;
    }


    public static void register(@NotNull GamePhase phase) {
        Preconditions.checkNotNull(phase, "Cannot register null phase!");

        if (BY_NAME.putIfAbsent(phase.name.toLowerCase(), phase) != null)
            throw new IllegalArgumentException("Another game-phase with the same name is already registered!");
    }


    public static boolean canRegister(@NotNull GamePhase phase) {
        return phase != null && !BY_NAME.containsKey(phase.name.toLowerCase());
    }


    @NotNull
    public static GamePhase[] values() {
        return GamePhase.BY_NAME.values().toArray(new GamePhase[GamePhase.BY_NAME.size()]);
    }

}