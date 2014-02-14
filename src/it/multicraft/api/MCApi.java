package it.multicraft.api;

import it.multicraft.api.config.PlayersData;
import org.bukkit.plugin.java.JavaPlugin;

public class MCApi extends JavaPlugin{
	
	private static MCApi i;
	public PlayersData playersData;
	
	
	public void onLoad(){
		i=this;
	}
	
	public void onEnable(){
		playersData = new PlayersData();
	}
	
	public void onDisable(){
		
	}
	
	/**
	 * Get the Main class instance
	 * @return Main class instance
	 */
	public static MCApi getInstance(){
		return i;
	}

}
