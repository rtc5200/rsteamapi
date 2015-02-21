/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.rs.rsteamapi.scoreboard;

import jp.rs.rsteamapi.event.PlayerTeamJoinEvent;
import jp.rs.rsteamapi.event.PlayerTeamQuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

/**
 *
 * @author MainUser
 */
public class RSTeam {
    public final RSTeamColor color;
    private final Team team;
    
    public RSTeam(Scoreboard sb,RSTeamColor color){
        this.color = color;
        team = sb.registerNewTeam(color.Localize());
        team.setPrefix(color.toChatColor().toString());
        team.setSuffix(ChatColor.RESET.toString());
        team.setAllowFriendlyFire(false);
    }
    @Deprecated
    protected Team getTeam()
    {
        return team;
    }
    public void addPlayer(OfflinePlayer p)
    {
        team.addPlayer(p);
        if(p.isOnline()){
            Bukkit.getPluginManager().callEvent(new PlayerTeamJoinEvent(this,p.getPlayer()));
        }
        
    }
    public void removePlayer(OfflinePlayer p)
    {
        team.removePlayer(p);
        if(p.isOnline()){
            Bukkit.getPluginManager().callEvent(new PlayerTeamQuitEvent(this,p.getPlayer()));
        }
    }
    public boolean isMember(OfflinePlayer p)
    {
        return team.hasPlayer(p);
    }
    public boolean isMember(String name)
    {
        return isMember(Bukkit.getOfflinePlayer(name));
    }
    public TeamOption getOption()
    {
        return new TeamOption(this);
    }
    public TeamFunction getFunction()
    {
        return new TeamFunction(this);
    }
    public RSTeamColor getTeamColor()
    {
        return color;
    }
    public void clear()
    {
        for(OfflinePlayer p : team.getPlayers())
        {
            removePlayer(p);
        }
    }
    public int getNumberOfMembers()
    {
        return team.getSize();
    }
    
    
    
    public enum RSTeamColor{
        RED("赤"),BLUE("青");
        
        private final String string;
        private RSTeamColor(final String name)
        {
            this.string = name;
        }
        public String Localize()
        {
            return string;
        }
        @Override
        public String toString()
        {
            return name();
        }
        public String ColoredString()
        {
            String result = (name().equals("RED"))? ChatColor.RED + string : ChatColor.BLUE + string;
            return result + ChatColor.RESET;
        }
        public ChatColor toChatColor()
        {
            return (name().equals("RED"))? ChatColor.RED : ChatColor.BLUE;
        }
    }
}
