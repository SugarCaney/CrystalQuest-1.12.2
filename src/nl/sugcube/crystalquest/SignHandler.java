package nl.sugcube.crystalquest;

import nl.sugcube.crystalquest.game.Arena;
import nl.sugcube.crystalquest.game.ArenaManager;
import nl.sugcube.crystalquest.sba.SMeth;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Sign;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SugarCaney
 */
public class SignHandler {

    public static CrystalQuest plugin;
    public static ArenaManager am;

    private List<Location> signs = new ArrayList<Location>();

    public SignHandler(CrystalQuest instance, ArenaManager manager) {
        plugin = instance;
        am = manager;
    }

    /**
     * Start a sign updater. Will updated the signs 2 times every second.
     */
    public void startSignUpdater() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            public void run() {
                updateSigns();
            }
        }, 10L, 10L);
    }

    /**
     * Updates all signs in the sign list
     */
    public void updateSigns() {
        for (Location loc : this.signs) {
            try {
                Sign s = (Sign)loc.getBlock().getState();
                Arena a = am.getArena(s.getLine(1).replace(ChatColor.ITALIC + "", ""));
                ChatColor color = null;
                if (a.isEnabled()) {
                    if (a.isCounting()) {
                        s.setLine(3, ChatColor.YELLOW + "Starting");
                        s.setLine(2, a.getPlayers().size() + "/" + a.getMaxPlayers() + " | " +
                                a.getCountdown() + "s");
                        s.setLine(1, ChatColor.ITALIC + a.getName());
                        s.setLine(0, ChatColor.GREEN + "" + ChatColor.BOLD + "CQ-Join");
                    }
                    else if (a.isInGame() && !a.isEndGame()) {
                        s.setLine(3, ChatColor.DARK_RED + "In Game");
                        s.setLine(2, SMeth.toTime(a.getTimeLeft()) + " left");
                        s.setLine(1, ChatColor.ITALIC + a.getName());
                        s.setLine(0, ChatColor.AQUA + "" + ChatColor.BOLD + "CQ-Spectate");
                    }
                    else if (a.isEndGame()) {
                        color = ChatColor.DARK_PURPLE;
                        s.setLine(3, ChatColor.DARK_PURPLE + "Restarting");
                        s.setLine(2, "");
                        s.setLine(1, ChatColor.ITALIC + a.getName());
                        s.setLine(0, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Unjoinable");
                    }
                    else {
                        s.setLine(3, ChatColor.GREEN + "Lobby");
                        s.setLine(2, a.getPlayers().size() + "/" + a.getMaxPlayers());
                        s.setLine(1, ChatColor.ITALIC + a.getName());
                        s.setLine(0, ChatColor.GREEN + "" + ChatColor.BOLD + "CQ-Join");
                    }

                }
                else {
                    s.setLine(0, "");
                    s.setLine(1, ChatColor.ITALIC + a.getName());
                    s.setLine(2, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Disabled");
                    s.setLine(3, "");
                }
                s.update();
            }
            catch (Exception e) {
            }
        }

        plugin.menuSA.updateMenu();
        plugin.menuPT.updateMenus();
    }

    /**
     * Gets a list of all the lobby-signs
     *
     * @return (SignList) All Lobby-signs
     */
    public List<Location> getSigns() {
        return this.signs;
    }

}