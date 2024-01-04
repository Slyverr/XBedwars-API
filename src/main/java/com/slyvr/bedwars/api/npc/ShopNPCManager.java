package com.slyvr.bedwars.api.npc;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.slyvr.bedwars.api.shop.Shop;
import com.slyvr.bedwars.api.team.GameTeam;


public interface ShopNPCManager {


    @NotNull
    <T extends ShopNPC> T createNPC(@NotNull ShopNPCType<T> type, @NotNull GameTeam team, @NotNull Shop.ShopType shop, @NotNull Location loc);


    @Nullable
    ShopNPC getNPC(@NotNull Entity entity);

}
