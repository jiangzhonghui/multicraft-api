package it.multicraft.api.games;

import it.multicraft.api.Utilities;

import org.bukkit.Location;

public class Arena {

	private Location l1;
	private Location l2;
	
	public Arena(Location l1, Location l2){
		this.l1=l1;
		this.l2=l2;
	}
	
	public Location getMin(){
		return l1;
	}
	
	public Location getMax(){
		return l2;
	}
	
	public boolean isInArena(Location location){
		if(Utilities.isInside(l1, location, location)){
			return true;
		}else {
			return false;
		}
	}
	
}
