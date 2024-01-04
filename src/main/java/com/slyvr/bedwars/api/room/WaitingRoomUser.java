package com.slyvr.bedwars.api.room;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public interface WaitingRoomUser {


    @NotNull
    Player getPlayer();


    @NotNull
    WaitingRoom getWaitingRoom();

}