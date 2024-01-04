package com.slyvr.bedwars.api.user.wallet;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public final class UserWallet {

    private final Map<UserCurrency, Integer> balances = new HashMap<>();

    public UserWallet() {
    }

    @NotNull
    public Map<UserCurrency, Integer> getBalances() {
        return new HashMap<>(balances);
    }


    public int getBalance(@NotNull UserCurrency currency) {
        return currency != null ? balances.getOrDefault(currency, 0) : 0;
    }


    public void setBalance(@NotNull UserCurrency currency, int balance) {
        if (currency != null && balance >= 0)
            this.balances.put(currency, balance);
    }


    public void incrementBalance(@NotNull UserCurrency currency, int amount) {
        if (currency == null || amount <= 0)
            return;

        Integer old = balances.get(currency);
        this.balances.put(currency, old != null ? old + amount : amount);
    }


    public void decrementBalance(@NotNull UserCurrency currency, int amount) {
        if (currency == null || amount <= 0)
            return;

        Integer old = balances.get(currency);
        if (old != null)
            this.balances.put(currency, Math.max(old - amount, 0));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        UserWallet other = (UserWallet) obj;
        return balances.equals(other.balances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balances);
    }

}