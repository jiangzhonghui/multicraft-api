package it.multicraft.api;

import it.multicraft.api.games.GamesManager;
import it.multicraft.api.games.Manager;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class MCPlugin extends JavaPlugin{
	
	private static MCPlugin i;
	
	public MCPlugin(){
		i=this;
		MCPluginManager.addPlugin(this.getName(), this);
	}
	
	public abstract void onEnable();
	
	public abstract void onDisable();
	
	public abstract void onReload();
	
	public void addGameManager(Manager manager){
		GamesManager.addManager(manager.getName(), manager);
	}
	
	public static MCPlugin getInstance(){
		return i;
	}
}
