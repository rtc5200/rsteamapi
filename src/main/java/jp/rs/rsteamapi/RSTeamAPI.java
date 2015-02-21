/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.rs.rsteamapi;

import jp.rs.rsteamapi.scoreboard.SbManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author MainUser
 */
public class RSTeamAPI extends JavaPlugin{
    private static RSTeamAPI instance;
    private SbManager manager;
    public static final String testMessage = "RSTeamAPITest Debugging....";
    @Override
    public void onEnable(){
        instance = this;
        load();
    }
    public static RSTeamAPI getInstance(){
        return instance;
    }
    public SbManager getSbManager()
    {
        return manager;
    }
    private void load()
    {
        manager = new SbManager(this);
    }
    
    
}
