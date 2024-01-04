package com.slyvr.bedwars.api.event.shop;

import com.slyvr.bedwars.api.shop.Shop;
import com.slyvr.bedwars.api.shop.Shop.ShopType;
import com.slyvr.bedwars.api.shop.ShopCategory;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public abstract class ShopEvent extends Event {

    protected Shop<?> shop;
    protected ShopCategory category;


    public ShopEvent(@NotNull Shop<?> shop, @Nullable ShopCategory category) {
        this.shop = shop;
        this.category = category;
    }


    @NotNull
    public Shop<?> getShop() {
        return shop;
    }


    @NotNull
    public ShopType getShopType() {
        return shop.getType();
    }


    @Nullable
    public ShopCategory getCategory() {
        return category;
    }

}