package com.slyvr.xbedwars.api.event.generator.team;

import com.slyvr.xbedwars.api.event.generator.ResourceGeneratorEvent;
import com.slyvr.xbedwars.api.generator.team.TeamResourceGenerator;
import org.jetbrains.annotations.NotNull;


public abstract class TeamResourceGeneratorEvent extends ResourceGeneratorEvent {


    public TeamResourceGeneratorEvent(@NotNull TeamResourceGenerator generator) {
        super(generator);
    }

    @NotNull
    public final TeamResourceGenerator getResourceGenerator() {
        return (TeamResourceGenerator) generator;
    }

}