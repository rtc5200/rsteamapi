/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.rs.rsteamapi.scoreboard;

import org.bukkit.scoreboard.Team;

/**
 *
 * @author MainUser
 */
public class TeamOption {
    private final Team team;
    public TeamOption(RSTeam team)
    {
        this.team = team.getTeam();
    }
    public void setAllowFriendlyFire(boolean b)
    {
        team.setAllowFriendlyFire(b);
    }
    public void setCanSeeFriendlyInvisible(boolean b){
        team.setCanSeeFriendlyInvisibles(b);
    }
    public void setDisplayName(String name)
    {
        team.setDisplayName(name);
    }
    public void setPrefix(String s)
    {
        team.setPrefix(s);
    }
    public void setSuffix(String s)
    {
        team.setSuffix(s);
    }
    
    
}
