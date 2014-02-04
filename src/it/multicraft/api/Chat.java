package it.multicraft.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Chat{

	/**
	 * Sends a generic message to a player
	 * @param player
	 * @param message
	 */
	public static void genericMsg(Player player, String message){
		player.sendMessage(message);
	}
	
	/**
	 * Sends an error message (chatcolor: red) to a player
	 * @param player
	 * @param message
	 */
	public static void errorMsg(Player player, String message){
		player.sendMessage(ChatColor.RED+message);
	}
	
	/**
	 * Sends a notify message (chatcolor: green) to a player
	 * @param player
	 * @param message
	 */
	public static void notifyMsg(Player player, String message){
		player.sendMessage(ChatColor.GREEN+message);
	}
	
	public static void broadcast(String message){
		Bukkit.broadcastMessage(message);
	}
}
