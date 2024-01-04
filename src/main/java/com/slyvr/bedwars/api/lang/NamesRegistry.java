package com.slyvr.bedwars.api.lang;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public final class NamesRegistry {

    private final Map<Language, String> names;
    private final String def;

    public NamesRegistry(@NotNull Map<Language, String> names, @NotNull String def) {
        Preconditions.checkNotNull(names, "Displayable's names map cannot be null!");
        Preconditions.checkNotNull(def, "Displayable's default name cannot be null!");

        Map<Language, String> names_map = new HashMap<>(names.size());
        for (Entry<Language, String> entry : names.entrySet()) {
            Language lang = entry.getKey();
            if (lang == null)
                throw new NullPointerException("Name's language cannot be null!");

            String name = entry.getValue();
            if (name == null)
                throw new NullPointerException("Name cannot be null!");

            names_map.put(lang, name);
        }

        this.def = def;
        this.names = Collections.unmodifiableMap(names_map);
    }

    public NamesRegistry(@NotNull String def) {
        this(Collections.EMPTY_MAP, def);
    }

    @NotNull
    public Map<Language, String> getNames() {
        return names;
    }

    @NotNull
    public String getName(@NotNull Language lang) {
        return names.getOrDefault(lang, def);
    }

    @NotNull
    public String getDefaultName() {
        return def;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        NamesRegistry other = (NamesRegistry) obj;
        return def.equals(other.def) && names.equals(other.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names, def);
    }

}