package com.slyvr.xbedwars.api.event.generator;

import com.slyvr.xbedwars.api.generator.ResourceGenerator;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;


public abstract class ResourceGeneratorEvent extends Event {

    protected ResourceGenerator generator;


    public ResourceGeneratorEvent(@NotNull ResourceGenerator gen) {
        this.generator = gen;
    }


    @NotNull
    public ResourceGenerator getResourceGenerator() {
        return generator;
    }

}