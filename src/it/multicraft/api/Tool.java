package it.multicraft.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Tool {
	
	/**
	 * @param player
	 * @param X1
	 * @param Y1
	 * @param Z1
	 * @param X2
	 * @param Y2
	 * @param Z2
	 * @return boolean
	 * WARNING: not tested
	 */
	public boolean isInside(Player player, double X1, double Y1, double Z1, double X2, double Y2, double Z2) {
		double xPlayer = player.getLocation().getX();
		double yPlayer = player.getLocation().getY();
		double zPlayer = player.getLocation().getZ();
		if (xPlayer > X1 && xPlayer < X2 && yPlayer > Y1 && yPlayer < Y2 && zPlayer > Z1 && zPlayer < Z2) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param player
	 * @return boolean
	 */
	public boolean isOnline(Player player) {
		if(Bukkit.getPlayerExact(player.getName()) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
