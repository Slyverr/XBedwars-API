package com.slyvr.bedwars.api.shop.content.data;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.api.lang.Language;
import com.slyvr.bedwars.utils.ChatUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;


public final class PurchasableDescription {


    public static final PurchasableDescription EMPTY = new PurchasableDescription();

    private final Map<Language, String> descriptions;


    public PurchasableDescription(@NotNull Map<Language, String> descriptions) {
        Preconditions.checkNotNull(descriptions, "Descriptions map cannot be null!");

        Map<Language, String> formatted_descriptions = new HashMap<>(descriptions.size(), 1F);
        for (Entry<Language, String> entry : descriptions.entrySet()) {
            Language lang = entry.getKey();
            if (lang == null)
                throw new NullPointerException("Description's language cannot be null!");

            String desc = entry.getValue();
            if (desc == null)
                throw new NullPointerException("Description cannot be null!");

            formatted_descriptions.put(lang, ChatUtils.format(desc));
        }

        this.descriptions = Collections.unmodifiableMap(formatted_descriptions);
    }


    private PurchasableDescription() {
        this.descriptions = Collections.EMPTY_MAP;
    }


    @NotNull
    public Map<Language, String> getDescriptions() {
        return descriptions;
    }


    @NotNull
    public String getDescription(@NotNull Language lang) {
        return descriptions.getOrDefault(lang, "");
    }


    public boolean isEmpty() {
        return descriptions.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        PurchasableDescription other = (PurchasableDescription) obj;
        return descriptions.equals(other.descriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descriptions);
    }

    @Override
    public String toString() {
        return "PurchasableDescription{Descriptions=" + descriptions + '}';
    }

}