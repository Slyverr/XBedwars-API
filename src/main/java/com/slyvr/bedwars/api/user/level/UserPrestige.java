package com.slyvr.bedwars.api.user.level;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.utils.ChatUtils;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public final class UserPrestige {

    public static final UserPrestige DEFAULT = new UserPrestige("Stone Prestige", ChatColor.GRAY + "Stone Prestige", ChatColor.GRAY + "[*✫]", ChatColor.GRAY + "*✫", 1, Integer.MAX_VALUE);

    private static final Map<Integer, UserPrestige> BY_START_LEVEL = new HashMap<>();
    private static final Map<Integer, UserPrestige> BY_END_LEVEL = new HashMap<>();
    private static final Map<String, UserPrestige> BY_NAME = new LinkedHashMap<>();

    private final String name;
    private final String display;
    private final String scoreboard;
    private final String chat;

    private final int start;
    private final int end;


    public UserPrestige(@NotNull String name, @NotNull String display, @NotNull String chat, @NotNull String board, int start, int end) {
        Preconditions.checkNotNull(name, "Prestige's name cannot be null!");
        Preconditions.checkNotNull(display, "Prestige's display name cannot be null!");

        Preconditions.checkNotNull(chat, "Prestige's chat format cannot be null!");
        Preconditions.checkNotNull(board, "Prestige's scoreboard format cannot be null!");

        Preconditions.checkArgument(start > 0 && end > 0, "Prestige's start level and end level must be positive!");
        Preconditions.checkArgument(end >= start, "Prestige's end level must be greater than or equals the start level!");

        this.name = name;
        this.display = ChatUtils.format(display);

        this.chat = ChatUtils.format(chat);
        this.scoreboard = ChatUtils.format(board);

        this.start = start;
        this.end = end;
    }


    @NotNull
    public String getName() {
        return name;
    }


    @NotNull
    public String getDisplayName() {
        return display;
    }


    @NotNull
    public String getChatFormat() {
        return chat;
    }


    @NotNull
    public String getScoreboardFormat() {
        return scoreboard;
    }


    public int getStartLevel() {
        return start;
    }


    public int getEndLevel() {
        return end;
    }


    @Nullable
    public String formatToChat(@NotNull UserLevel level) {
        return format(chat, level);
    }


    @Nullable
    public String formatToScoreboard(@NotNull UserLevel level) {
        return format(scoreboard, level);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        UserPrestige other = (UserPrestige) obj;
        if (start != other.start)
            return false;

        if (end != other.end)
            return false;

        if (!name.equalsIgnoreCase(other.name))
            return false;

        if (!display.equalsIgnoreCase(other.display))
            return false;

        return chat.equalsIgnoreCase(other.chat) && scoreboard.equalsIgnoreCase(other.scoreboard);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + display.hashCode();
        result = 31 * result + scoreboard.hashCode();
        result = 31 * result + chat.hashCode();
        result = 31 * result + start;
        result = 31 * result + end;

        return result;
    }

    @Override
    public String toString() {
        return "UserPrestige{Name='" + name + "', Start=" + start + ", End=" + end + '}';
    }


    @Nullable
    public static String format(@NotNull String format, @NotNull UserLevel level) {
        return level != null ? format(format, Integer.toString(level.getLevel())) : null;
    }


    @NotNull
    private static String format(@NotNull String format, @NotNull String level) {
        StringBuilder builder = new StringBuilder(format.length() + level.length());

        int level_target_index = 0;
        int last_star_index = -1;

        for (int i = 0; i < format.length(); i++) {
            char character = format.charAt(i);
            if (character != '*') {
                builder.append(character);
                continue;
            }

            if (level_target_index == level.length())
                continue;

            builder.append(level.charAt(level_target_index++));
            last_star_index = i;
        }

        if (last_star_index != -1 && level_target_index != level.length())
            builder.insert(last_star_index + 1, level.substring(level_target_index));

        return builder.toString();
    }


    @Nullable
    public static UserPrestige getByName(@NotNull String name, @Nullable UserPrestige def) {
        return name != null ? BY_NAME.getOrDefault(name.toLowerCase(), def) : def;
    }


    @Nullable
    public static UserPrestige getByName(@NotNull String name) {
        return getByName(name, null);
    }


    @Nullable
    public static UserPrestige getByStartLevel(int level, @Nullable UserPrestige def) {
        return BY_START_LEVEL.getOrDefault(level, def);
    }


    @Nullable
    public static UserPrestige getByStartLevel(int level) {
        return BY_START_LEVEL.get(level);
    }


    @Nullable
    public static UserPrestige getByEndLevel(int level, @Nullable UserPrestige def) {
        return BY_END_LEVEL.getOrDefault(level, def);
    }


    @Nullable
    public static UserPrestige getByEndLevel(int level) {
        return BY_END_LEVEL.get(level);
    }


    @Nullable
    public static UserPrestige getByLevel(int level, @Nullable UserPrestige def) {
        for (UserPrestige prestige : BY_NAME.values()) {
            if (level >= prestige.start && level <= prestige.end)
                return prestige;
        }

        return def;
    }


    @Nullable
    public static UserPrestige getByLevel(int level) {
        return getByLevel(level, null);
    }


    public static void register(@NotNull UserPrestige prestige) {
        Preconditions.checkNotNull(prestige, "Cannot register null prestige!");

        String name = prestige.name.toLowerCase();
        if (BY_NAME.containsKey(name))
            throw new IllegalArgumentException("Another prestige with the same name is already registered!");

        if (BY_START_LEVEL.containsKey(prestige.start))
            throw new IllegalArgumentException("Another prestige with the same start level is already registered!");

        if (BY_END_LEVEL.containsKey(prestige.end))
            throw new IllegalArgumentException("Another prestige with the same end level is already registered!");

        UserPrestige.BY_NAME.put(name, prestige);
        UserPrestige.BY_START_LEVEL.put(prestige.start, prestige);
        UserPrestige.BY_END_LEVEL.put(prestige.end, prestige);
    }


    public static boolean canRegister(@NotNull UserPrestige prestige) {
        return prestige != null && !BY_START_LEVEL.containsKey(prestige.start) && !BY_END_LEVEL.containsKey(prestige.end) && !BY_NAME.containsKey(prestige.name.toLowerCase());
    }


    @NotNull
    public static UserPrestige[] values() {
        return BY_NAME.values().toArray(new UserPrestige[BY_NAME.size()]);
    }

}