package com.slyvr.bedwars.api.event.generator;

import com.slyvr.bedwars.api.generator.ResourceGenerator;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class ResourceGeneratorStartEvent extends ResourceGeneratorEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private boolean isCancelled;


    public ResourceGeneratorStartEvent(@NotNull ResourceGenerator gen) {
        super(gen);
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}