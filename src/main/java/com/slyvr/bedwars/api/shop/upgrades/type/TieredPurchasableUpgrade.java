package com.slyvr.bedwars.api.shop.upgrades.type;

import com.slyvr.bedwars.api.shop.content.TieredPurchasable;
import com.slyvr.bedwars.api.upgrade.TieredUpgrade;
import org.jetbrains.annotations.NotNull;


public interface TieredPurchasableUpgrade extends TieredPurchasable {


    @NotNull
    TieredUpgrade getUpgrade();


}