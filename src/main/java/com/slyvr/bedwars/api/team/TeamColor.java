package com.slyvr.bedwars.api.team;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.slyvr.bedwars.api.lang.Language;


public enum TeamColor {


    RED("Red", ChatColor.RED, DyeColor.RED),


    BLUE("Blue", ChatColor.BLUE, DyeColor.BLUE),


    GREEN("Green", ChatColor.GREEN, DyeColor.LIME),


    YELLOW("Yellow", ChatColor.YELLOW, DyeColor.YELLOW),


    AQUA("Aqua", ChatColor.AQUA, DyeColor.CYAN),


    WHITE("White", ChatColor.WHITE, DyeColor.WHITE),


    PINK("Pink", ChatColor.LIGHT_PURPLE, DyeColor.PINK),


    GRAY("Gray", ChatColor.DARK_GRAY, DyeColor.GRAY);

    private static final Map<ChatColor, TeamColor> BY_COLOR = new HashMap<>(8);
    private static final Map<DyeColor, TeamColor> BY_DYE = new HashMap<>(8);
    private static final Map<String, TeamColor> BY_NAME = new HashMap<>(8);

    static {
        for (TeamColor teamColor : values()) {
            TeamColor.BY_COLOR.put(teamColor.color, teamColor);
            TeamColor.BY_DYE.put(teamColor.dye, teamColor);

            TeamColor.BY_NAME.put(teamColor.name.toLowerCase(), teamColor);
        }

    }

    private final ChatColor color;
    private final DyeColor dye;
    private final String name;

    TeamColor(@NotNull String name, @NotNull ChatColor color, @NotNull DyeColor dye) {
        this.color = color;
        this.dye = dye;

        this.name = name;
    }


    @NotNull
    public String getName() {
        return name;
    }


    @NotNull
    public String getName(@NotNull Language lang) {
        if (lang == null)
            return name;

        String custom = lang.getCustomMessagePattern("bedwars.team_color." + name);
        return custom != null ? custom : name;
    }


    @NotNull
    public String getColoredName() {
        return getColoredName(Language.ENGLISH);
    }


    @NotNull
    public String getColoredName(@NotNull Language lang) {
        return color + getName(lang);
    }


    @NotNull
    public String getPrefix() {
        return getPrefix(Language.ENGLISH);
    }


    @NotNull
    public String getPrefix(@NotNull Language lang) {
        return String.valueOf(color) + '[' + getName(lang).toUpperCase() + ']';
    }


    public char getRepresentingChar() {
        return this != GRAY ? name.charAt(0) : 'S';
    }


    public char getRepresentingChar(@NotNull Language lang) {
        return lang != null && lang != Language.ENGLISH ? getName(lang).charAt(0) : getRepresentingChar();
    }


    @NotNull
    public String getColoredRepresentingChar() {
        return color.toString() + getRepresentingChar();
    }


    @NotNull
    public String getColoredRepresentingChar(@NotNull Language lang) {
        return color.toString() + getRepresentingChar(lang);
    }


    @NotNull
    public ChatColor getChatColor() {
        return color;
    }


    @NotNull
    public DyeColor getDyeColor() {
        return dye;
    }


    @Nullable
    public static TeamColor getByChatColor(@NotNull ChatColor color) {
        return BY_COLOR.get(color);
    }


    @Nullable
    public static TeamColor getByDyeColor(@NotNull DyeColor color) {
        return BY_DYE.get(color);
    }


    @Nullable
    public static TeamColor getByName(@NotNull String name) {
        return name != null ? TeamColor.BY_NAME.get(name.toLowerCase()) : null;
    }

}