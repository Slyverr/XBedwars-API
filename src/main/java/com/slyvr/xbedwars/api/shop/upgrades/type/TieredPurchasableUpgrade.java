package com.slyvr.xbedwars.api.shop.upgrades.type;

import com.slyvr.xbedwars.api.shop.content.TieredPurchasable;
import com.slyvr.xbedwars.api.upgrade.TieredUpgrade;
import org.jetbrains.annotations.NotNull;


public interface TieredPurchasableUpgrade extends TieredPurchasable {


    @NotNull
    TieredUpgrade getUpgrade();


}