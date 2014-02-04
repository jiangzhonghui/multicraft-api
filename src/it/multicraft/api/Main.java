package it.multicraft.api;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static Main i;
	public Yaml playerConfig;
	
	public void onLoad(){
		i=this;
		playerConfig=new Yaml(this, "players.yml");
		playerConfig.saveConfig();
	}
	
	public void onEnable(){
		
	}
	
	public void onDisable(){
		
	}
	
	/**
	 * Get the Main class instance
	 * @return Main class instance
	 */
	public static Main getInstance(){
		return i;
	}

}
