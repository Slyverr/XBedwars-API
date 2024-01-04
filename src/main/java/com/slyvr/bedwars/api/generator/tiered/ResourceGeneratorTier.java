package com.slyvr.bedwars.api.generator.tiered;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.lang.NamesRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class ResourceGeneratorTier {

    private final NamesRegistry names;

    private final int time;
    private final int limit;

    public ResourceGeneratorTier(@NotNull NamesRegistry names, int time, int limit) {
        Preconditions.checkNotNull(names, "Tier's names registry cannot be null!");
        Preconditions.checkArgument(time > 0, "The time between each drop must be at least 1!");
        Preconditions.checkArgument(limit > 0, "The limit of drops must be at least 1!");

        this.names = names;

        this.time = time;
        this.limit = limit;
    }

    @NotNull
    public NamesRegistry getNames() {
        return names;
    }

    public int getDropTime() {
        return time;
    }

    public int getDropLimit() {
        return limit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        ResourceGeneratorTier other = (ResourceGeneratorTier) obj;
        return time == other.time && limit == other.limit && names.equals(other.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names, time, limit);
    }

}