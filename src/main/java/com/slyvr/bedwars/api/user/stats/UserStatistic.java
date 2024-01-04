package com.slyvr.bedwars.api.user.stats;

import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.slyvr.bedwars.api.lang.Language;


public enum UserStatistic {


    GAMES_PLAYED("Games Played"),


    BEDS_BROKEN("Beds Broken"),


    BEDS_LOST("Beds Lost"),


    KILLS("Kills"),


    DEATHS("Deaths"),


    FINAL_KILLS("Final Kills"),


    FINAL_DEATHS("Final Deaths"),


    WINS("Wins"),


    LOSSES("Losses"),


    WINSTREAK("Winstreak");

    private static final Map<String, UserStatistic> BY_NAME = new HashMap<>(20, 1F);

    static {
        for (UserStatistic stat : values()) {
            BY_NAME.put(stat.name().toLowerCase(), stat);
            BY_NAME.put(stat.name.toLowerCase(), stat);
        }

    }

    private final String name;
    private final String name_key;

    UserStatistic(@NotNull String name) {
        this.name = name;
        this.name_key = name.replace(' ', '_');
    }


    @NotNull
    public String getName() {
        return name;
    }


    @NotNull
    public String getName(@NotNull Language lang) {
        if (lang == null)
            return name;

        String custom = lang.getCustomMessagePattern("bedwars.user.statistic." + name_key);
        return custom != null ? custom : name;
    }

    @Override
    public String toString() {
        return name;
    }


    @Nullable
    public static UserStatistic getByName(@NotNull String name) {
        return name != null ? BY_NAME.get(name.toLowerCase()) : null;
    }

}