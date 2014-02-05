package it.multicraft.api;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class MCPlugin extends JavaPlugin{

	public abstract void onEnable();
	
	public abstract void onDisable();
	
	public abstract void onReload();
}
