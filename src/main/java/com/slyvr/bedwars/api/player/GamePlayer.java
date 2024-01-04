package com.slyvr.bedwars.api.player;

import com.slyvr.bedwars.api.game.Game;
import com.slyvr.bedwars.api.lang.Message;
import com.slyvr.bedwars.api.team.GameTeam;
import com.slyvr.bedwars.api.team.TeamColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;


public interface GamePlayer {


    @NotNull
    Player getPlayer();


    @NotNull
    Game getGame();


    @NotNull
    GameTeam getTeam();


    @NotNull
    TeamColor getTeamColor();


    @NotNull
    ArmorType getArmorType();


    void setArmorType(@NotNull ArmorType type);


    @NotNull
    GamePlayerInventory getInventory();


    @NotNull
    GamePlayerStatisticManager getStatisticManager();


    @NotNull
    GamePlayerRewardManager getRewardManager();


    void setInvisible(@NotNull Plugin plugin, boolean invisible);


    boolean isInvisible();


    void setInvincible(@NotNull Plugin plugin, boolean invincible);


    boolean isInvincible();


    void setTrapSafe(@NotNull Plugin plugin, boolean safe);


    boolean isTrapSafe();


    void sendMessage(@NotNull Message message, Object... args);


    void sendMessage(@NotNull String message);

    void refresh();

}