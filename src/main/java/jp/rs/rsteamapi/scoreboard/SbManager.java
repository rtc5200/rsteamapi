/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.rs.rsteamapi.scoreboard;

import jp.rs.rsteamapi.RSTeamAPI;
import jp.rs.rsteamapi.scoreboard.RSTeam.RSTeamColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

/**
 *
 * @author MainUser
 */
public class SbManager implements Listener{
    private Scoreboard sb;
    private RSTeam red;
    private RSTeam blue;
    public SbManager(RSTeamAPI main){
        load(main);
    }
    private void load(RSTeamAPI main){
        main.getServer().getPluginManager().registerEvents(this, main);
        sb = main.getServer().getScoreboardManager().getNewScoreboard();
        red = new RSTeam(sb,RSTeamColor.RED);
        blue = new RSTeam(sb,RSTeamColor.BLUE);
        for(Player p : Bukkit.getOnlinePlayers())
        {
            p.setScoreboard(sb);
        }
    }
    
    private RSTeam getTeam(String s)
    {
        if(s.equalsIgnoreCase("赤")){
            return red;
        }
        if(s.equalsIgnoreCase("青")){
            return blue;
        }
        return null;
    }
    public RSTeam getTeam(RSTeamColor color)
    {
        if(color.equals(RSTeamColor.RED)){
            return red;
        }
        return blue;
    }
    public RSTeam getTeam(Player p){
        if(red.isMember(p))return red;
        else if(blue.isMember(p))return blue;
        return null;
    }
    
    
    
    
    
    @EventHandler
    public void SetScorebordOnLogin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        try{
            p.setScoreboard(sb);
        }catch(IllegalStateException ex){
            e.setJoinMessage(p.getName() + "がログインに失敗しました." + ex.getLocalizedMessage());
        }
        
    }
    
    
    
}
