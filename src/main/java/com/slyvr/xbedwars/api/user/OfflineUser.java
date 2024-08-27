package com.slyvr.xbedwars.api.user;

import com.slyvr.xbedwars.api.game.GameMode;
import com.slyvr.xbedwars.api.lang.Language;
import com.slyvr.xbedwars.api.user.level.UserLevel;
import com.slyvr.xbedwars.api.user.level.UserPrestige;
import com.slyvr.xbedwars.api.user.shop.UserQuickBuy;
import com.slyvr.xbedwars.api.user.stats.UserStatistic;
import com.slyvr.xbedwars.api.user.stats.UserStatistics;
import com.slyvr.xbedwars.api.user.wallet.UserWallet;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;


public interface OfflineUser {


    @NotNull
    OfflinePlayer getPlayer();


    @NotNull
    UUID getUniqueId();


    @NotNull
    Language getLanguage();


    void setLanguage(@NotNull Language lang);


    @NotNull
    UserLevel getLevel();


    void setLevel(@NotNull UserLevel level);


    @NotNull
    UserPrestige getPrestige();


    void setPrestige(@NotNull UserPrestige prestige);


    @NotNull
    UserStatistics getOverallStatistics();

    int getOverallStatistic(@NotNull UserStatistic stat);

    @NotNull
    UserStatistics getStatistics(@NotNull GameMode mode);


    @NotNull
    UserQuickBuy getQuickBuy(@NotNull GameMode mode);


    @NotNull
    UserWallet getWallet();


    boolean isOnline();


    void loadData();


    void saveData();

}