package com.slyvr.bedwars.api.game.phase;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public final class GamePhasePreset {

    private static final Map<String, GamePhasePreset> BY_NAME = new LinkedHashMap<>();

    private final List<GamePhase> phases;
    private final String name;


    public GamePhasePreset(@NotNull String name, @NotNull List<GamePhase> phases) {
        Preconditions.checkNotNull(name, "Preset's name cannot be null!");
        Preconditions.checkNotNull(phases, "Preset's phases list cannot be null!");
        Preconditions.checkArgument(!phases.isEmpty(), "Preset's phases list cannot be empty!");

        this.name = name;
        this.phases = new ArrayList<>(phases.size());

        for (GamePhase phase : phases) {
            if (phase == null)
                throw new IllegalArgumentException("Preset's phase cannot be null!");

            if (phase != GamePhase.GAME_END)
                this.phases.add(phase);
        }

        this.phases.add(GamePhase.GAME_END);
    }


    @NotNull
    public List<GamePhase> getPhases() {
        return new ArrayList<>(phases);
    }


    @Nullable
    public GamePhase getPhase(int index) {
        return index >= 0 && index < phases.size() ? phases.get(index) : null;
    }


    public int getPhasesLength() {
        int result = 0;

        for (GamePhase phase : phases)
            result += phase.getTimeToWait();

        return result;
    }


    public int size() {
        return phases.size();
    }


    @NotNull
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        GamePhasePreset other = (GamePhasePreset) obj;
        return name.equalsIgnoreCase(other.name) && phases.equals(other.phases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), phases);
    }


    @Nullable
    public static GamePhasePreset getByName(@NotNull String name) {
        return name != null ? BY_NAME.get(name.toLowerCase()) : null;
    }


    public static void register(@NotNull GamePhasePreset preset) {
        Preconditions.checkNotNull(preset, "Cannot register a null preset!");

        if (BY_NAME.putIfAbsent(preset.name.toLowerCase(), preset) != null)
            throw new IllegalArgumentException("Another preset with the same name is already registered!");
    }


    public static boolean canRegister(@NotNull GamePhasePreset preset) {
        return preset != null && !BY_NAME.containsKey(preset.name.toLowerCase());
    }


    @NotNull
    public static GamePhasePreset[] values() {
        return BY_NAME.values().toArray(new GamePhasePreset[BY_NAME.size()]);
    }

}