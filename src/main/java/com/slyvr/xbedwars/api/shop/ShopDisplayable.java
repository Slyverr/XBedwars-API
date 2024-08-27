package com.slyvr.xbedwars.api.shop;

import com.slyvr.xbedwars.api.lang.NamesRegistry;
import com.slyvr.xbedwars.api.player.GamePlayer;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface ShopDisplayable {

    @NotNull
    NamesRegistry getNames();

    @NotNull
    ItemStack getDisplayItem(@NotNull GamePlayer player);

}