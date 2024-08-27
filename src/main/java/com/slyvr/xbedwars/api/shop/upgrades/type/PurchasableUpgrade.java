package com.slyvr.xbedwars.api.shop.upgrades.type;

import com.slyvr.xbedwars.api.shop.content.SimplePurchasable;
import com.slyvr.xbedwars.api.upgrade.Upgrade;
import org.jetbrains.annotations.NotNull;


public interface PurchasableUpgrade extends SimplePurchasable {


    @NotNull
    Upgrade getUpgrade();

}