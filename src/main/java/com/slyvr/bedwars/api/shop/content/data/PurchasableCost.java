package com.slyvr.bedwars.api.shop.content.data;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.generator.Resource;
import com.slyvr.bedwars.api.lang.Language;
import org.bukkit.util.NumberConversions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;


public final class PurchasableCost {


    public static final PurchasableCost FREE = new PurchasableCost(Resource.FREE, 0);

    private final Resource resource;
    private final int price;


    public PurchasableCost(@NotNull Resource resource, int price) {
        Preconditions.checkNotNull(resource, "Cost's resource cannot be null!");
        Preconditions.checkArgument(price >= 0, "Cost's price must be positive!");

        if (resource == Resource.FREE || price == 0) {
            this.resource = Resource.FREE;
            this.price = 0;
            return;
        }

        this.resource = resource;
        this.price = price;
    }


    @NotNull
    public Resource getResource() {
        return resource;
    }


    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof PurchasableCost))
            return false;

        PurchasableCost other = (PurchasableCost) obj;
        return price == other.price && resource.equals(other.resource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resource, price);
    }

    @Override
    public String toString() {
        return "PurchasableCost{Resource=" + resource + ", Price=" + price + '}';
    }


    @NotNull
    public static String getRepresentingText(@NotNull PurchasableCost cost, @Nullable Language lang) {
        Preconditions.checkNotNull(cost, "Cannot get the representing text of a null cost!");
        return getRepresentingText(cost.getResource(), cost.getPrice(), lang);
    }


    @NotNull
    public static String getColoredRepresentingText(@NotNull PurchasableCost cost, @Nullable Language lang) {
        Preconditions.checkNotNull(cost, "Cannot get the colored representing text of a null cost!");
        return cost.resource.getColor() + getRepresentingText(cost.resource, cost.price, lang);
    }


    @NotNull
    public static String getRepresentingText(@NotNull Resource resource, int price, @Nullable Language lang) {
        Preconditions.checkNotNull(resource, "Cannot get the representing text of a null resource!");
        Preconditions.checkArgument(price >= 0, "Cannot get the representing text of a negative price!");

        if (resource == Resource.FREE || price == 0)
            return Resource.FREE.getName(lang);

        return String.valueOf(price) + ' ' + (price > 1 ? resource.getPluralName(lang) : resource.getName(lang));
    }


    @NotNull
    public static String getColoredRepresentingText(@NotNull Resource resource, int price, @Nullable Language lang) {
        Preconditions.checkNotNull(resource, "Cannot get the representing text of a null resource!");
        return resource.getColor() + getRepresentingText(resource, price, lang);
    }


    @Nullable
    public static String serialize(@NotNull PurchasableCost cost) {
        return cost != null ? String.valueOf(cost.price) + ' ' + cost.resource : null;
    }


    @Nullable
    public static PurchasableCost deserialize(@NotNull String text, @Nullable PurchasableCost def) {
        if (text == null)
            return def;

        String[] data = text.split(" ", 2);
        if (data.length < 2)
            return def;

        Resource resource = Resource.getByName(data[1]);
        if (resource == null)
            return def;

        int price = NumberConversions.toInt(data[0]);
        if (price < 0)
            return def;

        return resource != Resource.FREE && price != 0 ? new PurchasableCost(resource, price) : FREE;
    }


    @Nullable
    public static PurchasableCost deserialize(@NotNull String text) {
        return deserialize(text, null);
    }


}