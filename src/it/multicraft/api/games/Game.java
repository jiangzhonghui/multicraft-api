package it.multicraft.api.games;

import org.bukkit.configuration.file.FileConfiguration;

public class Game {

	private String name;
	private Arena arena;
	private IManager manager;
	
	public Game(String name,Arena arena, IManager manager){
		this.arena=arena;
		this.manager=manager;
	}
	
	public String getName(){
		return name;
	}
	
	public IManager getManager(){
		return manager;
	}
	
	public Arena getArena(){
		return arena;
	}
	
	public void serialize(){
		FileConfiguration conf=GamesManager.getInstance().gamesConf.getConfig();
		conf.set("games."+name+".arena", arena.getName());
	}
	
}
