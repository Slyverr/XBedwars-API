package com.slyvr.bedwars.api.lang;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.utils.ChatUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public enum Language {

    ENGLISH("English", "EN");

    private static final Map<String, Language> BY_NAME = new HashMap<>();
    private static final Map<String, Language> BY_CODE = new HashMap<>();

    static {
        for (Language lang : values()) {
            Language.BY_NAME.put(lang.name.toLowerCase(), lang);
            Language.BY_CODE.put(lang.code.toLowerCase(), lang);
        }

    }

    private final Map<String, String> custom_messages = new HashMap<>();
    private final Map<String, String> plugin_messages;

    private final String name;
    private final String code;


    Language(@NotNull String name, @NotNull String code) {
        this.name = name;
        this.code = code;

        this.plugin_messages = Collections.unmodifiableMap(convertToMap(ResourceBundle.getBundle("lang.Messages_" + code)));
    }

    @NotNull
    private Map<String, String> convertToMap(@NotNull ResourceBundle bundle) {
        Map<String, String> result = new HashMap<>();

        for (String key : bundle.keySet())
            result.put(key, ChatUtils.format(bundle.getString(key)));

        return result;
    }


    @NotNull
    public String getName() {
        return name;
    }


    @NotNull
    public String getCode() {
        return code;
    }


    @NotNull
    public String getFullName() {
        return name + " (" + code + ")";
    }


    @NotNull
    public String getMessagePattern(@NotNull Message message) {
        Preconditions.checkNotNull(message, "Cannot get the pattern of a null message!");
        return plugin_messages.get(message.getMessagePatternKey());
    }


    @Nullable
    public String getCustomMessagePattern(@NotNull String key) {
        return key != null ? custom_messages.get(key.toLowerCase()) : null;
    }


    public void setCustomMessagePattern(@NotNull String key, @Nullable String pattern) {
        if (key != null)
            this.custom_messages.putIfAbsent(key.toLowerCase(), pattern);
    }


    @NotNull
    public String format(@NotNull Message message, Object... args) {
        Preconditions.checkNotNull(message, "Cannot format a null message type!");
        return Message.format(plugin_messages.get(message.getMessagePatternKey()), args);
    }


    @Nullable
    public String format(@NotNull String key, Object... args) {
        if (key == null)
            return null;

        String pattern = custom_messages.get((key = key.toLowerCase()));
        return Message.format(pattern == null ? plugin_messages.get(key) : pattern, args);
    }


    @Nullable
    public static Language getByName(@NotNull String name, @Nullable Language def) {
        return name != null ? BY_NAME.getOrDefault(name.toLowerCase(), def) : def;
    }


    @Nullable
    public static Language getByName(@NotNull String name) {
        return getByName(name, null);
    }


    @Nullable
    public static Language getByISOCode(@NotNull String code, @Nullable Language def) {
        return code != null ? BY_CODE.getOrDefault(code.toLowerCase(), def) : def;
    }


    @Nullable
    public static Language getByISOCode(@NotNull String code) {
        return getByISOCode(code, null);
    }


    @Nullable
    public static Language getByString(@NotNull String string, @Nullable Language def) {
        if (string == null)
            return def;

        Language language = BY_NAME.get((string = string.toLowerCase()));
        return language == null ? BY_CODE.getOrDefault(string, def) : language;
    }


    @Nullable
    public static Language getByString(@NotNull String string) {
        return getByString(string, null);
    }

}