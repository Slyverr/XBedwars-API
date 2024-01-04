package com.slyvr.bedwars.api.user.wallet;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.lang.Language;
import com.slyvr.bedwars.api.reward.GameRewardType;


public final class UserCurrency {

    public static final UserCurrency BEDWARS_COINS = new UserCurrency(GameRewardType.BEDWARS_COINS);

    private static final Map<String, UserCurrency> BY_NAME = new LinkedHashMap<>();
    private static final Map<GameRewardType, UserCurrency> BY_REWARD = new HashMap<>();

    static {
        UserCurrency.register(BEDWARS_COINS);
    }

    private final String name;
    private final String name_key;
    private final GameRewardType type;


    public UserCurrency(@NotNull String name, @NotNull GameRewardType type) {
        Preconditions.checkNotNull(name, "Currency's name cannot be null!");
        Preconditions.checkNotNull(type, "Currency's reward cannot be null!");

        this.name = name;
        this.type = type;

        this.name_key = name.replace(' ', '_');
    }


    public UserCurrency(@NotNull GameRewardType type) {
        Preconditions.checkNotNull(type, "Currency's reward cannot be null!");

        this.name = type.getName();
        this.type = type;

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

        String custom = lang.getCustomMessagePattern("bedwars.user.currency." + name_key);
        return custom != null ? custom : name;
    }


    @NotNull
    public GameRewardType getRewardType() {
        return type;
    }


    @NotNull
    public ChatColor getColor() {
        return type.getColor();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        UserCurrency other = (UserCurrency) obj;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }


    @Nullable
    public static UserCurrency getByName(@NotNull String name) {
        return name != null ? BY_NAME.get(name.toLowerCase()) : null;
    }


    @Nullable
    public static UserCurrency getByRewardType(@NotNull GameRewardType type) {
        return type != null ? BY_REWARD.get(type) : null;
    }


    public static void register(@NotNull UserCurrency currency) {
        Preconditions.checkNotNull(currency, "Cannot register a null currency!");

        String name = currency.name.toLowerCase();
        if (BY_NAME.containsKey(name))
            throw new IllegalArgumentException("Another currency with the same name is already registered!");

        GameRewardType type = currency.type;
        if (BY_REWARD.containsKey(type))
            throw new IllegalArgumentException("Another currency with the same reward type is already registered!");

        UserCurrency.BY_NAME.put(name, currency);
        UserCurrency.BY_REWARD.put(type, currency);
    }


    public static boolean canRegister(@NotNull UserCurrency currency) {
        return currency != null && !BY_NAME.containsKey(currency.name.toLowerCase()) && !BY_REWARD.containsKey(currency.type);
    }


    @NotNull
    public static UserCurrency[] values() {
        return BY_NAME.values().toArray(new UserCurrency[BY_NAME.size()]);
    }

}