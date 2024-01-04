package com.slyvr.bedwars.api;

import com.slyvr.bedwars.api.player.GamePlayer;
import org.jetbrains.annotations.NotNull;


public interface BedwarsPluginUtils {


    void hidePlayerArmor(@NotNull GamePlayer player);

    void showPlayerArmor(@NotNull GamePlayer player);

    void register();

}