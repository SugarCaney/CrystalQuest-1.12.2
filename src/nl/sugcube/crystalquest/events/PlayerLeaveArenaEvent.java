package nl.sugcube.crystalquest.events;

import nl.sugcube.crystalquest.game.Arena;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author SugarCaney
 */
public class PlayerLeaveArenaEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Player player;
    private Arena arena;

    /**
     * @param void
     * @return Get the arena the player left
     */
    public Arena getArena() {
        return this.arena;
    }

    /**
     * @param void
     * @return The player who left the arena
     */
    public Player getPlayer() {
        return this.player;
    }

    public PlayerLeaveArenaEvent(Player p, Arena a) {
        this.player = p;
        this.arena = a;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}