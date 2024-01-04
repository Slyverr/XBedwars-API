package com.slyvr.bedwars.api.shop.items.type;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.shop.content.TieredPurchasable;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public interface TieredPurchasableItem extends TieredPurchasable {


    @NotNull
    TieredItemStack getItem();


    final class TieredItemStack {

        private final List<ItemStack> tiers;

        public TieredItemStack(@NotNull List<ItemStack> tiers) {
            Preconditions.checkNotNull(tiers, "TieredItem's tiers list cannot be null!");
            Preconditions.checkArgument(!tiers.isEmpty(), "TieredItem's tiers list cannot be empty!");

            List<ItemStack> tiers_list = new ArrayList<>(tiers.size());
            for (ItemStack item : tiers) {
                if (item == null)
                    throw new IllegalArgumentException("TieredItem's tier cannot be null!");

                if (item.getType().isBlock())
                    throw new IllegalArgumentException("TieredItem's tier cannot be block!");

                tiers_list.add(item.clone());
            }

            this.tiers = Collections.unmodifiableList(tiers_list);
        }


        @NotNull
        public List<ItemStack> getTiers() {
            return tiers;
        }


        @Nullable
        public ItemStack getTier(int tier) {
            return tier >= 1 && tier <= tiers.size() ? tiers.get(tier - 1) : null;
        }


        public int getMaximumTier() {
            return tiers.size();
        }


        public boolean contains(@NotNull Material type) {
            if (type == null)
                return false;

            for (ItemStack item : tiers) {
                if (item.getType() == type)
                    return true;
            }

            return false;
        }


        public boolean contains(@NotNull ItemStack item) {
            if (item == null)
                return false;

            for (ItemStack tier : tiers) {
                if (tier.equals(item))
                    return true;
            }

            return false;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            TieredItemStack other = (TieredItemStack) obj;
            return tiers.equals(other.tiers);
        }

        @Override
        public int hashCode() {
            return Objects.hash(tiers);
        }

    }

}