/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.rs.rsteamapi.event;

import jp.rs.rsteamapi.scoreboard.RSTeam;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 *
 * @author MainUser
 */
public class PlayerTeamQuitEvent extends Event{
    private static final HandlerList handlers = new HandlerList();
    private final RSTeam team;
    private final Player p;
    
    public PlayerTeamQuitEvent(RSTeam team,Player p)
    {
        this.team = team;
        this.p = p;
    }
    
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    
    public RSTeam getTeam()
    {
        return team;
    }
    public Player getPlayer()
    {
        return p;
    }
    
}
