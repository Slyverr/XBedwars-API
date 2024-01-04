package com.slyvr.bedwars.api.event;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.lang.Language;
import com.slyvr.bedwars.api.lang.Message;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;


public final class EventMessageHandler {

    private final Map<Language, String> custom_patterns = new HashMap<>();
    private final Message message;


    public EventMessageHandler(@NotNull Message message) {
        Preconditions.checkNotNull(message, "Cannot handle a null message type!");

        this.message = message;
    }


    @NotNull
    public Message getMessage() {
        return message;
    }


    @NotNull
    public String getMessagePattern(@NotNull Language lang) {
        Preconditions.checkNotNull(lang, "Cannot get message pattern of a null language!");

        String result = custom_patterns.get(lang);
        return result != null ? result : lang.getMessagePattern(message);
    }


    public void setMessagePattern(@NotNull Language lang, @NotNull String pattern) {
        if (lang != null && pattern != null)
            this.custom_patterns.put(lang, pattern);
    }


    public void setMessagePattern(@NotNull String pattern) {
        if (pattern == null)
            return;

        for (Language lang : Language.values())
            this.custom_patterns.put(lang, pattern);
    }


    @Nullable
    public String format(@NotNull Language lang, Object... args) {
        if (lang == null)
            return null;

        String pattern = custom_patterns.get(lang);
        return Message.format(pattern == null ? lang.getMessagePattern(message) : pattern, args);
    }

}