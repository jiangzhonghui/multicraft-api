package it.multicraft.api.games;

import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public interface IManager {
	
	public String getName();
	
	public void joinEvent(Gamer gamer, Game game);
	
	public void leaveEvent(Gamer gamer, Game game);
	
	public void damageEvent(Gamer gamer, EntityDamageEvent event);
	
	public void blockBreakEvent();
	
	public void blockPlacedEvent();
	
	public void interactEvent(Gamer gamer, PlayerInteractEvent event);
	
	public void startGame(Game game);
	
}
