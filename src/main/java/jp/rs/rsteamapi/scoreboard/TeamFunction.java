/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.rs.rsteamapi.scoreboard;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;

/**
 *
 * @author MainUser
 */
public class TeamFunction {
    private final RSTeam team;
    public TeamFunction(RSTeam team)
    {
        this.team = team;
    }
    
    public void sendMessage(String msg)
    {
        for(OfflinePlayer p : team.getTeam().getPlayers())
        {
            if(p.isOnline()){
                p.getPlayer().sendMessage(msg);
            }
        }
    }
    public void teleport(Location loc)
    {
        for(OfflinePlayer p : team.getTeam().getPlayers())
        {
            if(p.isOnline()){
                p.getPlayer().teleport(loc);
            }
        }
    }
    
}
