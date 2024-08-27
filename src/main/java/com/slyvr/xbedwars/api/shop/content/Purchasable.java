package com.slyvr.xbedwars.api.shop.content;

import com.slyvr.xbedwars.api.player.GamePlayer;
import com.slyvr.xbedwars.api.shop.ShopDisplayable;
import com.slyvr.xbedwars.api.shop.content.data.PurchasableDescription;
import org.jetbrains.annotations.NotNull;

public interface Purchasable extends ShopDisplayable {

    @NotNull
    PurchasableDescription getDescription();

    boolean purchase(@NotNull GamePlayer player);

}