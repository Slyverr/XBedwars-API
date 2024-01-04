package com.slyvr.bedwars.api.user.shop;

import com.slyvr.bedwars.api.shop.content.Purchasable;
import com.slyvr.bedwars.api.shop.items.ItemShop.ItemShopCategory;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;


public interface UserQuickBuy extends ItemShopCategory {

    @NotNull
    OfflinePlayer getOwner();

    boolean setPurchasable(@Range(from = 0, to = 20) int slot, @Nullable Purchasable purchasable);

}