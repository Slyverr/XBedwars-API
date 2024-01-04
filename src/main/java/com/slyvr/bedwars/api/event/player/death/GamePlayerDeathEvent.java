package com.slyvr.bedwars.api.event.player.death;

import com.slyvr.bedwars.api.event.EventMessageHandler;
import com.slyvr.bedwars.api.event.player.GamePlayerEvent;
import com.slyvr.bedwars.api.generator.Resource;
import com.slyvr.bedwars.api.lang.Message;
import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


public class GamePlayerDeathEvent extends GamePlayerEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    protected final EventMessageHandler message_handler;
    protected final Map<Resource, Integer> drops;
    protected final DamageCause cause;
    protected final boolean isFinal;

    public GamePlayerDeathEvent(@NotNull GamePlayer player, @NotNull Map<Resource, Integer> drops, @NotNull DamageCause cause, boolean isFinal) {
        super(player);

        this.drops = drops;
        this.cause = cause;
        this.isFinal = isFinal;

        this.message_handler = new EventMessageHandler(getDeathMessage(cause));
    }

    @NotNull
    protected Message getDeathMessage(@NotNull DamageCause cause) {
        if (isFinal)
            return cause == DamageCause.VOID ? Message.PLAYER_DEATH_VOID_FALLEN_FINAL : Message.PLAYER_DEATH_FINAL;
        else
            return cause == DamageCause.VOID ? Message.PLAYER_DEATH_VOID_FALLEN : Message.PLAYER_DEATH;
    }

    @NotNull
    public Map<Resource, Integer> getDrops() {
        return drops;
    }

    @NotNull
    public DamageCause getCause() {
        return cause;
    }

    @NotNull
    public EventMessageHandler getDeathMessageHandler() {
        return message_handler;
    }

    public boolean isFinalKill() {
        return isFinal;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}