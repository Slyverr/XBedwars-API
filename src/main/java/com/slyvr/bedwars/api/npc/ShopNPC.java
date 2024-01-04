package com.slyvr.bedwars.api.npc;

import com.slyvr.bedwars.api.team.GameTeam;
import org.jetbrains.annotations.NotNull;

import static com.slyvr.bedwars.api.shop.Shop.ShopType;


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