package com.slyvr.bedwars.api.shop.content.data;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.game.GameMode;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;


public final class PurchasableCosts {

    public static final PurchasableCosts EMPTY = new PurchasableCosts(PurchasableCost.FREE);

    private final Map<GameMode, PurchasableCost> costs;
    private final PurchasableCost def;


    public PurchasableCosts(@NotNull Map<GameMode, PurchasableCost> costs, @NotNull PurchasableCost def) {
        Preconditions.checkNotNull(costs, "Costs map cannot be null!");
        Preconditions.checkNotNull(def, "Default cost cannot be null!");

        Map<GameMode, PurchasableCost> costs_map = new HashMap<>(costs.size());
        for (Entry<GameMode, PurchasableCost> entry : costs.entrySet()) {
            GameMode mode = entry.getKey();
            if (mode == null)
                throw new NullPointerException("Cost's mode cannot be null!");

            PurchasableCost cost = entry.getValue();
            if (cost == null)
                throw new NullPointerException("Cost cannot be null!");

            costs_map.put(mode, cost);
        }

        this.def = def;
        this.costs = Collections.unmodifiableMap(costs_map);
    }


    public PurchasableCosts(@NotNull Map<GameMode, PurchasableCost> costs) {
        this(costs, PurchasableCost.FREE);
    }


    public PurchasableCosts(@NotNull PurchasableCost cost) {
        this(Collections.EMPTY_MAP, cost);
    }

    @NotNull
    public Map<GameMode, PurchasableCost> getCosts() {
        return costs;
    }


    @NotNull
    public PurchasableCost getCost(@NotNull GameMode mode) {
        return costs.getOrDefault(mode, def);
    }


    @NotNull
    public PurchasableCost getDefaultCost() {
        return def;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        PurchasableCosts other = (PurchasableCosts) obj;
        return costs.equals(other.costs) && def.equals(other.def);
    }

    @Override
    public int hashCode() {
        return Objects.hash(costs, def);
    }

    @Override
    public String toString() {
        return "PurchasableCosts{Costs=" + costs + ", Default=" + def + '}';
    }

}