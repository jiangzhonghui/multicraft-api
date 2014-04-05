package it.multicraft.api.event.game;



import it.multicraft.api.games.Game;
import it.multicraft.api.games.Gamer;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class GamerPlaceBlockEvent extends BlockPlaceEvent{

	private Game game;
	
	public GamerPlaceBlockEvent(Block placedBlock, BlockState replacedBlockState, Block placedAgainst, ItemStack itemInHand, boolean canBuild, Gamer gamer) {
		super(placedBlock, replacedBlockState, placedAgainst, itemInHand, gamer.getPlayer(), canBuild);
		this.game=gamer.getGame();
	}

	public Game getGame(){
		return game;
	}
	
	public void setCancelled(boolean cancelled){
		super.setCancelled(cancelled);
	}
	
}
