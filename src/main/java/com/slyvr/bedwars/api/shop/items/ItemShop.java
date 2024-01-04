package com.slyvr.bedwars.api.shop.items;

import com.slyvr.bedwars.api.shop.Shop;
import com.slyvr.bedwars.api.shop.ShopCategory;

import static com.slyvr.bedwars.api.shop.items.ItemShop.ItemShopCategory;


public interface ItemShop extends Shop<ItemShopCategory> {
    
    interface ItemShopCategory extends ShopCategory {

    }

}