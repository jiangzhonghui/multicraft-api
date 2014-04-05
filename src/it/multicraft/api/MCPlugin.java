package it.multicraft.api;

import it.multicraft.api.games.IManager;
import static it.multicraft.api.MCApi.*;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class MCPlugin extends JavaPlugin{
	
	private static MCPlugin instance;
	
	public void onLoad(){
		instance=this;
		MCPluginManager.addPlugin(this.getName(), this);
	}
	
	public abstract void onEnable();
	
	public abstract void onDisable();
	
	public void onReload(){
		
	}
	
	public void addGameManager(IManager manager){
		GAMESMANAGER().addManager(manager);
	}
	
	public static MCPlugin getInstance(){
		return instance;
	}
}
