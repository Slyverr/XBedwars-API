package com.slyvr.bedwars.api.shop.items.type;

import com.slyvr.bedwars.api.shop.content.SimplePurchasable;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;


public interface PurchasableItem extends SimplePurchasable {

    @NotNull
    ItemStack getItem();

}