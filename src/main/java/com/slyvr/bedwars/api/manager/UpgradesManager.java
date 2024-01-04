package com.slyvr.bedwars.api.manager;

import com.slyvr.bedwars.api.upgrade.TieredUpgrade;
import com.slyvr.bedwars.api.upgrade.Upgrade;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;


public interface UpgradesManager {


    @NotNull
    Collection<Upgrade> getUpgrades();


    @NotNull
    Collection<TieredUpgrade> getTieredUpgrades();


    @Nullable
    Upgrade getUpgrade(@NotNull String name);


    @Nullable
    TieredUpgrade getTieredUpgrade(@NotNull String name);


    void registerUpgrade(@NotNull String name, @NotNull Upgrade upgrade);

}