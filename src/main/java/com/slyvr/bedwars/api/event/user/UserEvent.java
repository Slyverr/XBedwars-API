package com.slyvr.bedwars.api.event.user;

import com.slyvr.bedwars.api.user.User;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;


public abstract class UserEvent extends Event {

    protected User user;


    public UserEvent(@NotNull User user, boolean async) {
        super(async);

        this.user = user;
    }


    public UserEvent(@NotNull User user) {
        this.user = user;
    }


    @NotNull
    public User getUser() {
        return user;
    }

}
