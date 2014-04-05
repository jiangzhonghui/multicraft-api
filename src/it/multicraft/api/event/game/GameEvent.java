package it.multicraft.api.event.game;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GameEvent extends Event implements Cancellable{

	private boolean cancelled=false;
	private static final HandlerList handlerlist=new HandlerList();
	
	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean arg0) {
		this.cancelled=arg0;
	}

	@Override
	public HandlerList getHandlers() {
		return handlerlist;
	}
	
	public static HandlerList getHandlerList() {
        return handlerlist;
    }

}
