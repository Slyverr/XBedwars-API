package com.slyvr.bedwars.api.user.level;

import com.google.common.base.Preconditions;
import com.slyvr.bedwars.utils.NumberUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public final class UserLevel implements Cloneable {

    private static final Map<Integer, Integer> REQUIRED_PROGRESS = new HashMap<>();
    private static final Map<String, Integer> REQUIRED_PROGRESS_PATTERNS = new HashMap<>();
    private static int default_required_progress;

    private int required;
    private int progress;
    private int level;

    public UserLevel(int level, int progress, int required) {
        Preconditions.checkArgument(level >= 1, "UserLevel's level value must be at least 1!");
        Preconditions.checkArgument(progress >= 0, "UserLevel's progress must be at least 0!");
        Preconditions.checkArgument(required >= 1, "UserLevel's required progress to level-up must be at least 1!");

        this.level = level;
        this.required = required;

        this.setProgress(progress);
    }


    public UserLevel(int level, int progress) {
        this(level, progress, REQUIRED_PROGRESS.getOrDefault(level, default_required_progress));
    }


    public int getLevel() {
        return level;
    }


    public void setLevel(int level) {
        if (level >= 1)
            this.level = level;
    }


    public void setLevel(int level, boolean update) {
        if (level < 1)
            return;

        this.level = level;
        if (update)
            this.required = getLevelUpProgress(level);
    }


    public int getProgress() {
        return progress;
    }


    public void setProgress(int amount) {
        if (amount >= 0)
            this.progress = amount % required;
    }


    @Nullable
    public UserPrestige incrementProgress(int amount, boolean levelUp) {
        if (amount <= 0)
            return null;

        if (!levelUp) {
            this.progress += amount;
            if (progress >= required)
                this.progress = 0;

            return null;
        }

        UserPrestige next = null;

        this.progress += amount;
        while (progress >= required) {
            this.progress -= required;
            this.required = REQUIRED_PROGRESS.getOrDefault(++level, default_required_progress);

            UserPrestige prestige = UserPrestige.getByStartLevel(level);
            if (prestige != null)
                next = prestige;
        }

        this.setProgress(progress);
        return next;
    }


    @Nullable
    public UserPrestige decrementProgress(int amount, boolean levelDown) {
        if (amount <= 0)
            return null;

        if (!levelDown || level == 1 || progress >= amount) {
            this.progress = Math.max(progress - amount, 0);
            return null;
        }

        UserPrestige previous = null;

        this.required = REQUIRED_PROGRESS.get(--level);
        this.progress = amount - progress;

        while (level > 1 && progress >= required) {
            this.required = REQUIRED_PROGRESS.get(--level);
            this.progress -= required;

            UserPrestige prestige = UserPrestige.getByStartLevel(level);
            if (prestige != null)
                previous = prestige;
        }

        this.progress = Math.max(required - progress, 0);
        return previous;
    }


    public int getRequiredToLevelUp() {
        return required;
    }


    public void setRequiredToLevelUp(int amount) {
        if (amount > 0)
            this.required = amount;
    }


    public boolean isLeveling(int amount) {
        return progress + amount >= required;
    }


    public float getProgressPercentage() {
        return (float) progress / required;
    }


    @Nullable
    public String getProgressBar(int length) {
        return UserLevel.getProgressBar(length, this.getProgressPercentage());
    }
    
    @NotNull
    public String getProgressTextWithComma() {
        return ChatColor.AQUA + NumberUtils.formatWithComma(progress) + ChatColor.GRAY + '/' + ChatColor.GREEN + NumberUtils.formatWithComma(required);
    }


    @NotNull
    public String getProgressTextWithUnit() {
        return ChatColor.AQUA + NumberUtils.formatWithUnit(progress) + ChatColor.GRAY + '/' + ChatColor.GREEN + NumberUtils.formatWithUnit(required);
    }


    public void setForPlayer(@NotNull Player player) {
        if (player == null)
            return;

        player.setLevel(level);
        player.setExp((float) progress / required);
    }

    @NotNull
    @Override
    public UserLevel clone() {
        try {
            return (UserLevel) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @NotNull
    public static String getProgressBar(int length, float percentage, @NotNull ChatColor filled, @NotNull ChatColor empty) {
        Preconditions.checkArgument(length >= 10, "ProgressBar's length must be at least 10!");
        Preconditions.checkArgument(percentage >= 0 && percentage <= 1, "ProgressBar's filling percentage must be between 0 and 1!");

        Preconditions.checkNotNull(filled, "Color for filled blocks cannot be null!");
        Preconditions.checkNotNull(empty, "Color for empty blocks cannot be null!");

        int max = (int) (length * percentage);

        StringBuilder builder = new StringBuilder()
                .append(ChatColor.DARK_GRAY)
                .append('[');

        builder.append(filled);
        for (int i = 0; i < max; i++)
            builder.append('■');

        builder.append(empty);
        for (int i = max; i < length; i++)
            builder.append('■');

        builder.append(ChatColor.DARK_GRAY);
        builder.append(']');

        return builder.toString();
    }


    @NotNull
    public static String getProgressBar(int length, float percentage, @NotNull ChatColor filled) {
        return getProgressBar(length, percentage, filled, ChatColor.GRAY);
    }


    @NotNull
    public static String getProgressBar(int length, float percentage) {
        return getProgressBar(length, percentage, ChatColor.AQUA);
    }


    public static int getDefaultLevelUpProgress() {
        return default_required_progress;
    }


    public static void setDefaultLevelUpProgress(int amount) {
        if (amount >= 1)
            UserLevel.default_required_progress = amount;
    }


    public static int getLevelUpProgress(int level) {
        Integer progress = REQUIRED_PROGRESS.get(level);
        if (progress != null)
            return progress;

        String level_text = String.valueOf(level);
        for (Entry<String, Integer> entry : REQUIRED_PROGRESS_PATTERNS.entrySet()) {
            if (entry.getKey().endsWith(level_text))
                return entry.getValue();
        }

        return default_required_progress;
    }


    public static void setLevelUpProgress(int level, int amount) {
        Preconditions.checkArgument(level >= 1, "Level value must be at least 1!");
        Preconditions.checkArgument(amount >= 1, "Level's required progress to level-up must be at least 1!");

        UserLevel.REQUIRED_PROGRESS.put(level, amount);
    }

    public static void setLevelUpProgressPattern(int level, int amount) {
        Preconditions.checkArgument(level >= 0, "Level value must be at least 1!");
        Preconditions.checkArgument(amount >= 1, "Level's required progress to level-up must be at least 1!");

        UserLevel.REQUIRED_PROGRESS_PATTERNS.put(String.valueOf(level), amount);
    }

}