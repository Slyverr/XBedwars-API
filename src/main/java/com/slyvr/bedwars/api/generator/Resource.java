package com.slyvr.bedwars.api.generator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.lang.Language;


public final class Resource {


    public static final Resource EMERALD = new Resource("Emerald", "Emeralds", Material.EMERALD, Material.EMERALD_BLOCK, ChatColor.DARK_GREEN);


    public static final Resource DIAMOND = new Resource("Diamond", "Diamonds", Material.DIAMOND, Material.DIAMOND_BLOCK, ChatColor.AQUA);


    public static final Resource GOLD = new Resource("Gold", Material.GOLD_INGOT, Material.GOLD_BLOCK, ChatColor.GOLD);


    public static final Resource IRON = new Resource("Iron", Material.IRON_INGOT, Material.IRON_BLOCK, ChatColor.WHITE);


    public static final Resource FREE = new Resource("Free", Material.AIR, Material.AIR, ChatColor.GREEN);

    private static final Map<String, Resource> BY_NAME = new LinkedHashMap<>();
    private static final Map<Material, Resource> BY_TYPE = new HashMap<>();
    private static final Map<Material, Resource> BY_BLOCK = new HashMap<>();

    static {
        Resource.register(Resource.EMERALD);
        Resource.register(Resource.DIAMOND);
        Resource.register(Resource.GOLD);
        Resource.register(Resource.IRON);
        Resource.register(Resource.FREE);
    }

    private final String name;
    private final String plural;
    private final String name_key;

    private final Material material;
    private final Material block;
    private final ChatColor color;


    public Resource(@NotNull String name, @NotNull String plural, @NotNull Material material, @NotNull Material block, @NotNull ChatColor color) {
        Preconditions.checkNotNull(name, "Resource's name cannot be null!");
        Preconditions.checkNotNull(plural, "Resource's plural name cannot be null!");

        Preconditions.checkNotNull(material, "Resource's material cannot be null!");
        Preconditions.checkNotNull(block, "Resource's block material cannot be null!");
        Preconditions.checkArgument(block.isBlock(), "Resource's block material is not a block!");
        Preconditions.checkNotNull(color, "Resource's color cannot be null!");

        this.name = name;
        this.plural = plural;

        this.material = material;
        this.block = block;
        this.color = color;

        this.name_key = name.replace(' ', '_');
    }


    public Resource(@NotNull String name, @NotNull Material material, @NotNull Material block, @NotNull ChatColor color) {
        this(name, name, material, block, color);
    }


    @NotNull
    public String getName() {
        return name;
    }


    @NotNull
    public String getName(@NotNull Language lang) {
        if (lang == null)
            return name;

        String custom = lang.getCustomMessagePattern("bedwars.resource." + name_key);
        return custom != null ? custom : name;
    }


    @NotNull
    public String getPluralName() {
        return plural;
    }


    @NotNull
    public String getPluralName(@NotNull Language lang) {
        if (lang == null)
            return plural;

        String custom = lang.getCustomMessagePattern("bedwars.resource." + name_key + ".plural");
        return custom == null ? getName(lang) : custom;
    }


    @NotNull
    public Material getMaterial() {
        return material;
    }


    @NotNull
    public Material getBlock() {
        return block;
    }


    @NotNull
    public ChatColor getColor() {
        return color;
    }


    @NotNull
    public String getColoredName() {
        return color + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Resource other = (Resource) obj;
        if (material != other.material)
            return false;

        if (block != other.block)
            return false;

        if (color != other.color)
            return false;

        return name.equalsIgnoreCase(other.name) && plural.equalsIgnoreCase(other.plural);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), plural.toLowerCase(), material, block, color);
    }

    @Override
    public String toString() {
        return "Resource{Name='" + name + "', Plural Name='" + plural + "', Material=" + material + ", Block=" + block + ", Color=" + color + '}';
    }


    public static Resource getByName(@NotNull String name) {
        return name != null ? Resource.BY_NAME.get(name.toLowerCase()) : null;
    }


    @Nullable
    public static Resource getByMaterial(@NotNull Material material) {
        return material != null ? Resource.BY_TYPE.get(material) : null;
    }


    @Nullable
    public static Resource getByBlockMaterial(@NotNull Material material) {
        return material != null && material.isBlock() ? Resource.BY_BLOCK.get(material) : null;
    }


    public static void register(@NotNull Resource resource) {
        Preconditions.checkNotNull(resource, "Cannot register a null resource!");

        String name = resource.name.toLowerCase();
        if (BY_NAME.containsKey(name))
            throw new IllegalArgumentException("Another resource with the same name is already registered!");

        if (BY_TYPE.containsKey(resource.material))
            throw new IllegalArgumentException("Another resource with the same material is already registered!!");

        if (BY_BLOCK.containsKey(resource.block))
            throw new IllegalArgumentException("Another resource with the same block's material is already registered!");

        Resource.BY_NAME.put(name, resource);
        Resource.BY_TYPE.put(resource.material, resource);
        Resource.BY_BLOCK.put(resource.block, resource);
    }


    public static boolean canRegister(@NotNull Resource resource) {
        Preconditions.checkNotNull(resource, "Resource cannot be null!");

        if (BY_NAME.containsKey(resource.name.toLowerCase()))
            return false;

        if (BY_TYPE.containsKey(resource.material))
            return false;

        return !BY_BLOCK.containsKey(resource.block);
    }


    @NotNull
    public static Resource[] values() {
        return Resource.BY_NAME.values().toArray(new Resource[Resource.BY_NAME.size()]);
    }

}