package nl.sugcube.crystalquest.game;

import nl.sugcube.crystalquest.Broadcast;
import nl.sugcube.crystalquest.CrystalQuest;
import nl.sugcube.crystalquest.Teams;
import nl.sugcube.crystalquest.economy.Multipliers;
import nl.sugcube.crystalquest.events.ArenaTickEvent;
import nl.sugcube.crystalquest.items.WandType;
import org.bukkit.Bukkit;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;
import java.util.UUID;

/**
 * @author SugarCaney
 */
public class GameLoop implements Runnable {

    public CrystalQuest plugin;
    public ArenaManager am;
    public Random ran;
    private String winningTeam;

    public GameLoop(CrystalQuest instance, ArenaManager arenaManager) {
        this.plugin = instance;
        this.am = arenaManager;
        this.ran = new Random();
    }

    private void doCountdown(Arena arena) {
        ArenaTickEvent event = new ArenaTickEvent(arena, arena.getCountdown(), arena.getCountdown() - 1, false);
        Bukkit.getPluginManager().callEvent(event);

        for (UUID id : arena.getPlayers()) {
            Player pl = Bukkit.getPlayer(id);
            pl.setLevel(arena.getCountdown());
        }

        if (arena.getCountdown() == 120) {
            for (UUID id : arena.getPlayers()) {
                Player pl = Bukkit.getPlayer(id);
                pl.sendMessage(Broadcast.TAG + Broadcast.get("arena.start")
                        .replace("%time%", "2 " + Broadcast.get("arena.minutes")));
            }
        }
        else if (arena.getCountdown() == 60) {
            for (UUID id : arena.getPlayers()) {
                Player pl = Bukkit.getPlayer(id);
                pl.sendMessage(Broadcast.TAG + Broadcast.get("arena.start")
                        .replace("%time%", "1 " + Broadcast.get("arena.minute")));
            }
        }
        else if (arena.getCountdown() == 30) {
            for (UUID id : arena.getPlayers()) {
                Player pl = Bukkit.getPlayer(id);
                pl.sendMessage(Broadcast.TAG + Broadcast.get("arena.start")
                        .replace("%time%", "30 " + Broadcast.get("arena.seconds")));
            }
        }
        else if (arena.getCountdown() == 10) {
            for (UUID id : arena.getPlayers()) {
                Player pl = Bukkit.getPlayer(id);
                pl.sendMessage(Broadcast.TAG + Broadcast.get("arena.start")
                        .replace("%time%", "10 " + Broadcast.get("arena.seconds")));
            }
        }
        else if (arena.getCountdown() <= 5 && arena.getCountdown() > 0) {
            for (UUID id : arena.getPlayers()) {
                Player pl = Bukkit.getPlayer(id);
                pl.sendMessage(Broadcast.TAG + Broadcast.get("arena.start")
                        .replace("%time%", arena.getCountdown() + " " + Broadcast.get("arena.seconds")));
                pl.playSound(pl.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 20F, 20F);
            }
        }
        else if (arena.getCountdown() <= 0) {
            arena.setIsCounting(false);
            arena.setCountdown(plugin.getConfig().getInt("arena.countdown") + 1);
            arena.startGame();
        }

        arena.setCountdown(arena.getCountdown() - 1);
    }

