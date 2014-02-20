package it.multicraft.api.games;

import org.bukkit.entity.Player;

public abstract class Manager {

	public Manager(){
		
	}
	
	public abstract String getName();
	
	public void joinEvent(Player player, Game game){
		
	}
	
	public void leaveEvent(Player player, Game game){
		
	}
	
	
	
}
