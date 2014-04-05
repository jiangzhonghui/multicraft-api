package it.multicraft.api.games;

import java.util.ArrayList;
import java.util.List;

import static it.multicraft.api.MCApi.*;

public class Game {

	private String name;
	private Arena arena;
	private IManager manager;
	private List<Gamer> gamers;
	
	public Game(String name, Arena arena, IManager manager){
		this.arena=arena;
		this.manager=manager;
		this.gamers=new ArrayList<>();
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
	
	public void addGamer(Gamer gamer){
		if (gamers.contains(gamer)){
			return;
		}
		gamers.add(gamer);
		manager.joinEvent(gamer, this);
	}
	
	public void removeGamer(Gamer gamer){
		if (!gamers.contains(gamer)){
			return;
		}
		gamers.remove(gamer);
		manager.leaveEvent(gamer, this);
	}
	
	public void serialize(){
		GAMESMANAGER().gamesConf.set("games."+name+".arena", arena.getName());
		GAMESMANAGER().gamesConf.set("games."+name+".manager", arena.getName());
		GAMESMANAGER().gamesYaml.saveConfig();
	}
}
