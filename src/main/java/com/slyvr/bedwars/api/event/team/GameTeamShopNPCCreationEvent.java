package com.slyvr.bedwars.api.event.team;

import com.slyvr.bedwars.api.npc.ShopNPCType;
import com.slyvr.bedwars.api.shop.Shop.ShopType;
import com.slyvr.bedwars.api.team.GameTeam;
import org.bukkit.Location;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class GameTeamShopNPCCreationEvent extends GameTeamEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final ShopType shop_type;
    private final Location shop_loc;

    private ShopNPCType<?> npc_type;

    public GameTeamShopNPCCreationEvent(@NotNull GameTeam team, @NotNull ShopNPCType<?> type, @NotNull ShopType shop, @NotNull Location loc) {
        super(team);

        this.npc_type = type;
        this.shop_type = shop;
        this.shop_loc = loc;
    }


    @NotNull
    public ShopNPCType<?> getNPCType() {
        return npc_type;
    }

    public void setNPCType(@NotNull ShopNPCType<?> type) {
        if (type != null)
            this.npc_type = type;
    }

    @NotNull
    public ShopType getShopType() {
        return shop_type;
    }

    @NotNull
    public Location getSpawnLocation() {
        return shop_loc.clone();
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}