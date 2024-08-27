package com.slyvr.xbedwars.api.shop.upgrades.type;

import com.slyvr.xbedwars.api.shop.content.SimplePurchasable;
import com.slyvr.xbedwars.api.trap.Trap;
import org.jetbrains.annotations.NotNull;


public interface PurchasableTrap extends SimplePurchasable {


    @NotNull
    Trap getTrap();

}