package it.multicraft.api.games;

import java.util.List;

import it.multicraft.api.Utilities;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class Arena {

	private String name;
	private Location l1;
	private Location l2;
	private List<Location> spawnpoints;
	
	public Arena(String name, Location l1, Location l2, List<Location> spawnpoints){
		this.l1=l1;
		this.l2=l2;
		this.spawnpoints=spawnpoints;
	}
	
	public String getName(){
		return name;
	}
	
	public Location getL1(){
		return l1;
	}
	
	public Location getL2(){
		return l2;
	}
	
	public int getMaxPlayers(){
		return spawnpoints.size();
	}
	
	public List<Location> getSpawnpoints(){
		return spawnpoints;
	}
	
	public boolean isInArena(Location location){
		if(Utilities.isInside(l1, l2, location)){
			return true;
		}else {
			return false;
		}
	}
	
	public String serialize(){
		FileConfiguration conf = GamesManager.getInstance().arenasConf;
		conf.set("arenas."+name+".l1", Utilities.locationToString(l1));
		conf.set("arenas."+name+".l2", Utilities.locationToString(l2));
		conf.set("arenas."+name+".spawnpoints", Utilities.locationsToStrings(spawnpoints));
		GamesManager.getInstance().arenasYaml.saveConfig();
		return name;
	}
	
}
