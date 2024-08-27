package com.slyvr.xbedwars.api.manager;

import com.slyvr.xbedwars.api.user.OfflineUser;
import com.slyvr.xbedwars.api.user.User;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;


public interface UsersManager {


    @NotNull
    Collection<User> getOnlineUsers();


    @Nullable
    User getRandomUser();


    @Nullable
    User getUser(@NotNull Player player);


    @Nullable
    OfflineUser getOfflineUser(@NotNull OfflinePlayer player);


    int size();

}