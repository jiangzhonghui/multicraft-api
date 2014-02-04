package it.multicraft.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Yaml {
	
	private File file;
    private FileConfiguration config;
    private JavaPlugin plg;
    private String name;
    
    public Yaml(JavaPlugin plugin, String name){
    	this.plg=plugin;
    	this.name=name;
    }
	
    public void saveDefaultConfig(){
    	plg.saveResource(name, false);
    }
    
    public void reloadConfig(){
    	File dataFolder=plg.getDataFolder();
    	if (!dataFolder.exists())return;
    	if (file==null)file=new File(dataFolder, name);
    	config=YamlConfiguration.loadConfiguration(file);
    	InputStream instreamConfig = plg.getResource(name);
    	if (instreamConfig != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(instreamConfig);
            config.setDefaults(defConfig);
        }
    }
    
    public FileConfiguration getConfig(){
    	if (config==null)reloadConfig();
    	return config;
    }
    
    public void saveConfig(){
    	if (config==null || file==null)return;
    	try{
    		getConfig().save(file);
    	}
    	catch(IOException ex){
    		ex.printStackTrace();
    	}
    }
    
}
