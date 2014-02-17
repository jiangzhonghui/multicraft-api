package it.multicraft.api.games;

import java.util.HashMap;

import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Monster;

import it.multicraft.api.MCApi;
import it.multicraft.api.config.Yaml;

public class GamesManager {

	private static GamesManager i;
	private MCApi main;
	private HashMap<String, Game> games;
	private static HashMap<String, IManager> managers;
	public Yaml arenasConf;
	public Yaml gamesConf;
	
	public GamesManager(){
		this.i=this;
		this.main=MCApi.getInstance();
		arenasConf=new Yaml(main, "arenas.yml");
		gamesConf=new Yaml(main, "games.yml");
		games=new HashMap<String, Game>();
		managers=new HashMap<String, IManager>();
	}
	
	public static void addManager(String name, IManager manager){
		managers.put(name, manager);
	}
	
	public static IManager getManager(String name){
		return managers.get(name);
	}
	
	public static GamesManager getInstance(){
		return i;
	}
	
	public void loadGames(){
		
	}
	
	public void loadGame(String name){
		
	}
	
}
