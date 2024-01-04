package com.slyvr.bedwars.api.event.player.chat;

import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import com.slyvr.bedwars.api.event.player.GamePlayerEvent;
import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.utils.ChatUtils;


public class AsyncGamePlayerChatEvent extends GamePlayerEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private String format = ChatUtils.format("{level} {team} &7{player}: {message}");
    private String message;

    private boolean isCancelled;


    public AsyncGamePlayerChatEvent(@NotNull GamePlayer player, @NotNull String message) {
        super(player, true);

        this.message = message;
    }


    @NotNull
    public String getMessage() {
        return message;
    }


    public void setMessage(@NotNull String message) {
        if (message != null)
            this.message = message;
    }


    @NotNull
    public String getFormat() {
        return format;
    }


    public void setFormat(@NotNull String format) {
        if (format != null)
            this.format = format;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}