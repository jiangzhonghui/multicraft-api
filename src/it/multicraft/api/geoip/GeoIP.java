package it.multicraft.api.geoip;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import it.multicraft.api.Main;

public class GeoIP {
	
	private Main plg;
	private FileConfiguration plConfig;
	
	public GeoIP(){
		plg=Main.getInstance();
		plConfig=plg.playerConfig.getConfig();
	}
	
	public void setCode(Player player, String code){
		plConfig.set(player.getName()+".code", code);
	}
	
	public void setNation(Player player, String nation){
		plConfig.set(player.getName()+".nation", nation);
	}
	
	public String getCode(Player player){
		return plConfig.getString(player.getName()+".code");
	}
	
	public String getnation(Player player){
		return plConfig.getString(player.getName()+".nation");
	}
	
	private String sendQuery(Player P){
		return null;
	}
	
}
