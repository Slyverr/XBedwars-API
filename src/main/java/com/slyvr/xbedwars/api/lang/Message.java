package com.slyvr.xbedwars.api.lang;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public enum Message {

    ARENA_CREATED("xbedwars.arena.modification.undefined.created"),
    ARENA_EXISTS("xbedwars.arena.undefined.exists"),
    ARENA_INVALID_BED_BLOCK("xbedwars.arena.undefined.invalid.bed_block"),
    ARENA_INVALID_CHEST_BLOCK("xbedwars.arena.undefined.invalid.chest_block"),
    ARENA_MISSING("xbedwars.arena.undefined.missing"),
    ARENA_MISSING_GAME("xbedwars.arena.undefined.missing.game"),
    ARENA_MISSING_GENERATORS("xbedwars.arena.undefined.missing.generators"),
    ARENA_MODIFICATION_PREFERENCES_NAME("xbedwars.arena.modification.preferences.name"),
    ARENA_MODIFICATION_PREFERENCES_TIME("xbedwars.arena.modification.preferences.time"),
    ARENA_MODIFICATION_PRESETS_PHASES("xbedwars.arena.modification.presets.phases"),
    ARENA_MODIFICATION_PRESETS_TEAM_RESOURCE_GENERATOR("xbedwars.arena.modification.presets.team_resource_generator"),
    ARENA_MODIFICATION_PRESETS_TIERED_RESOURCE_GENERATOR("xbedwars.arena.modification.presets.tiered_resource_generator"),
    ARENA_MODIFICATION_REGIONS_MAP("xbedwars.arena.modification.regions.map"),
    ARENA_MODIFICATION_REGIONS_WAITING_ROOM("xbedwars.arena.modification.regions.waiting_room"),
    ARENA_MODIFICATION_RESOURCE_GENERATOR_ADDED("xbedwars.arena.modification.resource_generator.added"),
    ARENA_MODIFICATION_RESOURCE_GENERATOR_REMOVED("xbedwars.arena.modification.resource_generator.removed"),
    ARENA_MODIFICATION_RESOURCE_GENERATOR_RETAINED("xbedwars.arena.modification.resource_generator.retained"),
    ARENA_MODIFICATION_SETTINGS_DISABLED("xbedwars.arena.modification.settings.disabled"),
    ARENA_MODIFICATION_SETTINGS_ENABLED("xbedwars.arena.modification.settings.enabled"),
    ARENA_MODIFICATION_SETTINGS_MODE("xbedwars.arena.modification.settings.mode"),
    ARENA_MODIFICATION_SPAWNS_BOSSES("xbedwars.arena.modification.spawns.bosses"),
    ARENA_MODIFICATION_SPAWNS_SPECTATORS("xbedwars.arena.modification.spawns.spectators"),
    ARENA_MODIFICATION_SPAWNS_WAITING_ROOM("xbedwars.arena.modification.spawns.waiting_room"),
    ARENA_MODIFICATION_TEAM_BED("xbedwars.arena.modification.team.bed"),
    ARENA_MODIFICATION_TEAM_CHEST("xbedwars.arena.modification.team.chest"),
    ARENA_MODIFICATION_TEAM_GENERATOR("xbedwars.arena.modification.team.generator"),
    ARENA_MODIFICATION_TEAM_SHOP_ITEMS("xbedwars.arena.modification.team.shop.items"),
    ARENA_MODIFICATION_TEAM_SHOP_UPGRADES("xbedwars.arena.modification.team.shop.upgrades"),
    ARENA_MODIFICATION_TEAM_SPAWN("xbedwars.arena.modification.team.spawn"),
    ARENA_OCCUPIED("xbedwars.arena.undefined.occupied"),
    ARENA_REMOVED("xbedwars.arena.modification.undefined.removed"),
    ARENA_RETAINED("xbedwars.arena.modification.undefined.retained"),
    ARENA_SAVED("xbedwars.arena.modification.undefined.saved"),
    BEDWARS("bedwars"),
    BED_BREAK("xbedwars.game.bed.break"),
    BED_BREAK_OWNED("xbedwars.game.bed.break.owned"),
    BED_LOST("xbedwars.game.bed.lost"),
    BED_LOST_SUBTITLE("xbedwars.game.bed.lost.subtitle"),
    BED_LOST_TITLE("xbedwars.game.bed.lost.title"),
    BLOCK_BREAK_RESTRICTED("xbedwars.block.break.restricted"),
    BLOCK_CHEST_RESTRICTED("xbedwars.block.chest.restricted"),
    BLOCK_PLACE_RESTRICTED("xbedwars.block.place.restricted"),
    BLOCK_PLACE_RESTRICTED_HEIGHT_LIMIT("xbedwars.block.place.restricted.height_limit"),
    COMMAND_FAILURE_LOBBY_CREATION("xbedwars.command.failure.lobby.creation"),
    COMMAND_FAILURE_PLAY_GAME_MISSING("xbedwars.command.failure.play.game_missing"),
    COMMAND_FAILURE_SHOUT_WAITING("xbedwars.command.failure.shout.waiting"),
    COMMAND_PERMISSION("xbedwars.command.permission"),
    COMMAND_USAGE("xbedwars.command.usage"),
    FINAL_KILL("xbedwars.undefined.final_kill"),
    GAME_ACTION_SHOUT("xbedwars.game.action.shout"),
    GAME_END_DEFEAT_TITLE("xbedwars.game.end.defeat.title"),
    GAME_END_VICTORY_TITLE("xbedwars.game.end.victory.title"),
    GAME_ENTITY_SPAWN("xbedwars.game.entity.spawn"),
    GAME_ENTITY_SPAWN_RESTRICTED_LIMIT("xbedwars.game.entity.spawn.restricted.limit"),
    GAME_RESOURCE_GENERATOR_UPGRADE("xbedwars.game.resource_generator.upgrade"),
    GAME_RESOURCE_GENERATOR_WAITING("xbedwars.game.resource_generator.waiting"),
    GAME_SCOREBOARD_PHASE("xbedwars.game.scoreboard.phase"),
    GAME_SCOREBOARD_STATISTIC("xbedwars.game.scoreboard.statistic"),
    GAME_SCOREBOARD_STATUS_OTHER_TEAM("xbedwars.game.scoreboard.status.other_team"),
    GAME_SCOREBOARD_STATUS_PLAYER_TEAM("xbedwars.game.scoreboard.status.player_team"),
    GAME_START_MESSAGE("xbedwars.game.start.message"),
    GAME_SUMMARY_xbedwars("xbedwars.game.summary.xbedwars"),
    GAME_SUMMARY_REWARDS("xbedwars.game.summary.rewards"),
    GAME_SUMMARY_REWARDS_EARNINGS("xbedwars.game.summary.rewards.earnings"),
    GAME_SUMMARY_REWARDS_EARNINGS_LIST("xbedwars.game.summary.rewards.earnings.list"),
    GAME_SUMMARY_REWARDS_LEVEL("xbedwars.game.summary.rewards.level"),
    GAME_SUMMARY_REWARDS_LEVEL_UP("xbedwars.game.summary.rewards.level_up"),
    GAME_SUMMARY_TOP_PLAYERS_FIRST("xbedwars.game.summary.top_players.first"),
    GAME_SUMMARY_TOP_PLAYERS_SECOND("xbedwars.game.summary.top_players.second"),
    GAME_SUMMARY_TOP_PLAYERS_THIRD("xbedwars.game.summary.top_players.third"),
    GAME_TEAM_ELIMINATION("xbedwars.game.team.elimination"),
    INTERACTION_CLICK_TO_REMOVE("xbedwars.undefined.interaction.click_to_remove"),
    INTERACTION_CLICK_TO_TELEPORT("xbedwars.undefined.interaction.click_to_teleport"),
    INTERACTION_CLICK_TO_VIEW("xbedwars.undefined.interaction.click_to_view"),
    INTERACTION_RIGHT_CLICK("xbedwars.undefined.interaction.right_click"),
    INVALID_COLOR("xbedwars.invalid.undefined.color"),
    INVALID_LANGUAGE("xbedwars.invalid.undefined.language"),
    INVALID_MODE("xbedwars.invalid.undefined.mode"),
    INVALID_NUMBER("xbedwars.invalid.number"),
    INVALID_NUMBER_INDEX("xbedwars.invalid.number.index"),
    INVALID_NUMBER_LEVEL("xbedwars.invalid.number.level"),
    INVALID_NUMBER_PAGE("xbedwars.invalid.number.page"),
    INVALID_NUMBER_PROGRESS("xbedwars.invalid.number.progress"),
    INVALID_NUMBER_RADIUS("xbedwars.invalid.number.radius"),
    INVALID_NUMBER_RANGE("xbedwars.invalid.number.range"),
    INVALID_PRESET_PHASES("xbedwars.invalid.preset.phases"),
    INVALID_PRESET_TEAM_GENERATOR("xbedwars.invalid.preset.team_generator"),
    INVALID_PRESET_TIERED_GENERATOR("xbedwars.invalid.preset.tiered_generator"),
    INVALID_RESOURCE("xbedwars.invalid.undefined.resource"),
    ITEMS_LOBBY_DISPLAY_LORE("xbedwars.items.lobby.display_lore"),
    ITEMS_LOBBY_DISPLAY_NAME("xbedwars.items.lobby.display_name"),
    LOBBY_CREATED("xbedwars.lobby.undefined.created"),
    LOBBY_EXISTS("xbedwars.lobby.undefined.exists"),
    LOBBY_MISSING("xbedwars.lobby.undefined.missing"),
    LOBBY_REMOVED("xbedwars.lobby.undefined.removed"),
    LOBBY_SCOREBOARD_COINS("xbedwars.lobby.scoreboard.coins"),
    LOBBY_SCOREBOARD_LEVEL("xbedwars.lobby.scoreboard.level"),
    LOBBY_SCOREBOARD_PROGRESS("xbedwars.lobby.scoreboard.progress"),
    LOBBY_SCOREBOARD_STATS("xbedwars.lobby.scoreboard.stats"),
    LOBBY_TELEPORT_CANCELLED("xbedwars.lobby.teleport.cancelled"),
    LOBBY_TELEPORT_FAILURE("xbedwars.lobby.teleport.failure"),
    LOBBY_TELEPORT_HINT("xbedwars.lobby.teleport.hint"),
    LOBBY_TELEPORT_SUCCESS("xbedwars.lobby.teleport.success"),
    LOBBY_TELEPORT_WAITING("xbedwars.lobby.teleport.waiting"),
    MISSING_ARENAS("xbedwars.undefined.missing.arenas"),
    MISSING_LOBBIES("xbedwars.undefined.missing.lobbies"),
    MISSING_PLAYER("xbedwars.undefined.missing.player"),
    MISSING_PRESETS("xbedwars.undefined.missing.presets"),
    PLAYER_CONNECTION_DISCONNECT("xbedwars.player.connection.disconnect"),
    PLAYER_CONNECTION_RECONNECT("xbedwars.player.connection.reconnect"),
    PLAYER_CONTENT_DROPPED("xbedwars.player.content.dropped"),
    PLAYER_DEATH("xbedwars.player.death"),
    PLAYER_DEATH_FINAL("xbedwars.player.death.final"),
    PLAYER_DEATH_KILLED_BY_ENTITY("xbedwars.player.death.killed.entity"),
    PLAYER_DEATH_KILLED_BY_ENTITY_FINAL("xbedwars.player.death.killed.entity.final"),
    PLAYER_DEATH_KILLED_BY_PLAYER("xbedwars.player.death.killed.player"),
    PLAYER_DEATH_KILLED_BY_PLAYER_FINAL("xbedwars.player.death.killed.player.final"),
    PLAYER_DEATH_TITLE("xbedwars.player.death.title"),
    PLAYER_DEATH_VOID_FALLEN("xbedwars.player.death.void.fallen"),
    PLAYER_DEATH_VOID_FALLEN_FINAL("xbedwars.player.death.void.fallen.final"),
    PLAYER_DEATH_VOID_THROWN_BY_ENTITY("xbedwars.player.death.void.thrown.entity"),
    PLAYER_DEATH_VOID_THROWN_BY_ENTITY_FINAL("xbedwars.player.death.void.thrown.entity.final"),
    PLAYER_DEATH_VOID_THROWN_BY_PLAYER("xbedwars.player.death.void.thrown.player"),
    PLAYER_DEATH_VOID_THROWN_BY_PLAYER_FINAL("xbedwars.player.death.void.thrown.player.final"),
    PLAYER_ELIMINATION("xbedwars.player.elimination"),
    PLAYER_INVENTORY_FULL("xbedwars.player.inventory.full"),
    PLAYER_PERK_MAGIC_MILK("xbedwars.player.perk.magic_milk"),
    PLAYER_RESPAWN("xbedwars.player.respawn"),
    PLAYER_RESPAWN_TITLE("xbedwars.player.respawn.title"),
    PLAYER_RESPAWN_WAITING("xbedwars.player.respawn.waiting"),
    SHOP_DISPLAY_COST("xbedwars.shop.display.cost"),
    SHOP_DISPLAY_COST_TIERED("xbedwars.shop.display.cost.tiered"),
    SHOP_DISPLAY_INSUFFICIENT_COST("xbedwars.shop.display.insufficient.cost"),
    SHOP_DISPLAY_PURCHASE_POSSIBLE("xbedwars.shop.display.purchase_possible"),
    SHOP_DISPLAY_QUICK_BUY_EDITOR_TITLE("xbedwars.shop.display.quick_buy.editor.title"),
    SHOP_DISPLAY_QUICK_BUY_EMPTY_SLOT_DESCRIPTION("xbedwars.shop.display.quick_buy.empty_slot.description"),
    SHOP_DISPLAY_QUICK_BUY_EMPTY_SLOT_TITLE("xbedwars.shop.display.quick_buy.empty_slot.title"),
    SHOP_DISPLAY_QUICK_BUY_INTERACTION_ADD("xbedwars.shop.display.quick_buy.interaction.add"),
    SHOP_DISPLAY_QUICK_BUY_INTERACTION_REMOVE("xbedwars.shop.display.quick_buy.interaction.remove"),
    SHOP_DISPLAY_QUICK_BUY_TITLE("xbedwars.shop.display.quick_buy.title"),
    SHOP_DISPLAY_SEPARATOR_CATEGORIES("xbedwars.shop.display.separator.categories"),
    SHOP_DISPLAY_SEPARATOR_ITEMS("xbedwars.shop.display.separator.items"),
    SHOP_DISPLAY_SEPARATOR_PURCHASABLE("xbedwars.shop.display.separator.purchasable"),
    SHOP_DISPLAY_SEPARATOR_QUEUE("xbedwars.shop.display.separator.queue"),
    SHOP_DISPLAY_TIER("xbedwars.shop.display.tiered.tier"),
    SHOP_DISPLAY_TIERS_DESCRIPTION("xbedwars.shop.display.tiered.description"),
    SHOP_DISPLAY_TRAPS_EMPTY("xbedwars.shop.display.traps.empty"),
    SHOP_DISPLAY_TRAPS_EMPTY_DESCRIPTION("xbedwars.shop.display.traps.empty.description"),
    SHOP_DISPLAY_TRAPS_NEXT("xbedwars.shop.display.traps.next"),
    SHOP_DISPLAY_UNLOCKED("xbedwars.shop.display.unlocked"),
    SHOP_DISPLAY_UNLOCKED_TIERED("xbedwars.shop.display.unlocked.tiered"),
    SHOP_DISPLAY_UPGRADE_TITLE("xbedwars.shop.display.upgrade.title"),
    SHOP_NPC_TITLE_ITEMS("xbedwars.shop.npc.title.items"),
    SHOP_NPC_TITLE_UPGRADES("xbedwars.shop.npc.title.upgrades"),
    SHOP_PURCHASE_FAILURE_ARMOR_EQUIPPED("xbedwars.shop.purchase.failure.armor.equipped"),
    SHOP_PURCHASE_FAILURE_ARMOR_HIGH_TIER("xbedwars.shop.purchase.failure.armor.high_tier"),
    SHOP_PURCHASE_FAILURE_INSUFFICIENT_COST("xbedwars.shop.purchase.failure.insufficient.cost"),
    SHOP_PURCHASE_FAILURE_ITEM_OWNED("xbedwars.shop.purchase.failure.item.owned"),
    SHOP_PURCHASE_FAILURE_ITEM_OWNED_HIGH_TIER("xbedwars.shop.purchase.failure.item.owned.high_tier"),
    SHOP_PURCHASE_FAILURE_ITEM_PURCHASED_BEFORE("xbedwars.shop.purchase.failure.item.purchased_before"),
    SHOP_PURCHASE_FAILURE_TIER_HIGHEST_UNLOCKED("xbedwars.shop.purchase.failure.tier.highest_unlocked"),
    SHOP_PURCHASE_FAILURE_TRAP_LIMIT_REACHED("xbedwars.shop.purchase.failure.trap.limit_reached"),
    SHOP_PURCHASE_FAILURE_UPGRADE_PURCHASED_BEFORE("xbedwars.shop.purchase.failure.upgrade.purchased_before"),
    SHOP_PURCHASE_SUCCESS("xbedwars.shop.purchase.success"),
    TEAM_COLOR_AQUA("xbedwars.team_color.aqua"),
    TEAM_COLOR_BLUE("xbedwars.team_color.blue"),
    TEAM_COLOR_GRAY("xbedwars.team_color.gray"),
    TEAM_COLOR_GREEN("xbedwars.team_color.green"),
    TEAM_COLOR_PINK("xbedwars.team_color.pink"),
    TEAM_COLOR_RED("xbedwars.team_color.red"),
    TEAM_COLOR_WHITE("xbedwars.team_color.white"),
    TEAM_COLOR_YELLOW("xbedwars.team_color.yellow"),
    TRAP_TRIGGER_ALARM("xbedwars.trap.trigger.alarm"),
    TRAP_TRIGGER_ALARM_SUBTITLE("xbedwars.trap.trigger.alarm.subtitle"),
    TRAP_TRIGGER_ALARM_TITLE("xbedwars.trap.trigger.alarm.title"),
    UNDEFINED("xbedwars.undefined"),
    UPDATE("xbedwars.update"),
    USER_MODIFICATION_LANGUAGE_CHANGED("xbedwars.user.modification.language.changed"),
    USER_MODIFICATION_LANGUAGE_RETAINED("xbedwars.user.modification.language.retained"),
    USER_MODIFICATION_LEVEL("xbedwars.user.modification.level"),
    USER_MODIFICATION_LEVEL_PROGRESS("xbedwars.user.modification.level.progress"),
    WAITING_ROOM_COUNTDOWN("xbedwars.waiting_room.message.countdown"),
    WAITING_ROOM_INSUFFICIENT_PLAYERS("xbedwars.waiting_room.message.insufficient.players"),
    WAITING_ROOM_INSUFFICIENT_PLAYERS_TITLE("xbedwars.waiting_room.message.insufficient.players_title"),
    WAITING_ROOM_JOIN("xbedwars.waiting_room.message.join"),
    WAITING_ROOM_QUIT("xbedwars.waiting_room.message.quit"),
    WAITING_ROOM_SCOREBOARD_COUNTDOWN("xbedwars.waiting_room.scoreboard.countdown"),
    WAITING_ROOM_SCOREBOARD_MAP("xbedwars.waiting_room.scoreboard.map"),
    WAITING_ROOM_SCOREBOARD_MODE("xbedwars.waiting_room.scoreboard.mode"),
    WAITING_ROOM_SCOREBOARD_PLAYERS_STATUS("xbedwars.waiting_room.scoreboard.players.status"),
    WAITING_ROOM_SCOREBOARD_VERSION("xbedwars.waiting_room.scoreboard.version"),
    WAITING_ROOM_SCOREBOARD_WAITING("xbedwars.waiting_room.scoreboard.waiting");

    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\{([0-9]+)}");

    private final String key;

    Message(@NotNull String key) {
        this.key = key;
    }

    @NotNull
    public String getMessagePatternKey() {
        return key;
    }

    @Nullable
    public String format(@NotNull Language lang, Object... args) {
        return lang != null ? lang.format(this, args) : null;
    }

    @Nullable
    public static String format(@NotNull String pattern, Object... args) {
        if (pattern == null)
            return null;

        Matcher matcher = PLACEHOLDER_PATTERN.matcher(pattern);
        StringBuffer buffer = new StringBuffer(pattern.length() + 16);

        while (matcher.find()) {
            int index = Integer.parseInt(matcher.group(1));
            if (index >= 0 && index < args.length)
                matcher.appendReplacement(buffer, String.valueOf(args[index]));
            else
                matcher.appendReplacement(buffer, matcher.group());
        }

        matcher.appendTail(buffer);
        return buffer.toString();
    }

}