package com.slyvr.bedwars.api.user;

import com.slyvr.bedwars.api.game.GameMode;
import com.slyvr.bedwars.api.lang.Language;
import com.slyvr.bedwars.api.user.level.UserLevel;
import com.slyvr.bedwars.api.user.level.UserPrestige;
import com.slyvr.bedwars.api.user.shop.UserQuickBuy;
import com.slyvr.bedwars.api.user.stats.UserStatistic;
import com.slyvr.bedwars.api.user.stats.UserStatistics;
import com.slyvr.bedwars.api.user.wallet.UserWallet;
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