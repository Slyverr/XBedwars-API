package com.slyvr.xbedwars.api.event.user.shop;

import com.slyvr.xbedwars.api.user.shop.UserQuickBuy;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;


public abstract class UserQuickBuyEvent extends Event {

    protected UserQuickBuy qb;

    public UserQuickBuyEvent(@NotNull UserQuickBuy qb) {
        this.qb = qb;
    }


    @NotNull
    public final UserQuickBuy getQuickBuy() {
        return qb;
    }

}