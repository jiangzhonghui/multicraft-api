package it.multicraft.api.event.game;

import it.multicraft.api.games.Game;
import it.multicraft.api.games.Gamer;

import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;

public class GamerBreakBlockEvent extends BlockBreakEvent{

	private Game game;
	
	public GamerBreakBlockEvent(Block theBlock, Gamer gamer) {
		super(theBlock, gamer.getPlayer());
		this.game=gamer.getGame();
	}
	
	public Game getGame(){
		return game;
	}
	
	public void setCancelled(boolean cancelled){
		super.setCancelled(cancelled);
	}
	
}
