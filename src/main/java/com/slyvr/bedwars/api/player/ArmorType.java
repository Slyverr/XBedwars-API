package com.slyvr.bedwars.api.player;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.slyvr.bedwars.api.lang.Language;


public enum ArmorType {


    LEATHER("Leather", Material.LEATHER, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS),


    CHAIN("Chain", Material.FIRE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS),


    IRON("Iron", Material.IRON_INGOT, Material.IRON_LEGGINGS, Material.IRON_BOOTS),


    DIAMOND("Diamond", Material.DIAMOND, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);

    private static final Map<Material, ArmorType> BY_CRAFT_MATERIAL = new HashMap<>(4);
    private static final Map<Material, ArmorType> BY_LEGGINGS = new HashMap<>(4);
    private static final Map<Material, ArmorType> BY_BOOTS = new HashMap<>(4);

    static {
        for (ArmorType type : values()) {
            ArmorType.BY_CRAFT_MATERIAL.put(type.material, type);
            ArmorType.BY_LEGGINGS.put(type.leggings, type);
            ArmorType.BY_BOOTS.put(type.boots, type);
        }

    }

    private final String name;
    private final Material material;
    private final Material leggings;
    private final Material boots;

    ArmorType(@NotNull String name, @NotNull Material material, @NotNull Material leggings, @NotNull Material boots) {
        this.name = name;

        this.material = material;
        this.leggings = leggings;
        this.boots = boots;
    }


    @NotNull
    public String getName() {
        return name;
    }


    @NotNull
    public String getName(@NotNull Language lang) {
        if (lang == null)
            return name;

        String custom = lang.getCustomMessagePattern("bedwars.armor." + name);
        return custom != null ? custom : name;
    }


    @NotNull
    public Material getLeggings() {
        return leggings;
    }


    @NotNull
    public Material getBoots() {
        return boots;
    }

    @Override
    public String toString() {
        return name;
    }


    @Nullable
    public static ArmorType getPlayerArmorType(@NotNull Player player) {
        if (player == null)
            return null;

        EntityEquipment equip = player.getEquipment();

        ItemStack leggings_item = equip.getLeggings();
        ItemStack boots_item = equip.getBoots();

        if (leggings_item == null || boots_item == null)
            return null;

        ArmorType leggings_type = getByLeggings(leggings_item.getType());
        ArmorType boots_type = getByBoots(boots_item.getType());

        return leggings_type == boots_type ? leggings_type : null;
    }


    @Nullable
    public static ArmorType getByLeggings(@NotNull Material leggings) {
        return BY_LEGGINGS.get(leggings);
    }


    @Nullable
    public static ArmorType getByBoots(@NotNull Material boots) {
        return BY_BOOTS.get(boots);
    }


    @Nullable
    public static ArmorType getByCraftMaterial(@NotNull Material type) {
        return type != null ? ArmorType.BY_CRAFT_MATERIAL.get(type) : null;
    }


    @Nullable
    public static ArmorType getByName(@NotNull String name) {
        if (name == null)
            return null;

        switch (name.toUpperCase()) {
            case "LEATHER":
                return LEATHER;
            case "CHAIN":
                return CHAIN;
            case "IRON":
                return IRON;
            case "DIAMOND":
                return DIAMOND;

            default:
                return null;
        }

    }

}