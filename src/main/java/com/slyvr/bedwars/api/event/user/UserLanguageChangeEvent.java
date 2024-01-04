package com.slyvr.bedwars.api.event.user;

import com.slyvr.bedwars.api.lang.Language;
import com.slyvr.bedwars.api.user.User;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class UserLanguageChangeEvent extends UserEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Language previous;
    private final Language current;

    public UserLanguageChangeEvent(@NotNull User user, @NotNull Language previous, @NotNull Language current) {
        super(user);

        this.previous = previous;
        this.current = current;
    }

    @NotNull
    public Language getPreviousLanguage() {
        return previous;
    }

    @NotNull
    public Language getCurrentLanguage() {
        return current;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}