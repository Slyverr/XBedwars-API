package com.slyvr.xbedwars.api.shop.upgrades;

import com.slyvr.xbedwars.api.player.GamePlayer;
import com.slyvr.xbedwars.api.shop.Shop;
import com.slyvr.xbedwars.api.shop.ShopCategory;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.slyvr.xbedwars.api.shop.upgrades.UpgradeShop.UpgradeShopCategory;


public interface UpgradeShop extends Shop<UpgradeShopCategory>, ShopCategory {

    @Override
    @NotNull
    default ItemStack getDisplayItem(@NotNull GamePlayer player) {
        return new ItemStack(Material.AIR);
    }


    interface UpgradeShopCategory extends ShopCategory {

    }

}