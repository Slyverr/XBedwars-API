package com.slyvr.bedwars.api.entity;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.utils.ItemManager;
import com.slyvr.bedwars.utils.Version;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class GameEntityType<T extends GameEntity> {

    private static final Map<String, GameEntityType> BY_NAME = new HashMap<>();

    private static final Material SNOWBALL;
    private static final Material SPAWN_EGG;

    static {
        SNOWBALL = !Version.getVersion().isNewAPI() ? Material.matchMaterial("SNOW_BALL") : Material.SNOWBALL;
        SPAWN_EGG = !Version.getVersion().isNewAPI() ? Material.matchMaterial("MONSTER_EGG") : Material.GHAST_SPAWN_EGG;
    }

    private final String name;
    private final SpawnType type;
    private final ItemStack item;

    public GameEntityType(@NotNull String name, @NotNull SpawnType type) {
        Preconditions.checkNotNull(name, "GameEntity's name cannot be null!");
        Preconditions.checkNotNull(type, "GameEntity's spawn-type cannot be null!");

        this.name = name;
        this.type = type;

        this.item = getEntityItem();
    }

    @NotNull
    private ItemStack getEntityItem() {
        ItemManager manager = new ItemManager(type == SpawnType.SPAWN_EGG ? SPAWN_EGG : SNOWBALL);
        manager.setDisplayName(ChatColor.RED + name);

        return manager.getItemStack();
    }

    @NotNull
    public final String getName() {
        return name;
    }

    @NotNull
    public final SpawnType getSpawnType() {
        return type;
    }

    @NotNull
    public final ItemStack getSpawnItem() {
        return item.clone();
    }

    @NotNull
    public abstract T create(@NotNull GamePlayer owner, @NotNull Location loc);

    @Nullable
    public abstract T getEntity(@NotNull Entity entity);

    @Override
    public final int hashCode() {
        return Objects.hash(name.toLowerCase(), type);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof GameEntityType))
            return false;

        GameEntityType<?> other = (GameEntityType<?>) obj;
        return name.equalsIgnoreCase(other.name) && type == type;
    }

    @Override
    public final String toString() {
        return "GameEntityType{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    @NotNull
    public static <T extends GameEntity> T create(@NotNull GameEntityType<T> type, @NotNull GamePlayer owner, @NotNull Location loc) {
        Preconditions.checkNotNull(type, "GameEntity's type cannot be null!");
        Preconditions.checkNotNull(owner, "GameEntity's owner cannot be null!");
        Preconditions.checkNotNull(loc, "GameEntity's spawn-point cannot be null!");

        return type.create(owner, loc);
    }

    @Nullable
    public static GameEntity getGameEntity(@NotNull Entity entity) {
        if (entity == null)
            return null;

        for (GameEntityType<?> type : BY_NAME.values()) {
            GameEntity game_entity = type.getEntity(entity);
            if (game_entity != null)
                return game_entity;
        }

        return null;
    }

    @Nullable
    public static GameEntityType<?> getByName(@NotNull String name) {
        return name != null ? BY_NAME.get(name.toLowerCase()) : null;
    }

    @Nullable
    public static GameEntityType<?> getByItem(@NotNull ItemStack item) {
        if (item == null)
            return null;

        for (GameEntityType<?> type : BY_NAME.values()) {
            if (type.item.isSimilar(item))
                return type;
        }

        return null;
    }

    public static void register(@NotNull GameEntityType<?> type) {
        Preconditions.checkNotNull(type, "Cannot register a null game-entity's type!");

        if (BY_NAME.putIfAbsent(type.name.toLowerCase(), type) != null)
            throw new IllegalArgumentException("Another game-entity's type is already registered with the same name!");
    }

    public static boolean canRegister(@NotNull GameEntityType<?> type) {
        return type != null && !BY_NAME.containsKey(type.name.toLowerCase());
    }

    @NotNull
    public static GameEntityType<?>[] values() {
        return BY_NAME.values().toArray(new GameEntityType<?>[BY_NAME.size()]);
    }

    public enum SpawnType {

        PROJECTILE,
        SPAWN_EGG

    }

}