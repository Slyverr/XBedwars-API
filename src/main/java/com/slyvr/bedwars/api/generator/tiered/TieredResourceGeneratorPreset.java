package com.slyvr.bedwars.api.generator.tiered;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public final class TieredResourceGeneratorPreset {

    private static final Map<String, TieredResourceGeneratorPreset> BY_NAME = new LinkedHashMap<>();

    private final ResourceGeneratorTier[] tiers;
    private final String name;


    public TieredResourceGeneratorPreset(@NotNull String name, @NotNull List<ResourceGeneratorTier> tiers) {
        Preconditions.checkNotNull(name, "Preset's name cannot be null!");
        Preconditions.checkNotNull(tiers, "Preset's tiers set cannot be null!");
        Preconditions.checkArgument(!tiers.isEmpty(), "Preset's tiers list cannot be empty!");

        this.name = name;
        this.tiers = new ResourceGeneratorTier[tiers.size()];

        int index = 0;
        for (ResourceGeneratorTier tier : tiers) {
            if (tier == null)
                throw new IllegalArgumentException("Preset's tier cannot be null!");

            this.tiers[index++] = tier;
        }

    }


    @NotNull
    public String getName() {
        return name;
    }


    @NotNull
    public List<ResourceGeneratorTier> getTiers() {
        List<ResourceGeneratorTier> result = new ArrayList<>(tiers.length);
        Collections.addAll(result, tiers);

        return result;
    }


    @Nullable
    public ResourceGeneratorTier getTier(int index) {
        return index >= 0 && index < tiers.length ? tiers[index] : null;
    }


    public int size() {
        return tiers.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        TieredResourceGeneratorPreset other = (TieredResourceGeneratorPreset) obj;
        return name.equalsIgnoreCase(other.name) && Arrays.equals(tiers, other.tiers);
    }

    @Override
    public int hashCode() {
        return (Objects.hash(name.toLowerCase()) * 31) + Arrays.hashCode(tiers);
    }

    @Override
    public String toString() {
        return "TieredResourceGeneratorPreset{Name='" + name + "', Tiers=" + Arrays.toString(tiers) + '}';
    }


    @Nullable
    public static TieredResourceGeneratorPreset getByName(@NotNull String name) {
        return name != null ? BY_NAME.get(name.toLowerCase()) : null;
    }


    public static void register(@NotNull TieredResourceGeneratorPreset preset) {
        Preconditions.checkNotNull(preset, "Cannot register null preset!");

        if (BY_NAME.putIfAbsent(preset.name.toLowerCase(), preset) != null)
            throw new IllegalArgumentException("Another preset with the same name is already registered!");
    }


    public static boolean canRegister(@NotNull TieredResourceGeneratorPreset preset) {
        return preset != null && !BY_NAME.containsKey(preset.name.toLowerCase());
    }


    @NotNull
    public static TieredResourceGeneratorPreset[] values() {
        return BY_NAME.values().toArray(new TieredResourceGeneratorPreset[BY_NAME.size()]);
    }

}
