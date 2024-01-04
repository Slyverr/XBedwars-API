package com.slyvr.bedwars.api.scoreboard.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.scoreboard.ScoreboardPlaceholder;


public abstract class GenericScoreboardPlaceholder<T> {

    private static final Map<GenericScoreboardType<?, ?>, Map<String, GenericScoreboardPlaceholder<?>>> PLACE_HOLDERS = new HashMap<>();

    private final GenericScoreboardType<?, T> type;
    private final String placeholder;
    private final String format;


    public GenericScoreboardPlaceholder(@NotNull GenericScoreboardType<?, T> type, @NotNull String placeholder) {
        Preconditions.checkNotNull(type, "Scoreboard's type cannot be null!");
        Preconditions.checkNotNull(placeholder, "Scoreboard's placeholder cannot be null!");

        this.type = type;
        this.placeholder = placeholder;
        this.format = '%' + placeholder.toLowerCase() + '%';
    }


    @NotNull
    public final GenericScoreboardType<?, T> getScoreboardType() {
        return type;
    }


    @NotNull
    public final String getPlaceholder() {
        return placeholder;
    }


    @NotNull
    public final String getPlaceholderFormat() {
        return format;
    }


    @Nullable
    public String replace(@NotNull String text, @NotNull T arg) {
        return text != null && arg != null ? text.replace(format, getValue(arg)) : text;
    }


    @NotNull
    public abstract String getValue(@NotNull T arg);


    @Nullable
    public static <T> String replaceAll(@NotNull GenericScoreboardType<?, T> type, @NotNull String text, @NotNull T arg) {
        if (text == null || type == null || arg == null)
            return text;

        Map<String, GenericScoreboardPlaceholder<?>> placeholders_map = PLACE_HOLDERS.get(type);
        if (placeholders_map == null)
            return text;

        for (GenericScoreboardPlaceholder<?> placeholder : placeholders_map.values())
            text = text.replace(placeholder.format, ((GenericScoreboardPlaceholder<T>) placeholder).getValue(arg));

        return ScoreboardPlaceholder.replaceAll(text);
    }


    public static void register(@NotNull GenericScoreboardPlaceholder<?> placeholder) {
        Preconditions.checkNotNull(placeholder, "Cannot register a null placeholder!");

        Map<String, GenericScoreboardPlaceholder<?>> placeholders = PLACE_HOLDERS.computeIfAbsent(placeholder.type, type -> new HashMap<>());

        if (placeholders.putIfAbsent(placeholder.placeholder.toLowerCase(), placeholder) != null)
            throw new IllegalArgumentException("Another scoreboard-placeholder with the same placeholder is already registered!");
    }


    public static boolean canRegister(@NotNull GenericScoreboardPlaceholder<?> placeholder) {
        if (placeholder == null)
            return false;

        Map<String, GenericScoreboardPlaceholder<?>> placeholders = PLACE_HOLDERS.get(placeholder.type);
        return placeholders != null && !placeholders.containsKey(placeholder.placeholder.toLowerCase());
    }


    @Nullable
    public static GenericScoreboardPlaceholder<?> getByPlaceholder(@NotNull GenericScoreboardType<?, ?> type, @NotNull String placeholder) {
        if (type == null || placeholder == null)
            return null;

        Map<String, GenericScoreboardPlaceholder<?>> placeholders = PLACE_HOLDERS.get(type);
        return placeholders != null ? placeholders.get(placeholder.toLowerCase()) : null;
    }


    @NotNull
    public static GenericScoreboardPlaceholder<?>[] values() {
        List<GenericScoreboardPlaceholder<?>> result = new ArrayList<>();

        for (Map<String, GenericScoreboardPlaceholder<?>> placeholders : PLACE_HOLDERS.values())
            result.addAll(placeholders.values());

        return result.toArray(new GenericScoreboardPlaceholder<?>[result.size()]);
    }


}