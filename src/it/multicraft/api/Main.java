package it.multicraft.api;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static Main i;
	
	public void onLoad(){
		i=this;
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
