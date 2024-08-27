package com.slyvr.xbedwars.api.player;

import java.util.Map;
import java.util.Set;

import org.jetbrains.annotations.NotNull;

import com.slyvr.xbedwars.api.lang.Language;
import com.slyvr.xbedwars.api.reward.GameRewardReason;
import com.slyvr.xbedwars.api.reward.GameRewardType;

import net.md_5.bungee.api.chat.TextComponent;


public interface GamePlayerRewardManager {


    @NotNull
    Set<GameRewardType> getRewards();


    @NotNull
    Map<GameRewardReason, Integer> getIncrementHistory(@NotNull GameRewardType type);


    @NotNull
    Map<GameRewardReason, Integer> getDecrementHistory(@NotNull GameRewardType type);


    void increment(@NotNull GameRewardType type, @NotNull GameRewardReason reason, int amount);


    void decrement(@NotNull GameRewardType type, @NotNull GameRewardReason reason, int amount);


    int getTotalAmount(@NotNull GameRewardType type);


    int getTotalAmount();


    @NotNull
    TextComponent getRewardHistoryText(@NotNull GameRewardType type, @NotNull Language lang);


    @NotNull
    String getRewardText(@NotNull GameRewardType type, @NotNull Language lang);

}