package com.slyvr.bedwars.api.player;

import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.NotNull;


public interface GamePlayerStatisticManager {


    @NotNull
    Map<GamePlayerStatistic, Integer> getStats();


    int getStatistic(@NotNull GamePlayerStatistic stat);


    void incrementStatistic(@NotNull GamePlayerStatistic stat, int amount);


    void decrementStatistic(@NotNull GamePlayerStatistic stat, int amount);


    void setStatistic(@NotNull GamePlayerStatistic stat, int value);


    enum GamePlayerStatistic {


        KILLS("Kills"),


        DEATHS("Deaths"),


        FINAL_KILLS("Final Kills"),


        FINAL_DEATHS("Final Deaths"),


        BEDS_BROKEN("Beds Broken"),


        BEDS_LOST("Beds Lost");

        private static final Map<String, GamePlayerStatistic> BY_NAME = new HashMap<>();

        static {
            for (GamePlayerStatistic stat : GamePlayerStatistic.values()) {
                GamePlayerStatistic.BY_NAME.put(stat.name().toLowerCase(), stat);
                GamePlayerStatistic.BY_NAME.put(stat.name.toLowerCase(), stat);
            }

        }

        private final String name;

        GamePlayerStatistic(@NotNull String name) {
            this.name = name;
        }


        @NotNull
        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }


        @NotNull
        public static GamePlayerStatistic getByName(@NotNull String name) {
            return name != null ? GamePlayerStatistic.BY_NAME.get(name.toLowerCase()) : null;
        }

    }

}