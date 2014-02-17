package it.multicraft.api.games;

import org.bukkit.entity.Player;

public abstract class IManager {

	public IManager(){
		
	}
	
	public abstract String getName();
	
	public void onGameJoin(Player p, Game g){
		
	}
	
	
	
}
