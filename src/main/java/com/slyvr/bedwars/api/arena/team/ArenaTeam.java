package com.slyvr.bedwars.api.arena.team;

import org.bukkit.Location;
import org.bukkit.block.Chest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.slyvr.bedwars.api.shop.Shop;
import com.slyvr.bedwars.api.team.TeamColor;


public interface ArenaTeam {


    @NotNull
    TeamColor getColor();


    @Nullable
    ArenaTeamBed getBed();


    void setBed(@NotNull ArenaTeamBed bed);


    @Nullable
    Location getSpawnLocation();


    void setSpawnLocation(@NotNull Location spawn);


    @Nullable
    Location getShopNPCLocation(@NotNull Shop.ShopType type);


    void setShopNPCLocation(@NotNull Shop.ShopType type, @NotNull Location loc);


    @Nullable
    Location getResourceGeneratorLocation();


    void setResourceGeneratorLocation(@NotNull Location loc);


    @Nullable
    Chest getChest();


    void setChest(@NotNull Chest chest);


    boolean isReady();

}