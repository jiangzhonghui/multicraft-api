package it.multicraft.api.games;

import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import it.multicraft.api.MCApi;
import it.multicraft.api.Utilities;
import it.multicraft.api.config.Yaml;

public class GamesManager {

	private static GamesManager i;
	private static HashMap<String, Manager> managers;
	private MCApi main;
	private HashMap<String, Game> games;
	private HashMap<String, Player> gamers;
	public Yaml arenasYaml;
	public Yaml gamesYaml;
	public FileConfiguration arenasConf;
	public FileConfiguration gamesConf;
	
	public GamesManager(){
		i=this;
		this.main=MCApi.getInstance();
		arenasYaml=new Yaml(main, "arenas.yml");
		gamesYaml=new Yaml(main, "games.yml");
		games=new HashMap<String, Game>();
		managers=new HashMap<String, Manager>();
	}
	
	public static void addManager(String name, Manager manager){
		managers.put(name, manager);
	}
	
	public static Manager getManager(String name){
		return managers.get(name);
	}
	
	public static GamesManager getInstance(){
		return i;
	}
	
	public void loadGames(){
		for (String g: gamesConf.getConfigurationSection("games").getKeys(false)){
			loadGame(g);
		}
	}
	
	public void loadGame(String name){
		if (games.containsKey(name)){
			games.remove(name);
		}
		String sArena=gamesConf.getString("games."+name+".arena");
		Arena arena=new Arena(sArena, 
				              Utilities.stringToLocation(arenasConf.getString("arenas."+sArena+".l1")),
				              Utilities.stringToLocation(arenasConf.getString("arenas."+sArena+".l2")), 
				              Utilities.stringsToLocations(arenasConf.getStringList("arenas."+sArena+".l2")));
		games.put(name, new Game(name, arena, managers.get(gamesConf.getString("games."+name+".manager"))));
	}
	
	public boolean addGamer(Game game, Player player){
		if (gamers.containsKey(player)){
			return false;
		}
		gamers.put(game.getName(), player);
		game.addPlayer(player);
		return true;
	}
	
	public boolean removeGamer(Game game, Player player){
		if (!gamers.containsKey(player)){
			return false;
		}
		gamers.remove(player);
		game.removePlayer(player);
		return true;
	}
}
