package com.slyvr.bedwars.api.player;

import com.slyvr.bedwars.api.shop.items.type.TieredPurchasableItem.TieredItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Set;


public interface GamePlayerInventory {


    @NotNull
    Set<ItemStack> getItems();


    @NotNull
    Set<TieredItemStack> getTieredItems();


    boolean addItem(@NotNull ItemStack item);


    boolean removeItem(@NotNull ItemStack item);


    boolean addTieredItem(@NotNull TieredItemStack item);


    int getTieredItemTier(@NotNull TieredItemStack item);


    void setTieredItemTier(@NotNull TieredItemStack item, int tier);


    boolean removeTieredItem(@NotNull TieredItemStack item);


    boolean contains(@NotNull Material type);


    boolean contains(@NotNull ItemStack item);


    boolean contains(@NotNull TieredItemStack item);

    void sendItems(@NotNull Player player);

    void clear();

}