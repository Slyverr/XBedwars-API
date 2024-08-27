package com.slyvr.xbedwars.api.shop.items.type;

import com.slyvr.xbedwars.api.shop.content.SimplePurchasable;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;


public interface PurchasableItem extends SimplePurchasable {

    @NotNull
    ItemStack getItem();

}