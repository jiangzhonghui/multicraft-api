package it.multicraft.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.Material;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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
	
	/**
	 * 
	 * @param invInventory
	 * @return String
	 */
	public static String inventoryToString (Inventory invInventory){
        String serialization = invInventory.getSize() + ";";
        for (int i = 0; i < invInventory.getSize(); i++){
            ItemStack is = invInventory.getItem(i);
            if (is != null){
                String serializedItemStack = new String();
                String isType = String.valueOf(is.getType().getId());
                serializedItemStack += "t@" + isType;
                if (is.getDurability() != 0) {
                    String isDurability = String.valueOf(is.getDurability());
                    serializedItemStack += ":d@" + isDurability;
                }
                if (is.getAmount() != 1){
                    String isAmount = String.valueOf(is.getAmount());
                    serializedItemStack += ":a@" + isAmount;
                }
                Map<Enchantment,Integer> isEnch = is.getEnchantments();
                if (isEnch.size() > 0){
                    for (Entry<Enchantment,Integer> ench : isEnch.entrySet()){
                        serializedItemStack += ":e@" + ench.getKey().getId() + "@" + ench.getValue();
                    }
                }
                serialization += i + "#" + serializedItemStack + ";";
            }
        }
        return serialization;
    }
	
	/**
	 * 
	 * @param invString
	 * @return Inventory
	 */
	public static Inventory StringToInventory (String invString){
        String[] serializedBlocks = invString.split(";");
        String invInfo = serializedBlocks[0];
        Inventory deserializedInventory = Bukkit.getServer().createInventory(null, Integer.valueOf(invInfo));
        for (int i = 1; i < serializedBlocks.length; i++){
            String[] serializedBlock = serializedBlocks[i].split("#");
            int stackPosition = Integer.valueOf(serializedBlock[0]);
            if (stackPosition >= deserializedInventory.getSize()){
                continue;
            }
            ItemStack is = null;
            Boolean createdItemStack = false; 
            String[] serializedItemStack = serializedBlock[1].split(":");
            for (String itemInfo : serializedItemStack){
                String[] itemAttribute = itemInfo.split("@");
                if (itemAttribute[0].equals("t")){
                    is = new ItemStack(Material.getMaterial(Integer.valueOf(itemAttribute[1])));
                    createdItemStack = true;
                }
                else if (itemAttribute[0].equals("d") && createdItemStack){
                    is.setDurability(Short.valueOf(itemAttribute[1]));
                }
                else if (itemAttribute[0].equals("a") && createdItemStack){
                    is.setAmount(Integer.valueOf(itemAttribute[1]));
                }
                else if (itemAttribute[0].equals("e") && createdItemStack){
                    is.addEnchantment(Enchantment.getById(Integer.valueOf(itemAttribute[1])), Integer.valueOf(itemAttribute[2]));
                }
            }
            deserializedInventory.setItem(stackPosition, is);
        }
        return deserializedInventory;
    }
}
