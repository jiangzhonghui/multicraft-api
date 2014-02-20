package it.multicraft.api.games;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Game {

	private String name;
	private Arena arena;
	private Manager manager;
	private List<Player> gamers;
	
	public Game(String name, Arena arena, Manager manager){
		this.arena=arena;
		this.manager=manager;
		this.gamers=new ArrayList<>();
	}
	
	public String getName(){
		return name;
	}
	
	public Manager getManager(){
		return manager;
	}
	
	public Arena getArena(){
		return arena;
	}
	
	public void serialize(){
		GamesManager.getInstance().gamesConf.set("games."+name+".arena", arena.getName());
		GamesManager.getInstance().gamesConf.set("games."+name+".manager", arena.getName());
	}
	
	public void addPlayer(Player player){
		if (gamers.contains(player)){
			return;
		}
		gamers.add(player);
		manager.joinEvent(player, this);
	}
	
	public void removePlayer(Player player){
		if (!gamers.contains(player)){
			return;
		}
		gamers.remove(player);
		manager.leaveEvent(player, this);
	}
	
}
