package com.slyvr.xbedwars.api.shop.content;

import com.slyvr.xbedwars.api.player.GamePlayer;
import com.slyvr.xbedwars.api.shop.content.data.PurchasableCost;
import org.jetbrains.annotations.NotNull;

public interface SimplePurchasable extends Purchasable {

    @NotNull
    PurchasableCost getCost(@NotNull GamePlayer player);

}