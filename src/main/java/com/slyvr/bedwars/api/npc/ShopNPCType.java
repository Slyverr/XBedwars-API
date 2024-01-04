package com.slyvr.bedwars.api.npc;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.shop.Shop;
import com.slyvr.bedwars.api.shop.Shop.ShopType;
import com.slyvr.bedwars.api.team.GameTeam;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public abstract class ShopNPCType<T extends ShopNPC> {

    private static final Map<String, ShopNPCType<?>> BY_NAME = new HashMap<>();

    private final String name;

    public ShopNPCType(@NotNull String name) {
        this.name = Preconditions.checkNotNull(name, "ShopNPC's name cannot be null!");
    }

    @NotNull
    public final String getName() {
        return name;
    }

    @NotNull
    public abstract T create(@NotNull GameTeam team, @NotNull ShopType type, @NotNull Location loc);

    @Nullable
    public abstract T getNPC(@NotNull Entity entity);

    @Override
    public final int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof ShopNPCType))
            return false;

        ShopNPCType<?> other = (ShopNPCType<?>) obj;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public final String toString() {
        return "ShopNPCType{" +
                "name='" + name + '\'' +
                '}';
    }
    
    @NotNull
    public static <T extends ShopNPC> T create(@NotNull ShopNPCType<T> type, @NotNull GameTeam team, @NotNull Shop.ShopType shop, @NotNull Location loc) {
        Preconditions.checkNotNull(type, "ShopNPC's type cannot be null!");
        Preconditions.checkNotNull(team, "ShopNPC's team cannot be null!");
        Preconditions.checkNotNull(shop, "ShopNPC's shop-type cannot be null!");
        Preconditions.checkNotNull(loc, "ShopNPC's spawn-point cannot be null!");

        return type.create(team, shop, loc);
    }

    @Nullable
    public static ShopNPC getShopNPC(@NotNull Entity entity) {
        if (entity == null)
            return null;

        for (ShopNPCType<?> type : BY_NAME.values()) {
            ShopNPC npc = type.getNPC(entity);
            if (npc != null)
                return npc;
        }

        return null;
    }

    @Nullable
    public static ShopNPCType<?> getByName(@NotNull String name) {
        return name != null ? BY_NAME.get(name.toLowerCase()) : null;
    }

    public static void register(@NotNull ShopNPCType<?> type) {
        Preconditions.checkNotNull(type, "Cannot register a null shop-npc's type!");

        if (BY_NAME.putIfAbsent(type.name.toLowerCase(), type) != null)
            throw new IllegalArgumentException("Another shop-npc's type is already registered with the same name!");
    }

    public static boolean canRegister(@NotNull ShopNPCType<?> type) {
        return type != null && !BY_NAME.containsKey(type.name.toLowerCase());
    }

    @NotNull
    public static ShopNPCType<?>[] values() {
        return BY_NAME.values().toArray(new ShopNPCType<?>[BY_NAME.size()]);
    }

}