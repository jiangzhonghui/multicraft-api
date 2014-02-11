package it.multicraft.api.config;

import org.bukkit.configuration.file.FileConfiguration;

import it.multicraft.api.MCApi;

public class PlayersData {

	private static Yaml playersYaml;
	private static FileConfiguration playersConfig;
	private MCApi main;
	
	public PlayersData(){
		this.main=MCApi.getInstance();
		playersYaml= new Yaml(main, "players.yml");
		playersYaml.saveDefaultConfig();
		playersConfig=playersYaml.getConfig();
	}
	
	public static void set(String name, String path, Object value){
		playersConfig.set(name+"."+path, value);
		playersYaml.saveConfig();
	}
	
	public static Object get(String name, String path){
		return playersConfig.get(name+"."+path);
	}
	
	public static boolean contains(String name, String path){
		if(playersConfig.contains(name+"."+path)){
			return true;
		}else{
			return false;
		}
	}
}
