package com.slyvr.bedwars.api.shop;

import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.api.shop.content.Purchasable;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


public interface ShopCategory extends ShopDisplayable {

    @NotNull
    Map<Integer, Purchasable> getPurchasables();

    @Nullable
    Purchasable getPurchasable(@Range(from = 0, to = 20) int slot);

    boolean populate(@NotNull Inventory inventory, @NotNull GamePlayer player);

    boolean click(@NotNull GamePlayer player, @Range(from = 0, to = 53) int slot);

    boolean contains(@NotNull Purchasable purchasable);

    void forEach(@NotNull BiConsumer<Integer, Purchasable> action);

    void forEach(@NotNull Consumer<Purchasable> action);

    @Range(from = -1, to = 20)
    int toCategorySlot(@Range(from = 0, to = 53) int index);

}