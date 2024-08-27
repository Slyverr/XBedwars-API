package com.slyvr.xbedwars.api.shop.items;

import com.slyvr.xbedwars.api.shop.Shop;
import com.slyvr.xbedwars.api.shop.ShopCategory;

import static com.slyvr.xbedwars.api.shop.items.ItemShop.ItemShopCategory;


public interface ItemShop extends Shop<ItemShopCategory> {
    
    interface ItemShopCategory extends ShopCategory {

    }

}