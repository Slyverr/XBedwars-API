package com.slyvr.bedwars.api.reward;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.lang.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


public final class GameRewardReason {


    public static final GameRewardReason BED_DESTROYED = new GameRewardReason("Bed Destroyed");


    public static final GameRewardReason TIME_PLAYED = new GameRewardReason("Time Played");


    public static final GameRewardReason FINAL_KILL = new GameRewardReason("Final Kill");


    public static final GameRewardReason KILL = new GameRewardReason("Kill");


    public static final GameRewardReason WIN = new GameRewardReason("Win");

    private static final Map<String, GameRewardReason> BY_REASON = new LinkedHashMap<>();

    static {
        GameRewardReason.register(BED_DESTROYED);
        GameRewardReason.register(TIME_PLAYED);

        GameRewardReason.register(FINAL_KILL);
        GameRewardReason.register(KILL);
        GameRewardReason.register(WIN);
    }

    private final String reason;


    public GameRewardReason(@NotNull String reason) {
        Preconditions.checkNotNull(reason, "Reason cannot be null!");

        this.reason = reason;
    }


    @NotNull
    public String getReason() {
        return reason;
    }


    @NotNull
    public String getReason(@NotNull Language lang) {
        if (lang == null)
            return reason;

        String custom = lang.getCustomMessagePattern("bedwars.game.reward_reason." + reason.replace(' ', '_'));
        return custom != null ? custom : reason;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        GameRewardReason other = (GameRewardReason) obj;
        return reason.equalsIgnoreCase(other.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reason.toLowerCase());
    }


    @Nullable
    public static GameRewardReason getByReason(@NotNull String reason) {
        return reason != null ? BY_REASON.get(reason.toLowerCase()) : null;
    }


    public static void register(@NotNull GameRewardReason reason) {
        Preconditions.checkNotNull(reason, "Cannot register null reason!");

        if (BY_REASON.putIfAbsent(reason.reason.toLowerCase(), reason) != null)
            throw new IllegalArgumentException("Another reward-reason with the same reason is already registered!");
    }


    public static boolean canRegister(@NotNull GameRewardReason reason) {
        return reason != null && !BY_REASON.containsKey(reason.reason.toLowerCase());
    }


    @NotNull
    public static GameRewardReason[] values() {
        return BY_REASON.values().toArray(new GameRewardReason[BY_REASON.size()]);
    }

}