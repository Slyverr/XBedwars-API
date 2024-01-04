package com.slyvr.bedwars.api.user.stats;

import com.slyvr.bedwars.api.player.GamePlayerStatisticManager;
import com.slyvr.bedwars.api.player.GamePlayerStatisticManager.GamePlayerStatistic;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.Map;


public final class UserStatistics implements Cloneable {

    private final Map<UserStatistic, Integer> stats = new EnumMap<>(UserStatistic.class);


    public UserStatistics() {
    }


    @NotNull
    public Map<UserStatistic, Integer> getStats() {
        return new EnumMap<>(stats);
    }


    public int getStatistic(@NotNull UserStatistic stat) {
        return stats.getOrDefault(stat, 0);
    }


    public float getKillDeathRatio() {
        return getRatio(stats.get(UserStatistic.KILLS), stats.get(UserStatistic.DEATHS));
    }


    public float getFinalKillDeathRatio() {
        return getRatio(stats.get(UserStatistic.FINAL_KILLS), stats.get(UserStatistic.FINAL_DEATHS));
    }

    private float getRatio(@NotNull Integer first, @NotNull Integer second) {
        return first != null && second != null && second != 0 ? (float) first / second : 0.0F;
    }


    public void setStatistic(@NotNull UserStatistic stat, int value) {
        if (stat != null && value >= 0)
            this.stats.put(stat, value);
    }


    public void incrementStatistic(@NotNull UserStatistic stat, int value) {
        if (stat == null || value <= 0)
            return;

        Integer old = stats.get(stat);
        this.stats.put(stat, old != null ? old + value : value);
    }


    public void decrementStatistic(@NotNull UserStatistic stat, int value) {
        if (stat == null || value <= 0)
            return;

        Integer old = stats.get(stat);
        if (old != null)
            this.stats.put(stat, Math.max(old - value, 0));
    }

    public void incrementStatistics(@NotNull GamePlayerStatisticManager stats) {
        if (stats == null)
            return;

        this.incrementStatistic(UserStatistic.KILLS, stats.getStatistic(GamePlayerStatistic.KILLS));
        this.incrementStatistic(UserStatistic.DEATHS, stats.getStatistic(GamePlayerStatistic.DEATHS));
        this.incrementStatistic(UserStatistic.FINAL_KILLS, stats.getStatistic(GamePlayerStatistic.FINAL_KILLS));
        this.incrementStatistic(UserStatistic.FINAL_DEATHS, stats.getStatistic(GamePlayerStatistic.FINAL_DEATHS));
        this.incrementStatistic(UserStatistic.BEDS_BROKEN, stats.getStatistic(GamePlayerStatistic.BEDS_BROKEN));
        this.incrementStatistic(UserStatistic.BEDS_LOST, stats.getStatistic(GamePlayerStatistic.BEDS_LOST));
    }

    public void decrementStatistics(@NotNull GamePlayerStatisticManager stats) {
        if (stats == null)
            return;

        this.decrementStatistic(UserStatistic.KILLS, stats.getStatistic(GamePlayerStatisticManager.GamePlayerStatistic.KILLS));
        this.decrementStatistic(UserStatistic.DEATHS, stats.getStatistic(GamePlayerStatisticManager.GamePlayerStatistic.DEATHS));
        this.decrementStatistic(UserStatistic.FINAL_KILLS, stats.getStatistic(GamePlayerStatisticManager.GamePlayerStatistic.FINAL_KILLS));
        this.decrementStatistic(UserStatistic.FINAL_DEATHS, stats.getStatistic(GamePlayerStatisticManager.GamePlayerStatistic.FINAL_DEATHS));
        this.decrementStatistic(UserStatistic.BEDS_BROKEN, stats.getStatistic(GamePlayerStatisticManager.GamePlayerStatistic.BEDS_BROKEN));
        this.decrementStatistic(UserStatistic.BEDS_LOST, stats.getStatistic(GamePlayerStatistic.BEDS_LOST));
    }

    @Override
    public UserStatistics clone() {
        try {
            return (UserStatistics) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

}