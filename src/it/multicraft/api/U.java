package it.multicraft.api;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class U {
	
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
	public static boolean isOnline(Player player) {
		if(Bukkit.getPlayerExact(player.getName())!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param location
	 * @return String
	 */
	public static String locationToString(Location location){
		return location.getWorld().getName()+","+location.getX()+","+location.getY()+","+location.getZ()+","+location.getPitch()+","+location.getYaw();
	}
	
	/**
	 * 
	 * @param string
	 * @return String
	 */
	public static Location stringToLocation(String string){
		String[] a=string.split(","); 
		return new Location(Bukkit.getWorld(a[0]), Double.parseDouble(a[1]), Double.parseDouble(a[2]), Double.parseDouble(a[3]), Float.parseFloat(a[4]), Float.parseFloat(a[5]));
	}
	
	/**
	 * 
	 * @param locations
	 * @return ArrayList
	 */
	public static List<String> locationsToStrings(List<Location> locations){
		List<String> temp = new ArrayList<String>();
		for (Location l: locations){
			temp.add(locationToString(l));
		}
		return temp;
	}
	
	/**
	 * 
	 * @param strings
	 * @return ArrayList
	 */
	public static List<Location> stringsToLocations(List<String> strings){
		List<Location> temp = new ArrayList<Location>();
		for (String str: strings){
			temp.add(stringToLocation(str));
		}
		return temp;
	}
	
	public static String time(String format){
		return new SimpleDateFormat(format).format(Calendar.getInstance().getTime());
	}
	
	public static String time(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	}
	
	public static Statement newStatement(){
		try {
			return MCApi.DATABASECON().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}
}
