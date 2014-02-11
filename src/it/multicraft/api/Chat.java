package it.multicraft.api;

import it.multicraft.api.config.PlayersData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
	
	/**
	 * Send a message to every player from a specific nation
	 * @param nation
	 * @param message
	 */
	public static void broadcast(String nation, String message) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (PlayersData.get(player.getName(), "code").equals(nation)){
				Chat.genericMsg(player, message);
			}
		}
	}
}
