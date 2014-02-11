package it.multicraft.api;

import org.bukkit.plugin.java.JavaPlugin;

public class MCApi extends JavaPlugin{
	
	public static MCApi i;
	public Yaml playerConfig;

	
	public void onLoad(){
		i=this;
	}
	
	public void onEnable(){
		playerConfig=new Yaml(this, "players.yml");
		playerConfig.saveConfig();
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
