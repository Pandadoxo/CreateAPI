///////////////////////////////
// Class coded by Pandadoxo  //
// on 24.04.2022 at 12:01     //
// Don't remove this section //
///////////////////////////////
package de.pandadoxo.createapi.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CreatorQuitEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private Player player;

    public CreatorQuitEvent(Player player) {
        this.player = player;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public Player getPlayer() {
        return player;
    }
}
