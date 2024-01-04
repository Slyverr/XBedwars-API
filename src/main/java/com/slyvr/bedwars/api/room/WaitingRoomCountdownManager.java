package com.slyvr.bedwars.api.room;

import org.jetbrains.annotations.NotNull;


public interface WaitingRoomCountdownManager {


    @NotNull
    WaitingRoom getWaitingRoom();


    void startCountdown();


    void pauseCountdown();


    void continueCountdown();


    void stopCountdown();


    long timeLeft();


    boolean isWaiting();

}