package com.slyvr.bedwars.api.shop;

import com.slyvr.bedwars.api.player.GamePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.Map;


public interface Shop<T extends ShopCategory> {

    @NotNull
    ShopType getType();

    @NotNull
    Map<Integer, T> getCategories();

    @Nullable
    T getCategory(int slot);

    boolean click(@NotNull GamePlayer player, @Range(from = 0, to = 53) int slot);

    boolean open(@NotNull GamePlayer player, @Nullable ShopCategory category);

    boolean open(@NotNull GamePlayer player);

    boolean contains(@NotNull T category);


    enum ShopType {


        UPGRADES,


        ITEMS

    }

}