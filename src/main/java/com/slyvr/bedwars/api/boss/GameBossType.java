package com.slyvr.bedwars.api.boss;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.team.GameTeam;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public abstract class GameBossType<T extends GameBoss> {

    private static final Map<String, GameBossType<?>> BY_NAME = new HashMap<>();

    private final String name;

    public GameBossType(@NotNull String name) {
        this.name = Preconditions.checkNotNull(name, "GameBoss's name cannot be null!");
    }

    @NotNull
    public final String getName() {
        return name;
    }

    @NotNull
    public abstract T create(@NotNull GameTeam team, @NotNull Location loc);

    @Nullable
    public abstract T getBoss(@NotNull Entity entity);

    @Override
    public final int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof GameBossType))
            return false;

        GameBossType<?> other = (GameBossType<?>) obj;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public final String toString() {
        return "GameBossType{" +
                "name='" + name + '\'' +
                '}';
    }

    @NotNull
    public static <T extends GameBoss> T create(@NotNull GameBossType<T> type, @NotNull GameTeam team, @NotNull Location loc) {
        Preconditions.checkNotNull(type, "GameBoss' type cannot be null!");
        Preconditions.checkNotNull(team, "GameBoss' team cannot be null!");
        Preconditions.checkNotNull(loc, "GameBoss' spawn-point cannot be null!");

        return type.create(team, loc);
    }

    @Nullable
    public static GameBoss getGameBoss(@NotNull Entity entity) {
        if (entity == null)
            return null;

        for (GameBossType<?> type : BY_NAME.values()) {
            GameBoss boss = type.getBoss(entity);
            if (boss != null)
                return boss;
        }

        return null;
    }

    @Nullable
    public static GameBossType<?> getByName(@NotNull String name) {
        return name != null ? BY_NAME.get(name.toLowerCase()) : null;
    }

    public static void register(@NotNull GameBossType<?> type) {
        Preconditions.checkNotNull(type, "Cannot register a null game-boss' type!");

        if (BY_NAME.putIfAbsent(type.name.toLowerCase(), type) != null)
            throw new IllegalArgumentException("Another game-boss's type is already registered with the same name!");
    }

    public static boolean canRegister(@NotNull GameBossType<?> type) {
        return type != null && !BY_NAME.containsKey(type.name.toLowerCase());
    }

    @NotNull
    public static GameBossType<?>[] values() {
        return BY_NAME.values().toArray(new GameBossType<?>[BY_NAME.size()]);
    }

}