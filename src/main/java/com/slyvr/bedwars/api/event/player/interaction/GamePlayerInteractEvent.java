package com.slyvr.bedwars.api.event.player.interaction;

import com.slyvr.bedwars.api.event.player.GamePlayerEvent;
import com.slyvr.bedwars.api.player.GamePlayer;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class GamePlayerInteractEvent extends GamePlayerEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Action action;
    private final ItemStack item;
    private final EquipmentSlot hand;

    private final Block block;
    private final BlockFace face;

    private Result useItemInHand;
    private Result useClickedBlock;


    public GamePlayerInteractEvent(@NotNull GamePlayer player, @NotNull Action action, @Nullable ItemStack item, @Nullable EquipmentSlot hand, @Nullable Block block, @Nullable BlockFace face) {
        super(player);

        this.item = item;
        this.hand = hand;
        this.action = action;
        this.block = block;
        this.face = face;

        this.useItemInHand = Result.DEFAULT;
        this.useClickedBlock = Result.DEFAULT;
    }

    public GamePlayerInteractEvent(@NotNull GamePlayer player, @NotNull Action action, @Nullable ItemStack item, @Nullable Block block, @Nullable BlockFace face) {
        this(player, action, item, null, block, face);
    }


    @NotNull
    public Action getAction() {
        return action;
    }


    @Nullable
    public ItemStack getItem() {
        return item;
    }


    @NotNull
    public Material getMaterial() {
        return item == null ? Material.AIR : item.getType();
    }


    public boolean hasItem() {
        return this.item != null;
    }


    @NotNull
    public Result useItemInHand() {
        return useItemInHand;
    }


    public void setUseItemInHand(@NotNull Result action) {
        if (action != null)
            this.useItemInHand = action;
    }


    @Nullable
    public Block getClickedBlock() {
        return block;
    }


    @Nullable
    public BlockFace getBlockFace() {
        return face;
    }


    @NotNull
    public Result useClickedBlock() {
        return useClickedBlock;
    }


    public void setUseClickedBlock(@NotNull Result action) {
        if (action != null)
            this.useClickedBlock = action;
    }


    @Nullable
    public EquipmentSlot getHand() {
        return hand;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}