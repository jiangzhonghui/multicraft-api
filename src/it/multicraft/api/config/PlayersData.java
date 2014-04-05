package it.multicraft.api.config;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

import it.multicraft.api.MCApi;
import it.multicraft.api.config.Yaml;
import static it.multicraft.api.MCApi.*;

public class PlayersData {

	private static Yaml playersYaml;
	private static FileConfiguration playersConfig;
	private MCApi main;
	
	public PlayersData(){
		this.main=API();
		playersYaml= new Yaml(main, "players.yml");
		playersYaml.saveDefaultConfig();
		playersConfig=playersYaml.getConfig();
	}
	
	public static List<String> getAll(){
		List<String> l = new ArrayList<>();
		for(String a: playersConfig.getConfigurationSection("p").getKeys(false)){
			l.add(a);
		}
		return l;
	}
	
	public static void set(String uuid, String path, Object value){
		playersConfig.set("p."+uuid+"."+path, value);
		playersYaml.saveConfig();
	}
	
	public static Object get(String uuid, String path){
		return playersConfig.get("p."+uuid+"."+path);
	}
	
	public static boolean contains(String uuid, String path){
		if(playersConfig.contains("p."+uuid+"."+path)){
			return true;
		}else{
			return false;
		}
	}
}
