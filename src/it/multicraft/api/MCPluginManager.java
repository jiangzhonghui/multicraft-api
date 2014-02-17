package it.multicraft.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MCPluginManager {

	private static HashMap<String, MCPlugin> subPlugins;
	
	public MCPluginManager(MCPlugin plugin){
		subPlugins = new HashMap<String, MCPlugin>();
	}
	
	public static List<MCPlugin> getPlugins(){
		return new ArrayList<MCPlugin>(subPlugins.values());
	}
	
	public static MCPlugin getPlugin(String name){
		return subPlugins.get(name);
	}
	
	public static void addPlugin(String name, MCPlugin plugin){
		if (subPlugins.containsKey(name)){
			throw new IllegalArgumentException("A plugin with name: "+name+" is already registered! Could not register plugin!");
		}
		subPlugins.put(name, plugin);
	}
	
	public static void removePlugin(String name){
		if (!subPlugins.containsKey(name)){
			throw new IllegalArgumentException("A plugin with name: "+name+" is NOT registered!");
		}
		subPlugins.remove(name);
	}
	
}
