package com.slyvr.bedwars.api.shop.content;

import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.api.shop.content.data.PurchasableCost;
import org.jetbrains.annotations.NotNull;

public interface SimplePurchasable extends Purchasable {

    @NotNull
    PurchasableCost getCost(@NotNull GamePlayer player);

}