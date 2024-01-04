package com.slyvr.bedwars.api.reward;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.lang.Language;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


public final class GameRewardType {


    public static final GameRewardType BEDWARS_EXPERIENCE = new GameRewardType("Bedwars Experience", ChatColor.AQUA);

    public static final GameRewardType BEDWARS_COINS = new GameRewardType("Bedwars Coins", ChatColor.GOLD);

    private static final Map<String, GameRewardType> BY_NAME = new LinkedHashMap<>();

    static {
        GameRewardType.register(BEDWARS_EXPERIENCE);
        GameRewardType.register(BEDWARS_COINS);
    }

    private final String name;
    private final ChatColor color;


    public GameRewardType(@NotNull String name, @NotNull ChatColor color) {
        Preconditions.checkNotNull(name, "Reward's name cannot be null!");
        Preconditions.checkNotNull(color, "Reward's color cannot be null!");

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

        String custom = lang.getCustomMessagePattern("bedwars.game.reward." + name.replace(' ', '_'));
        return custom != null ? custom : name;
    }


    @NotNull
    public ChatColor getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        GameRewardType other = (GameRewardType) obj;
        return color == other.color && name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), color);
    }

    @Override
    public String toString() {
        return "GameRewardType{Name='" + name + "', Color=" + color + '}';
    }


    @Nullable
    public static GameRewardType getByName(@NotNull String name) {
        return name != null ? BY_NAME.get(name.toLowerCase()) : null;
    }


    public static void register(@NotNull GameRewardType type) {
        Preconditions.checkNotNull(type, "Cannot register a null game-reward type!");

        if (BY_NAME.putIfAbsent(type.name.toLowerCase(), type) != null)
            throw new IllegalArgumentException("Another game-reward's type with the same name is already registered!");
    }


    public static boolean canRegister(@NotNull GameRewardType type) {
        return type != null && !BY_NAME.containsKey(type.name.toLowerCase());
    }


    @NotNull
    public static GameRewardType[] values() {
        return BY_NAME.values().toArray(new GameRewardType[BY_NAME.size()]);
    }

}