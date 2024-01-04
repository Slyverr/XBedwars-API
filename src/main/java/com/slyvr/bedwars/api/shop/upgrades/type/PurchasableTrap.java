package com.slyvr.bedwars.api.shop.upgrades.type;

import com.slyvr.bedwars.api.shop.content.SimplePurchasable;
import com.slyvr.bedwars.api.trap.Trap;
import org.jetbrains.annotations.NotNull;


public interface PurchasableTrap extends SimplePurchasable {


    @NotNull
    Trap getTrap();

}