package com.slyvr.bedwars.api.event.room.chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import com.slyvr.bedwars.api.event.room.WaitingRoomEvent;
import com.slyvr.bedwars.api.room.WaitingRoom;


public class AsyncWaitingRoomPlayerChatEvent extends WaitingRoomEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Player player;
    private String format = ChatColor.GRAY + "{player}: {message}";
    private String message;
    private boolean isCancelled;


    public AsyncWaitingRoomPlayerChatEvent(@NotNull WaitingRoom room, @NotNull Player player, @NotNull String message) {
        super(room, true);

        this.message = message;
        this.player = player;
    }


    @NotNull
    public Player getPlayer() {
        return player;
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