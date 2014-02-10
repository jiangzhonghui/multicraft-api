package it.multicraft.api;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class WorldMove {
	
	/**
	 * Teleport a specific player to another one
	 * @param target
	 */
	public void teleportToPlayer(Player start , Player target) {
		start.teleport(target);
	}
	
	/**
	 * Teleport a player to a specific location
	 * @param player
	 * @param X
	 * @param Y
	 * @param Z
	 */
	public void teleportToLocation(Player player, double X, double Y, double Z, String world) {
		player.teleport(new Location(Bukkit.getWorld(world), X, Y, Z));
	}
	
	
}
