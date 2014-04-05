package it.multicraft.api.games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import static it.multicraft.api.MCApi.*;
import it.multicraft.api.MCApi;
import it.multicraft.api.U;
import it.multicraft.api.config.Yaml;

public class GamesManager {
	private HashMap<String, IManager> managers;
	private MCApi main;
	private HashMap<String, Game> games;
	private List<Gamer> gamers;
	public Yaml arenasYaml;
	public Yaml gamesYaml;
	public FileConfiguration arenasConf;
	public FileConfiguration gamesConf;
	
	public GamesManager(){
		this.main=API();
		managers=new HashMap<String, IManager>();
		games=new HashMap<String, Game>();
		gamers=new ArrayList<>();
		arenasYaml=new Yaml(main, "arenas.yml");
		gamesYaml=new Yaml(main, "games.yml");
		arenasConf=arenasYaml.getConfig();
		gamesConf=gamesYaml.getConfig();
	}
	
	public void addManager(IManager manager){
		managers.put(manager.getName(), manager);
	}
	
	public IManager getManager(String name){
		return managers.get(name);
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
				              U.stringToLocation(arenasConf.getString("arenas."+sArena+".l1")),
				              U.stringToLocation(arenasConf.getString("arenas."+sArena+".l2")), 
				              U.stringsToLocations(arenasConf.getStringList("arenas."+sArena+".l2")));
		games.put(name, new Game(name, arena, managers.get(gamesConf.getString("games."+name+".manager"))));
	}
	
	public boolean addGamer(Game game, Player player){
		Gamer gamer=new Gamer(player, game);
		if (gamers.contains(gamer)){
			return false;
		}
		game.addGamer(gamer);
		gamers.add(gamer);
		return true;
	}
	
	public boolean removeGamer(Gamer gamer){
		if (!gamers.contains(gamer)){
			return false;
		}
		gamer.getGame().removeGamer(gamer);
		gamers.remove(gamer);
		return true;
	}
	
	public Gamer getGamer(Player player){
		for (Gamer g: gamers){
			if (g.getPlayer().equals(player))return g;
		}
		return null;
	}
	
	public void teleportToLobby(Player player){
		player.teleport(U.stringToLocation(arenasConf.getString("lobby")));
	}
}
