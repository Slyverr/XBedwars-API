package com.slyvr.bedwars.api.scoreboard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.google.common.base.Preconditions;


public abstract class ScoreboardPlaceholder {

    private static final Map<String, ScoreboardPlaceholder> PLACE_HOLDERS = new HashMap<>();

    static {
        ScoreboardPlaceholder.register(new ScoreboardPlaceholder("Date") {

            private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

            @Override
            public @NotNull String getValue() {
                return formatter.format(new Date());
            }

        });

    }

    private final String place_holder;
    private final String format;


    public ScoreboardPlaceholder(@NotNull String placeholder) {
        Preconditions.checkNotNull(placeholder, "Scoreboard placeholder cannot be null!");

        this.place_holder = placeholder;
        this.format = '%' + placeholder.toLowerCase() + '%';
    }


    @NotNull
    public final String getPlaceholder() {
        return place_holder;
    }


    @NotNull
    public final String getPlaceholderFormat() {
        return format;
    }


    @NotNull
    public String replace(@NotNull String text) {
        return text != null ? text.replace(format, getValue()) : text;
    }


    @NotNull
    public abstract String getValue();


    @Nullable
    public static String replaceAll(@NotNull String text) {
        if (text == null || PLACE_HOLDERS.isEmpty())
            return text;

        for (ScoreboardPlaceholder placeholder : PLACE_HOLDERS.values())
            text = text.replace(placeholder.format, placeholder.getValue());

        return text;
    }


    @Nullable
    public static ScoreboardPlaceholder getByPlaceHolder(@NotNull String placeholder) {
        return placeholder != null ? PLACE_HOLDERS.get(placeholder.toLowerCase()) : null;
    }


    public static void register(@NotNull ScoreboardPlaceholder placeholder) {
        Preconditions.checkNotNull(placeholder, "Cannot register a null placeholder!");

        if (PLACE_HOLDERS.putIfAbsent(placeholder.place_holder.toLowerCase(), placeholder) != null)
            throw new IllegalArgumentException("Another scoreboard-placeholder with the same placeholder text is already registered!");
    }


    public static boolean canRegister(@NotNull ScoreboardPlaceholder placeholder) {
        return placeholder != null && !PLACE_HOLDERS.containsKey(placeholder.place_holder.toLowerCase());
    }


    @NotNull
    public static ScoreboardPlaceholder[] values() {
        return PLACE_HOLDERS.values().toArray(new ScoreboardPlaceholder[PLACE_HOLDERS.size()]);
    }


}