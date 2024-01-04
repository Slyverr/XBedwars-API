package com.slyvr.bedwars.api.shop.upgrades;

import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.api.shop.Shop;
import com.slyvr.bedwars.api.shop.ShopCategory;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.slyvr.bedwars.api.shop.upgrades.UpgradeShop.UpgradeShopCategory;


public interface UpgradeShop extends Shop<UpgradeShopCategory>, ShopCategory {

    @Override
    @NotNull
    default ItemStack getDisplayItem(@NotNull GamePlayer player) {
        return new ItemStack(Material.AIR);
    }


    interface UpgradeShopCategory extends ShopCategory {

    }

}