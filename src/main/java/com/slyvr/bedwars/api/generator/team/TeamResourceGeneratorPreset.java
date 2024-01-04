package com.slyvr.bedwars.api.generator.team;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.generator.Resource;


public final class TeamResourceGeneratorPreset {

    private static final Map<String, TeamResourceGeneratorPreset> BY_NAME = new LinkedHashMap<>();

    private final Map<Resource, TeamResourceGeneratorDrop> team_drops;
    private final String name;


    public TeamResourceGeneratorPreset(@NotNull String name, @NotNull Set<TeamResourceGeneratorDrop> drops) {
        Preconditions.checkNotNull(name, "Preset's name cannot be null!");
        Preconditions.checkNotNull(drops, "Preset's drops set cannot be null!");
        Preconditions.checkArgument(!drops.isEmpty(), "Preset's drops set cannot be empty!");

        this.name = name;
        this.team_drops = new HashMap<>(drops.size());

        for (TeamResourceGeneratorDrop drop : drops) {
            if (drop == null)
                throw new IllegalArgumentException("Preset's drop cannot be null!");

            this.team_drops.put(drop.getResource(), drop.clone());
        }

    }


    @NotNull
    public String getName() {
        return name;
    }


    @NotNull
    public Set<TeamResourceGeneratorDrop> getDrops() {
        Set<TeamResourceGeneratorDrop> result = new HashSet<>(team_drops.size());

        for (TeamResourceGeneratorDrop drop : team_drops.values())
            result.add(drop.clone());

        return result;
    }


    @Nullable
    public TeamResourceGeneratorDrop getDrop(@NotNull Resource resource) {
        TeamResourceGeneratorDrop result = team_drops.get(resource);
        return result != null ? result.clone() : null;
    }


    public int size() {
        return team_drops.size();
    }


    public static void register(@NotNull TeamResourceGeneratorPreset preset) {
        Preconditions.checkNotNull(preset, "Cannot register null generator-preset!");

        if (BY_NAME.putIfAbsent(preset.name.toLowerCase(), preset) != null)
            throw new IllegalArgumentException("Another generator-preset with the same name is already registered!");
    }


    public static boolean canRegister(@NotNull TeamResourceGeneratorPreset preset) {
        return preset != null && !BY_NAME.containsKey(preset.name.toLowerCase());
    }


    @Nullable
    public static TeamResourceGeneratorPreset getByName(@NotNull String name) {
        return name != null ? BY_NAME.get(name.toLowerCase()) : null;
    }


    @NotNull
    public static TeamResourceGeneratorPreset[] values() {
        return BY_NAME.values().toArray(new TeamResourceGeneratorPreset[BY_NAME.size()]);
    }

}
