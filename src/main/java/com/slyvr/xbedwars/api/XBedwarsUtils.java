package com.slyvr.xbedwars.api;

import com.slyvr.xbedwars.api.player.GamePlayer;
import org.jetbrains.annotations.NotNull;


public interface XBedwarsUtils {


    void hidePlayerArmor(@NotNull GamePlayer player);

    void showPlayerArmor(@NotNull GamePlayer player);

    void register();

}