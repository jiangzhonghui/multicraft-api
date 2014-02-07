package it.multicraft.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Chat{

	/**
	 * Sends a generic message to a player
	 * @param who
	 * @param message
	 */
	public static void genericMsg(CommandSender who, String message){
		who.sendMessage(message);
	}
	
	/**
	 * Sends an error message (chatcolor: red) to a player
	 * @param who
	 * @param message
	 */
	public static void errorMsg(CommandSender who, String message){
		who.sendMessage(ChatColor.RED+message);
	}
	
	/**
	 * Sends a notify message (chatcolor: green) to a player
	 * @param who
	 * @param message
	 */
	public static void notifyMsg(CommandSender who, String message){
		who.sendMessage(ChatColor.GREEN+message);
	}
	
	public static void broadcast(String message){
		Bukkit.broadcastMessage(message);
	}
}
