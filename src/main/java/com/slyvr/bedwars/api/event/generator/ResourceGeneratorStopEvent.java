package com.slyvr.bedwars.api.event.generator;

import com.slyvr.bedwars.api.generator.ResourceGenerator;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class ResourceGeneratorStopEvent extends ResourceGeneratorEvent {

    private static final HandlerList HANDLERS = new HandlerList();


    public ResourceGeneratorStopEvent(@NotNull ResourceGenerator gen) {
        super(gen);
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}