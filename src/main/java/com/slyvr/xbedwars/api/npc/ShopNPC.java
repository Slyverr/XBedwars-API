package com.slyvr.xbedwars.api.npc;

import com.slyvr.xbedwars.api.team.GameTeam;
import org.jetbrains.annotations.NotNull;

import static com.slyvr.xbedwars.api.shop.Shop.ShopType;


public interface ShopNPC {


    @NotNull
    GameTeam getGameTeam();


    @NotNull
    ShopType getShopType();


    @NotNull
    ShopNPCType<?> getNPCType();


    boolean spawn();


    boolean remove();


    boolean isDead();

}