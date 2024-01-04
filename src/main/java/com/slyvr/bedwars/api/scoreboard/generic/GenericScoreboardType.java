package com.slyvr.bedwars.api.scoreboard.generic;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.player.GamePlayer;
import com.slyvr.bedwars.api.room.WaitingRoom;
import com.slyvr.bedwars.api.room.WaitingRoomUser;
import com.slyvr.bedwars.api.scoreboard.generic.custom.GameScoreboard;
import com.slyvr.bedwars.api.scoreboard.generic.custom.LobbyScoreboard;
import com.slyvr.bedwars.api.scoreboard.generic.custom.WaitingRoomScoreboard;
import com.slyvr.bedwars.api.user.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public final class GenericScoreboardType<C, P> {


    public static final GenericScoreboardType<LobbyScoreboard, User> LOBBY = new GenericScoreboardType<>("Lobby", User.class);


    public static final GenericScoreboardType<GameScoreboard, GamePlayer> GAME = new GenericScoreboardType<>("Game", GamePlayer.class);


    public static final GenericScoreboardType<WaitingRoomScoreboard, WaitingRoomUser> WAITING_ROOM = new GenericScoreboardType<>("Waiting Room", WaitingRoomUser.class);

    private final String name;
    private final Class<P> type;


    private GenericScoreboardType(@NotNull String name, @NotNull Class<P> type) {
        Preconditions.checkNotNull(name, "Scoreboard's name cannot be null!");
        Preconditions.checkNotNull(type, "Scoreboard's parameter type cannot be null!");

        this.name = name;
        this.type = type;
    }


    @NotNull
    public String getName() {
        return name;
    }


    @NotNull
    public Class<P> getParameterType() {
        return type;
    }

    @Nullable
    public static GenericScoreboardType<?, ?> getByName(@NotNull String name) {
        if (name == null)
            return null;

        switch (name.toLowerCase()) {
            case "lobby":
                return LOBBY;
            case "game":
                return GAME;
            case "waiting":
            case "waiting room":
            case "waiting_room":
                return WAITING_ROOM;

            default:
                return null;
        }

    }


    @Nullable
    public static GenericScoreboardType<?, ?> getByParameterType(@NotNull Class<?> type) {
        if (type == null)
            return null;

        if (type.equals(User.class))
            return LOBBY;

        if (type.equals(GamePlayer.class))
            return GAME;

        if (type.equals(WaitingRoom.class))
            return WAITING_ROOM;

        return null;

    }


    @NotNull
    public static GenericScoreboardType<?, ?>[] values() {
        return new GenericScoreboardType[]{LOBBY, WAITING_ROOM, GAME};
    }

}