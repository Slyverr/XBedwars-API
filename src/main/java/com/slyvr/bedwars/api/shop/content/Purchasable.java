package com.slyvr.bedwars.api.shop.content;

import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.api.shop.ShopDisplayable;
import com.slyvr.bedwars.api.shop.content.data.PurchasableDescription;
import org.jetbrains.annotations.NotNull;

public interface Purchasable extends ShopDisplayable {

    @NotNull
    PurchasableDescription getDescription();

    boolean purchase(@NotNull GamePlayer player);

}