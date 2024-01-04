package com.slyvr.bedwars.api.generator.team;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.generator.Resource;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public final class TeamResourceGeneratorDrop implements Cloneable {

    private final Resource resource;

    private boolean split;
    private int limit;
    private int dpm;

    public TeamResourceGeneratorDrop(@NotNull Resource resource, int dropsPerMin, int dropsLimit, boolean split) {
        Preconditions.checkNotNull(resource, "Drop's resource cannot be null!");
        Preconditions.checkArgument(dropsPerMin > 0, "The number of drops per minute must be at least 1!");
        Preconditions.checkArgument(dropsLimit > 0, "The limit of drops must be at least 1!");

        this.resource = resource;
        this.limit = dropsLimit;
        this.split = split;

        this.dpm = dropsPerMin;
    }

    public TeamResourceGeneratorDrop(@NotNull Resource resource, int dropsPerMin, int dropsLimit) {
        this(resource, dropsPerMin, dropsLimit, false);
    }

    @NotNull
    public Resource getResource() {
        return resource;
    }


    public int getDropsPerMinute() {
        return dpm;
    }


    public void setDropsPerMinute(int drops) {
        if (drops > 0)
            this.dpm = drops;
    }


    public int getDropLimit() {
        return limit;
    }


    public void setDropLimit(int limit) {
        if (limit > 0)
            this.limit = limit;
    }

    public boolean canSplit() {
        return split;
    }

    public void setSplit(boolean split) {
        this.split = split;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        TeamResourceGeneratorDrop other = (TeamResourceGeneratorDrop) obj;
        return limit == other.limit && dpm == other.dpm && resource.equals(other.resource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resource, limit, dpm);
    }

    @Override
    public TeamResourceGeneratorDrop clone() {
        try {
            return (TeamResourceGeneratorDrop) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

}