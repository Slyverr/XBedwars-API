package com.slyvr.xbedwars.api.event.generator.tiered;

import com.slyvr.xbedwars.api.event.generator.ResourceGeneratorEvent;
import com.slyvr.xbedwars.api.generator.tiered.TieredResourceGenerator;
import org.jetbrains.annotations.NotNull;


public abstract class TieredResourceGeneratorEvent extends ResourceGeneratorEvent {


    public TieredResourceGeneratorEvent(@NotNull TieredResourceGenerator generator) {
        super(generator);
    }

    @NotNull
    public final TieredResourceGenerator getResourceGenerator() {
        return (TieredResourceGenerator) generator;
    }

}