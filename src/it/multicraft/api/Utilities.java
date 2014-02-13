package it.multicraft.api;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Utilities {
	
	/**
	 * @param l1
	 * @param l2
	 * @param location
	 * @return boolean
	 */
	public static boolean isInside(Location l1, Location l2, Location location){
		if (!l2.getWorld().equals(location.getWorld())){
			return false;
		}
		double[] dim = new double[2];
		dim[0]=l1.getX();
		dim[1]=l2.getX();
		Arrays.sort(dim);
		if(location.getX()>dim[1] || location.getX()<dim[0]){
			return false;
		}
		dim[0]=l1.getY();
		dim[1]=l2.getY();
		Arrays.sort(dim);
		if(location.getY()>dim[1] || location.getY()<dim[0]){
			return false;
		}
		dim[0]=l1.getZ();
		dim[1]=l2.getZ();
		Arrays.sort(dim);
		if(location.getZ()>dim[1] || location.getZ()<dim[0]){
			return false;
		}
		return true;
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
