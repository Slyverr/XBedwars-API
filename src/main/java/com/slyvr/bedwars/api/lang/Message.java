package com.slyvr.bedwars.api.lang;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public enum Message {

    ARENA_CREATED("bedwars.arena.modification.undefined.created"),
    ARENA_EXISTS("bedwars.arena.undefined.exists"),
    ARENA_INVALID_BED_BLOCK("bedwars.arena.undefined.invalid.bed_block"),
    ARENA_INVALID_CHEST_BLOCK("bedwars.arena.undefined.invalid.chest_block"),
    ARENA_MISSING("bedwars.arena.undefined.missing"),
    ARENA_MISSING_GAME("bedwars.arena.undefined.missing.game"),
    ARENA_MISSING_GENERATORS("bedwars.arena.undefined.missing.generators"),
    ARENA_MODIFICATION_PREFERENCES_NAME("bedwars.arena.modification.preferences.name"),
    ARENA_MODIFICATION_PREFERENCES_TIME("bedwars.arena.modification.preferences.time"),
    ARENA_MODIFICATION_PRESETS_PHASES("bedwars.arena.modification.presets.phases"),
    ARENA_MODIFICATION_PRESETS_TEAM_RESOURCE_GENERATOR("bedwars.arena.modification.presets.team_resource_generator"),
    ARENA_MODIFICATION_PRESETS_TIERED_RESOURCE_GENERATOR("bedwars.arena.modification.presets.tiered_resource_generator"),
    ARENA_MODIFICATION_REGIONS_MAP("bedwars.arena.modification.regions.map"),
    ARENA_MODIFICATION_REGIONS_WAITING_ROOM("bedwars.arena.modification.regions.waiting_room"),
    ARENA_MODIFICATION_RESOURCE_GENERATOR_ADDED("bedwars.arena.modification.resource_generator.added"),
    ARENA_MODIFICATION_RESOURCE_GENERATOR_REMOVED("bedwars.arena.modification.resource_generator.removed"),
    ARENA_MODIFICATION_RESOURCE_GENERATOR_RETAINED("bedwars.arena.modification.resource_generator.retained"),
    ARENA_MODIFICATION_SETTINGS_DISABLED("bedwars.arena.modification.settings.disabled"),
    ARENA_MODIFICATION_SETTINGS_ENABLED("bedwars.arena.modification.settings.enabled"),
    ARENA_MODIFICATION_SETTINGS_MODE("bedwars.arena.modification.settings.mode"),
    ARENA_MODIFICATION_SPAWNS_BOSSES("bedwars.arena.modification.spawns.bosses"),
    ARENA_MODIFICATION_SPAWNS_SPECTATORS("bedwars.arena.modification.spawns.spectators"),
    ARENA_MODIFICATION_SPAWNS_WAITING_ROOM("bedwars.arena.modification.spawns.waiting_room"),
    ARENA_MODIFICATION_TEAM_BED("bedwars.arena.modification.team.bed"),
    ARENA_MODIFICATION_TEAM_CHEST("bedwars.arena.modification.team.chest"),
    ARENA_MODIFICATION_TEAM_GENERATOR("bedwars.arena.modification.team.generator"),
    ARENA_MODIFICATION_TEAM_SHOP_ITEMS("bedwars.arena.modification.team.shop.items"),
    ARENA_MODIFICATION_TEAM_SHOP_UPGRADES("bedwars.arena.modification.team.shop.upgrades"),
    ARENA_MODIFICATION_TEAM_SPAWN("bedwars.arena.modification.team.spawn"),
    ARENA_OCCUPIED("bedwars.arena.undefined.occupied"),
    ARENA_REMOVED("bedwars.arena.modification.undefined.removed"),
    ARENA_RETAINED("bedwars.arena.modification.undefined.retained"),
    ARENA_SAVED("bedwars.arena.modification.undefined.saved"),
    BEDWARS("bedwars"),
    BED_BREAK("bedwars.game.bed.break"),
    BED_BREAK_OWNED("bedwars.game.bed.break.owned"),
    BED_LOST("bedwars.game.bed.lost"),
    BED_LOST_SUBTITLE("bedwars.game.bed.lost.subtitle"),
    BED_LOST_TITLE("bedwars.game.bed.lost.title"),
    BLOCK_BREAK_RESTRICTED("bedwars.block.break.restricted"),
    BLOCK_CHEST_RESTRICTED("bedwars.block.chest.restricted"),
    BLOCK_PLACE_RESTRICTED("bedwars.block.place.restricted"),
    BLOCK_PLACE_RESTRICTED_HEIGHT_LIMIT("bedwars.block.place.restricted.height_limit"),
    COMMAND_FAILURE_LOBBY_CREATION("bedwars.command.failure.lobby.creation"),
    COMMAND_FAILURE_PLAY_GAME_MISSING("bedwars.command.failure.play.game_missing"),
    COMMAND_FAILURE_SHOUT_WAITING("bedwars.command.failure.shout.waiting"),
    COMMAND_PERMISSION("bedwars.command.permission"),
    COMMAND_USAGE("bedwars.command.usage"),
    FINAL_KILL("bedwars.undefined.final_kill"),
    GAME_ACTION_SHOUT("bedwars.game.action.shout"),
    GAME_END_DEFEAT_TITLE("bedwars.game.end.defeat.title"),
    GAME_END_VICTORY_TITLE("bedwars.game.end.victory.title"),
    GAME_ENTITY_SPAWN("bedwars.game.entity.spawn"),
    GAME_ENTITY_SPAWN_RESTRICTED_LIMIT("bedwars.game.entity.spawn.restricted.limit"),
    GAME_RESOURCE_GENERATOR_UPGRADE("bedwars.game.resource_generator.upgrade"),
    GAME_RESOURCE_GENERATOR_WAITING("bedwars.game.resource_generator.waiting"),
    GAME_SCOREBOARD_PHASE("bedwars.game.scoreboard.phase"),
    GAME_SCOREBOARD_STATISTIC("bedwars.game.scoreboard.statistic"),
    GAME_SCOREBOARD_STATUS_OTHER_TEAM("bedwars.game.scoreboard.status.other_team"),
    GAME_SCOREBOARD_STATUS_PLAYER_TEAM("bedwars.game.scoreboard.status.player_team"),
    GAME_START_MESSAGE("bedwars.game.start.message"),
    GAME_SUMMARY_BEDWARS("bedwars.game.summary.bedwars"),
    GAME_SUMMARY_REWARDS("bedwars.game.summary.rewards"),
    GAME_SUMMARY_REWARDS_EARNINGS("bedwars.game.summary.rewards.earnings"),
    GAME_SUMMARY_REWARDS_EARNINGS_LIST("bedwars.game.summary.rewards.earnings.list"),
    GAME_SUMMARY_REWARDS_LEVEL("bedwars.game.summary.rewards.level"),
    GAME_SUMMARY_REWARDS_LEVEL_UP("bedwars.game.summary.rewards.level_up"),
    GAME_SUMMARY_TOP_PLAYERS_FIRST("bedwars.game.summary.top_players.first"),
    GAME_SUMMARY_TOP_PLAYERS_SECOND("bedwars.game.summary.top_players.second"),
    GAME_SUMMARY_TOP_PLAYERS_THIRD("bedwars.game.summary.top_players.third"),
    GAME_TEAM_ELIMINATION("bedwars.game.team.elimination"),
    INTERACTION_CLICK_TO_REMOVE("bedwars.undefined.interaction.click_to_remove"),
    INTERACTION_CLICK_TO_TELEPORT("bedwars.undefined.interaction.click_to_teleport"),
    INTERACTION_CLICK_TO_VIEW("bedwars.undefined.interaction.click_to_view"),
    INTERACTION_RIGHT_CLICK("bedwars.undefined.interaction.right_click"),
    INVALID_COLOR("bedwars.invalid.undefined.color"),
    INVALID_LANGUAGE("bedwars.invalid.undefined.language"),
    INVALID_MODE("bedwars.invalid.undefined.mode"),
    INVALID_NUMBER("bedwars.invalid.number"),
    INVALID_NUMBER_INDEX("bedwars.invalid.number.index"),
    INVALID_NUMBER_LEVEL("bedwars.invalid.number.level"),
    INVALID_NUMBER_PAGE("bedwars.invalid.number.page"),
    INVALID_NUMBER_PROGRESS("bedwars.invalid.number.progress"),
    INVALID_NUMBER_RADIUS("bedwars.invalid.number.radius"),
    INVALID_NUMBER_RANGE("bedwars.invalid.number.range"),
    INVALID_PRESET_PHASES("bedwars.invalid.preset.phases"),
    INVALID_PRESET_TEAM_GENERATOR("bedwars.invalid.preset.team_generator"),
    INVALID_PRESET_TIERED_GENERATOR("bedwars.invalid.preset.tiered_generator"),
    INVALID_RESOURCE("bedwars.invalid.undefined.resource"),
    ITEMS_LOBBY_DISPLAY_LORE("bedwars.items.lobby.display_lore"),
    ITEMS_LOBBY_DISPLAY_NAME("bedwars.items.lobby.display_name"),
    LOBBY_CREATED("bedwars.lobby.undefined.created"),
    LOBBY_EXISTS("bedwars.lobby.undefined.exists"),
    LOBBY_MISSING("bedwars.lobby.undefined.missing"),
    LOBBY_REMOVED("bedwars.lobby.undefined.removed"),
    LOBBY_SCOREBOARD_COINS("bedwars.lobby.scoreboard.coins"),
    LOBBY_SCOREBOARD_LEVEL("bedwars.lobby.scoreboard.level"),
    LOBBY_SCOREBOARD_PROGRESS("bedwars.lobby.scoreboard.progress"),
    LOBBY_SCOREBOARD_STATS("bedwars.lobby.scoreboard.stats"),
    LOBBY_TELEPORT_CANCELLED("bedwars.lobby.teleport.cancelled"),
    LOBBY_TELEPORT_FAILURE("bedwars.lobby.teleport.failure"),
    LOBBY_TELEPORT_HINT("bedwars.lobby.teleport.hint"),
    LOBBY_TELEPORT_SUCCESS("bedwars.lobby.teleport.success"),
    LOBBY_TELEPORT_WAITING("bedwars.lobby.teleport.waiting"),
    MISSING_ARENAS("bedwars.undefined.missing.arenas"),
    MISSING_LOBBIES("bedwars.undefined.missing.lobbies"),
    MISSING_PLAYER("bedwars.undefined.missing.player"),
    MISSING_PRESETS("bedwars.undefined.missing.presets"),
    PLAYER_CONNECTION_DISCONNECT("bedwars.player.connection.disconnect"),
    PLAYER_CONNECTION_RECONNECT("bedwars.player.connection.reconnect"),
    PLAYER_CONTENT_DROPPED("bedwars.player.content.dropped"),
    PLAYER_DEATH("bedwars.player.death"),
    PLAYER_DEATH_FINAL("bedwars.player.death.final"),
    PLAYER_DEATH_KILLED_BY_ENTITY("bedwars.player.death.killed.entity"),
    PLAYER_DEATH_KILLED_BY_ENTITY_FINAL("bedwars.player.death.killed.entity.final"),
    PLAYER_DEATH_KILLED_BY_PLAYER("bedwars.player.death.killed.player"),
    PLAYER_DEATH_KILLED_BY_PLAYER_FINAL("bedwars.player.death.killed.player.final"),
    PLAYER_DEATH_TITLE("bedwars.player.death.title"),
    PLAYER_DEATH_VOID_FALLEN("bedwars.player.death.void.fallen"),
    PLAYER_DEATH_VOID_FALLEN_FINAL("bedwars.player.death.void.fallen.final"),
    PLAYER_DEATH_VOID_THROWN_BY_ENTITY("bedwars.player.death.void.thrown.entity"),
    PLAYER_DEATH_VOID_THROWN_BY_ENTITY_FINAL("bedwars.player.death.void.thrown.entity.final"),
    PLAYER_DEATH_VOID_THROWN_BY_PLAYER("bedwars.player.death.void.thrown.player"),
    PLAYER_DEATH_VOID_THROWN_BY_PLAYER_FINAL("bedwars.player.death.void.thrown.player.final"),
    PLAYER_ELIMINATION("bedwars.player.elimination"),
    PLAYER_INVENTORY_FULL("bedwars.player.inventory.full"),
    PLAYER_PERK_MAGIC_MILK("bedwars.player.perk.magic_milk"),
    PLAYER_RESPAWN("bedwars.player.respawn"),
    PLAYER_RESPAWN_TITLE("bedwars.player.respawn.title"),
    PLAYER_RESPAWN_WAITING("bedwars.player.respawn.waiting"),
    SHOP_DISPLAY_COST("bedwars.shop.display.cost"),
    SHOP_DISPLAY_COST_TIERED("bedwars.shop.display.cost.tiered"),
    SHOP_DISPLAY_INSUFFICIENT_COST("bedwars.shop.display.insufficient.cost"),
    SHOP_DISPLAY_PURCHASE_POSSIBLE("bedwars.shop.display.purchase_possible"),
    SHOP_DISPLAY_QUICK_BUY_EDITOR_TITLE("bedwars.shop.display.quick_buy.editor.title"),
    SHOP_DISPLAY_QUICK_BUY_EMPTY_SLOT_DESCRIPTION("bedwars.shop.display.quick_buy.empty_slot.description"),
    SHOP_DISPLAY_QUICK_BUY_EMPTY_SLOT_TITLE("bedwars.shop.display.quick_buy.empty_slot.title"),
    SHOP_DISPLAY_QUICK_BUY_INTERACTION_ADD("bedwars.shop.display.quick_buy.interaction.add"),
    SHOP_DISPLAY_QUICK_BUY_INTERACTION_REMOVE("bedwars.shop.display.quick_buy.interaction.remove"),
    SHOP_DISPLAY_QUICK_BUY_TITLE("bedwars.shop.display.quick_buy.title"),
    SHOP_DISPLAY_SEPARATOR_CATEGORIES("bedwars.shop.display.separator.categories"),
    SHOP_DISPLAY_SEPARATOR_ITEMS("bedwars.shop.display.separator.items"),
    SHOP_DISPLAY_SEPARATOR_PURCHASABLE("bedwars.shop.display.separator.purchasable"),
    SHOP_DISPLAY_SEPARATOR_QUEUE("bedwars.shop.display.separator.queue"),
    SHOP_DISPLAY_TIER("bedwars.shop.display.tiered.tier"),
    SHOP_DISPLAY_TIERS_DESCRIPTION("bedwars.shop.display.tiered.description"),
    SHOP_DISPLAY_TRAPS_EMPTY("bedwars.shop.display.traps.empty"),
    SHOP_DISPLAY_TRAPS_EMPTY_DESCRIPTION("bedwars.shop.display.traps.empty.description"),
    SHOP_DISPLAY_TRAPS_NEXT("bedwars.shop.display.traps.next"),
    SHOP_DISPLAY_UNLOCKED("bedwars.shop.display.unlocked"),
    SHOP_DISPLAY_UNLOCKED_TIERED("bedwars.shop.display.unlocked.tiered"),
    SHOP_DISPLAY_UPGRADE_TITLE("bedwars.shop.display.upgrade.title"),
    SHOP_NPC_TITLE_ITEMS("bedwars.shop.npc.title.items"),
    SHOP_NPC_TITLE_UPGRADES("bedwars.shop.npc.title.upgrades"),
    SHOP_PURCHASE_FAILURE_ARMOR_EQUIPPED("bedwars.shop.purchase.failure.armor.equipped"),
    SHOP_PURCHASE_FAILURE_ARMOR_HIGH_TIER("bedwars.shop.purchase.failure.armor.high_tier"),
    SHOP_PURCHASE_FAILURE_INSUFFICIENT_COST("bedwars.shop.purchase.failure.insufficient.cost"),
    SHOP_PURCHASE_FAILURE_ITEM_OWNED("bedwars.shop.purchase.failure.item.owned"),
    SHOP_PURCHASE_FAILURE_ITEM_OWNED_HIGH_TIER("bedwars.shop.purchase.failure.item.owned.high_tier"),
    SHOP_PURCHASE_FAILURE_ITEM_PURCHASED_BEFORE("bedwars.shop.purchase.failure.item.purchased_before"),
    SHOP_PURCHASE_FAILURE_TIER_HIGHEST_UNLOCKED("bedwars.shop.purchase.failure.tier.highest_unlocked"),
    SHOP_PURCHASE_FAILURE_TRAP_LIMIT_REACHED("bedwars.shop.purchase.failure.trap.limit_reached"),
    SHOP_PURCHASE_FAILURE_UPGRADE_PURCHASED_BEFORE("bedwars.shop.purchase.failure.upgrade.purchased_before"),
    SHOP_PURCHASE_SUCCESS("bedwars.shop.purchase.success"),
    TEAM_COLOR_AQUA("bedwars.team_color.aqua"),
    TEAM_COLOR_BLUE("bedwars.team_color.blue"),
    TEAM_COLOR_GRAY("bedwars.team_color.gray"),
    TEAM_COLOR_GREEN("bedwars.team_color.green"),
    TEAM_COLOR_PINK("bedwars.team_color.pink"),
    TEAM_COLOR_RED("bedwars.team_color.red"),
    TEAM_COLOR_WHITE("bedwars.team_color.white"),
    TEAM_COLOR_YELLOW("bedwars.team_color.yellow"),
    TRAP_TRIGGER_ALARM("bedwars.trap.trigger.alarm"),
    TRAP_TRIGGER_ALARM_SUBTITLE("bedwars.trap.trigger.alarm.subtitle"),
    TRAP_TRIGGER_ALARM_TITLE("bedwars.trap.trigger.alarm.title"),
    UNDEFINED("bedwars.undefined"),
    UPDATE("bedwars.update"),
    USER_MODIFICATION_LANGUAGE_CHANGED("bedwars.user.modification.language.changed"),
    USER_MODIFICATION_LANGUAGE_RETAINED("bedwars.user.modification.language.retained"),
    USER_MODIFICATION_LEVEL("bedwars.user.modification.level"),
    USER_MODIFICATION_LEVEL_PROGRESS("bedwars.user.modification.level.progress"),
    WAITING_ROOM_COUNTDOWN("bedwars.waiting_room.message.countdown"),
    WAITING_ROOM_INSUFFICIENT_PLAYERS("bedwars.waiting_room.message.insufficient.players"),
    WAITING_ROOM_INSUFFICIENT_PLAYERS_TITLE("bedwars.waiting_room.message.insufficient.players_title"),
    WAITING_ROOM_JOIN("bedwars.waiting_room.message.join"),
    WAITING_ROOM_QUIT("bedwars.waiting_room.message.quit"),
    WAITING_ROOM_SCOREBOARD_COUNTDOWN("bedwars.waiting_room.scoreboard.countdown"),
    WAITING_ROOM_SCOREBOARD_MAP("bedwars.waiting_room.scoreboard.map"),
    WAITING_ROOM_SCOREBOARD_MODE("bedwars.waiting_room.scoreboard.mode"),
    WAITING_ROOM_SCOREBOARD_PLAYERS_STATUS("bedwars.waiting_room.scoreboard.players.status"),
    WAITING_ROOM_SCOREBOARD_VERSION("bedwars.waiting_room.scoreboard.version"),
    WAITING_ROOM_SCOREBOARD_WAITING("bedwars.waiting_room.scoreboard.waiting");

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