package com.slyvr.bedwars.api.shop.content;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.game.GameMode;
import com.slyvr.bedwars.api.lang.NamesRegistry;
import com.slyvr.bedwars.api.shop.content.data.PurchasableCost;
import com.slyvr.bedwars.api.shop.content.data.PurchasableCosts;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;


public interface TieredPurchasable extends Purchasable {


    @NotNull
    List<PurchasableTier> getTiers();


    @Nullable
    PurchasableTier getTier(int tier);


    int size();


    final class PurchasableTier {

        private final NamesRegistry names;
        private final PurchasableCosts costs;

        public PurchasableTier(@NotNull NamesRegistry names, @NotNull PurchasableCosts costs) {
            Preconditions.checkNotNull(names, "PurchasableTier's name cannot be null!");
            Preconditions.checkNotNull(costs, "PurchasableTier's costs cannot be null!");

            this.names = names;
            this.costs = costs;
        }

        @NotNull
        public NamesRegistry getNames() {
            return names;
        }

        @NotNull
        public PurchasableCosts getCosts() {
            return costs;
        }


        @NotNull
        public PurchasableCost getCost(@NotNull GameMode mode) {
            return costs.getCost(mode);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            PurchasableTier other = (PurchasableTier) obj;
            return names.equals(other.names) && costs.equals(other.costs);
        }

        @Override
        public int hashCode() {
            return Objects.hash(names, costs);
        }

    }

}