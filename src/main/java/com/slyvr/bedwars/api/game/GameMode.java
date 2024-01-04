package com.slyvr.bedwars.api.game;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.lang.Language;


public final class GameMode {


    public static final GameMode SOLO = new GameMode("Solo", "bedwars_eight_one", 1, 8);


    public static final GameMode DUO = new GameMode("Doubles", "bedwars_eight_two", 2, 8);


    public static final GameMode TRIO = new GameMode("Trio", "bedwars_four_three", 3, 4);


    public static final GameMode QUAD = new GameMode("Quad", "bedwars_four_four", 4, 4);

    private static final Map<String, GameMode> BY_NAME = new LinkedHashMap<>();
    private static final Map<String, GameMode> BY_COMPOSITION = new HashMap<>();
    private static final Map<String, GameMode> BY_COMMAND = new HashMap<>();

    static {
        GameMode.register(GameMode.SOLO);
        GameMode.register(GameMode.DUO);
        GameMode.register(GameMode.TRIO);
        GameMode.register(GameMode.QUAD);
    }

    private final String name;
    private final String command;
    private final String composition;
    private final int team_max;
    private final int teams_count;


    public GameMode(@NotNull String name, @NotNull String command, @Range(from = 1, to = Integer.MAX_VALUE) int teamMax, @Range(from = 2, to = 8) int teamsCount) {
        Preconditions.checkNotNull(name, "GameMode's name cannot be null!");
        Preconditions.checkNotNull(command, "GameMode's play command cannot be null!");

        Preconditions.checkArgument(teamMax > 0, "GameMode's minimum number of players in a team must be at least 1!");
        Preconditions.checkArgument(teamsCount <= 8 && teamsCount >= 2, "GameMode's number of teams must be between 2 and 8!");

        this.name = name;
        this.command = command;

        this.teams_count = teamsCount;
        this.team_max = teamMax;
        this.composition = String.join("v", Collections.nCopies(teamsCount, String.valueOf(teamMax)));
    }


    @NotNull
    public String getName() {
        return name;
    }


    @NotNull
    public String getName(@NotNull Language lang) {
        if (lang == null)
            return name;

        String custom = lang.getCustomMessagePattern("bedwars.game.mode." + name.replace(' ', '_'));
        return custom != null ? custom : name;
    }


    @NotNull
    public String getPlayCommand() {
        return command;
    }


    @NotNull
    public String getTeamsComposition() {
        return composition;
    }


    public int getTeamMax() {
        return team_max;
    }


    public int getMaxTeams() {
        return teams_count;
    }


    public int getMaxPlayers() {
        return team_max * teams_count;
    }


    public int getMinPlayers() {
        return team_max + 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        GameMode other = (GameMode) obj;
        return team_max == other.team_max && teams_count == other.teams_count && name.equalsIgnoreCase(other.name) && command.equalsIgnoreCase(other.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), command.toLowerCase(), team_max, teams_count);
    }

    @Override
    public String toString() {
        return "GameMode{Name='" + name + "', Team Max=" + team_max + ", Teams Count=" + teams_count + ",Players Max=" + getMaxPlayers() + '}';
    }


    @Nullable
    public static GameMode getByName(@NotNull String name) {
        return name != null ? BY_NAME.get(name.toLowerCase()) : null;
    }


    @Nullable
    public static GameMode getByPlayCommand(@NotNull String command) {
        return command != null ? BY_COMMAND.get(command.toLowerCase()) : null;
    }


    @Nullable
    public static GameMode getByTeamsComposition(@NotNull String composition) {
        return composition != null ? BY_COMPOSITION.get(composition.toLowerCase()) : null;
    }


    @Nullable
    public static GameMode getByString(@NotNull String string) {
        if (string == null)
            return null;

        String lower_case = string.toLowerCase();

        GameMode mode = BY_NAME.get(lower_case);
        if (mode == null)
            mode = BY_COMMAND.get(lower_case);

        if (mode == null)
            mode = BY_COMPOSITION.get(lower_case);

        return mode;
    }


    public static void register(@NotNull GameMode mode) {
        Preconditions.checkNotNull(mode, "Cannot register a null mode!");

        String name = mode.name.toLowerCase();
        if (BY_NAME.containsKey(name))
            throw new IllegalArgumentException("Another mode with the same name is already registered!");

        String command = mode.command.toLowerCase();
        if (BY_COMMAND.containsKey(command))
            throw new IllegalArgumentException("Another mode with the same play command is already registered!");

        String composition = mode.composition.toLowerCase();
        if (BY_COMPOSITION.containsKey(command))
            throw new IllegalArgumentException("Another mode with the same teams composition is already registered!");

        GameMode.BY_NAME.put(name, mode);
        GameMode.BY_COMMAND.put(command, mode);
        GameMode.BY_COMPOSITION.put(composition, mode);
    }


    public static boolean canRegister(@NotNull GameMode mode) {
        if (mode == null)
            return false;

        if (BY_NAME.containsKey(mode.name.toLowerCase()))
            return false;

        if (BY_COMMAND.containsKey(mode.command.toLowerCase()))
            return false;

        return !BY_COMMAND.containsKey(mode.composition.toLowerCase());
    }


    @NotNull
    public static GameMode[] values() {
        return GameMode.BY_NAME.values().toArray(new GameMode[GameMode.BY_NAME.size()]);
    }

}