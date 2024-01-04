package com.slyvr.bedwars.api.shop;

import com.slyvr.bedwars.api.lang.NamesRegistry;
import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface ShopDisplayable {

    @NotNull
    NamesRegistry getNames();

    @NotNull
    ItemStack getDisplayItem(@NotNull GamePlayer player);

}