package it.multicraft.api.event.player;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerBanEvent extends Event{

	private static final HandlerList handlerlist=new HandlerList();
	private Player player;
	private CommandSender sender;
	
	public PlayerBanEvent(Player player, CommandSender sender){
		this.player=player;
		this.sender=sender;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public CommandSender getSender(){
		return sender;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlerlist;
	}
	
	public static HandlerList getHandlerList(){
		return handlerlist;
	}

}