    private void doGameLoop(Arena arena) {
        if (arena.getTimeLeft() > 0) {
            ArenaTickEvent event = new ArenaTickEvent(arena, arena.getTimeLeft(), arena.getTimeLeft() - 1, true);
            Bukkit.getPluginManager().callEvent(event);

            for (UUID id : arena.getPlayers()) {
                Player player = Bukkit.getPlayer(id);
                if (arena.getTimeLeft() % 10 == 0) {
                    player.setFoodLevel(20);
                    player.setSaturation(4);
                }

                // Remove items from inventory.
                for (ItemStack is : player.getInventory().getContents()) {
                    if (is != null) {
                        if (is.getType() == Material.GLASS_BOTTLE) {
                            player.getInventory().remove(is);
                        }
                        if (is.hasItemMeta()) {
                            if (is.getItemMeta().hasDisplayName()) {
                                if (is.getItemMeta().getDisplayName()
                                        .equalsIgnoreCase(Broadcast.get("items.crystal-shard"))) {
                                    player.getInventory().remove(is);
                                }
                                else if (is.getItemMeta().getDisplayName()
                                        .equalsIgnoreCase(Broadcast.get("items.small-crystal"))) {
                                    player.getInventory().remove(is);
                                }
                                else if (is.getItemMeta().getDisplayName()
                                        .equalsIgnoreCase(Broadcast.get("items.shiny-crystal"))) {
                                    player.getInventory().remove(is);
                                }
                            }
                        }
                    }
                }

                // Check out of bounds: kill
                if (!plugin.prot.isInProtectedArenaIgnoreY(player.getLocation())) {
                    if (player.getHealth() > 0) {
                        player.setHealth(0);
                    }
                }

                // Check XP
                if (player.getLevel() > 0) {
                    int extraPoints = (int)Multipliers.getMultiplier("xp",
                            plugin.economy.getLevel(player, "xp", "crystals"), false) - 1;

                    arena.addScore(plugin.getArenaManager().getTeam(player), player.getLevel() + extraPoints);
                    player.setLevel(0);
                }

                // Wands
                for (ItemStack is : player.getInventory().getContents()) {
                    if (plugin.wand.getWandType(is) != null) {
                        if (is.getDurability() != 0) {
                            double multiplier = 1;
                            if (plugin.ab.getAbilities().containsKey(player.getUniqueId())) {
                                if (plugin.ab.getAbilities().get(player.getUniqueId()).contains("magical_aura")) {
                                    multiplier = 2.1;
                                }
                                else if (plugin.ab.getAbilities().get(player.getUniqueId()).contains("power_loss")) {
                                    multiplier = 0.6;
                                }
                            }
                            else {
                                multiplier = 1;
                            }

                            WandType type = plugin.wand.getWandType(is);
                            short addedDura = (short)(type.getDurability() / plugin.getConfig().getInt(type.getRegenConfig()) * multiplier);
                            short newDura;
                            if (is.getDurability() - addedDura < 0) {
                                newDura = 0;
                            }
                            else {
                                newDura = (short)(is.getDurability() - addedDura);
                            }
                            is.setDurability(newDura);
                        }
                    }
                }
            }

            arena.setTimeLeft(arena.getTimeLeft() - 1);
            arena.updateTimer();
        }
        else {
            try {
                this.winningTeam = arena.declareWinner();
                arena.setAfterCount(plugin.getConfig().getInt("arena.after-count"));
                arena.setEndGame(true);
                arena.setIsCounting(false);
                arena.setTimeLeft(plugin.getConfig().getInt("arena.game-length"));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void doEndGame(Arena arena) {
        if (arena.getAfterCount() <= 0) {
            arena.setEndGame(false);
            arena.resetArena(false);
            plugin.signHandler.updateSigns();
        }
        else {
            arena.setAfterCount(arena.getAfterCount() - 1);

            for (UUID id : arena.getPlayers()) {
                Player p = Bukkit.getPlayer(id);
                try {
                    if (!arena.getSpectators().contains(p.getUniqueId())) {
                        if (arena.getTeam(p) == Teams.getTeamIdFromNAME(this.winningTeam)) {
                            Firework f = p.getLocation().getWorld().spawn(p.getLocation().add(0, 2, 0), Firework.class);
                            FireworkMeta fm = f.getFireworkMeta();
                            fm.setPower(1);
                            FireworkEffect fe = FireworkEffect.builder()
                                    .flicker(true)
                                    .withColor(plugin.im.getTeamColour(arena.getTeam(p)))
                                    .with(Type.STAR)
                                    .build();
                            fm.clearEffects();
                            fm.addEffect(fe);
                            f.setFireworkMeta(fm);
                        }
                    }
                }
                catch (Exception ignored) {
                }
            }
        }
    }

    public void run() {
        for (Arena arena : am.arena) {
            if (!arena.isEnabled()) {
                continue;
            }

            if (arena.isCounting()) {
                doCountdown(arena);
            }
            else if (arena.isInGame() && !arena.isEndGame()) {
                doGameLoop(arena);
            }

            if (arena.isEndGame()) {
                doEndGame(arena);
            }
        }
    }
}