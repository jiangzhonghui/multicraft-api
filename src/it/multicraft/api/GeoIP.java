package it.multicraft.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class GeoIP {
	
	private MCApi plg;
	private static FileConfiguration plConfig;
	
	public GeoIP(){
		plg=MCApi.getInstance();
		plConfig=plg.playerConfig.getConfig();
	}
	
	/**
	 * Sets player nation code in configuration file
	 * @param player - The player
	 * @param code - The nation code
	 */
	public static void setCode(Player player, String code){
		plConfig.set(player.getName()+".code", code);
	}
	
	/**
	 * Gets player nation in configuration file
	 * @param player - The player
	 * @param nation -  The nation code
	 */
	public static void setNation(Player player, String nation){
		plConfig.set(player.getName()+".nation", nation);
	}
	
	/**
	 * Gets player nation code from configuration file
	 * @param player
	 * @return String - player nation code
	 */
	public static String getCode(Player player){
		return plConfig.getString(player.getName()+".code");
	}
	
	/**
	 * Gets player nation from configuration file
	 * @param player - The player 
	 * @return String - player nation
	 */
	public static String getNation(Player player){
		return plConfig.getString(player.getName()+".nation");
	}
	
	/**
	 * Gets player nation code from freegeoip.net
	 * @param player - The player
	 * @return String - player nation code
	 */
	public static String getCodeByIp(Player player){
		String json = sendQuery(player);
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject jobject = jelement.getAsJsonObject();
		return jobject.get("country_code").toString().replaceAll("\"", "");
	}
	
	/**
	 * Gets player nation from freegeoip.net
	 * @param player
	 * @return String - player nation
	 */
	public static String getNationByIp(Player player){
		String json = sendQuery(player);
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject jobject = jelement.getAsJsonObject();
		return jobject.get("country_name").toString().replaceAll("\"", "");
	}
	
	private static String sendQuery(Player P){
		String ip = P.getAddress().toString();
		String json = "";
		try {
			URL url = new URL("http://www.freegeoip.net/json/"+ip.split(":")[0]);
			URLConnection conn = url.openConnection();
			BufferedReader read = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			json = read.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
}
