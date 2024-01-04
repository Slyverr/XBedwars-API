package com.slyvr.bedwars.api.server;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public enum ServerType {

    DEFAULT("Default"),
    BUNGEE("Bungee");

    private final String name;

    ServerType(@NotNull String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


    @Nullable
    public static ServerType getByName(@NotNull String name, @Nullable ServerType def) {
        if (name == null)
            return def;

        switch (name.toLowerCase()) {
            case "default":
                return DEFAULT;
            case "bungee":
                return BUNGEE;
            default:
                return def;
        }

    }


    @Nullable
    public static ServerType getByName(@NotNull String name) {
        return getByName(name, null);
    }


}
