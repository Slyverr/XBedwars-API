package com.slyvr.bedwars.api.team;

import java.util.Set;
import java.util.function.Predicate;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.api.upgrade.TieredUpgrade;
import com.slyvr.bedwars.api.upgrade.Upgrade;


public interface GameTeamUpgradeManager {


    @NotNull
    Set<Upgrade> getUpgrades();


    boolean addUpgrade(@NotNull Upgrade upgrade);


    boolean removeUpgrade(@NotNull Upgrade upgrade);


    int getCurrentTier(@NotNull TieredUpgrade upgrade);


    void setCurrentTier(@NotNull TieredUpgrade upgrade, int tier);


    void apply(@NotNull GamePlayer player);


    void apply(@NotNull GamePlayer player, @Nullable Predicate<Upgrade> predicate);


    boolean contains(@NotNull Upgrade upgrade);

}