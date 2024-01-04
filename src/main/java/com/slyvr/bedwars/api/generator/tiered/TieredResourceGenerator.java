package com.slyvr.bedwars.api.generator.tiered;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.slyvr.bedwars.api.generator.Resource;
import com.slyvr.bedwars.api.generator.ResourceGenerator;


public interface TieredResourceGenerator extends ResourceGenerator {


    @NotNull
    List<ResourceGeneratorTier> getTiers();


    @Nullable
    ResourceGeneratorTier getCurrentTier();


    void setCurrentTier(int tier);


    @NotNull
    Resource getDrop();


    int size();

}