package com.slyvr.xbedwars.api.user.shop;

import com.slyvr.xbedwars.api.shop.content.Purchasable;
import com.slyvr.xbedwars.api.shop.items.ItemShop.ItemShopCategory;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;


public interface UserQuickBuy extends ItemShopCategory {

    @NotNull
    OfflinePlayer getOwner();

    boolean setPurchasable(@Range(from = 0, to = 20) int slot, @Nullable Purchasable purchasable);

}