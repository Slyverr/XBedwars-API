package com.slyvr.bedwars.api.shop.upgrades.type;

import com.slyvr.bedwars.api.shop.content.SimplePurchasable;
import com.slyvr.bedwars.api.upgrade.Upgrade;
import org.jetbrains.annotations.NotNull;


public interface PurchasableUpgrade extends SimplePurchasable {


    @NotNull
    Upgrade getUpgrade();

}