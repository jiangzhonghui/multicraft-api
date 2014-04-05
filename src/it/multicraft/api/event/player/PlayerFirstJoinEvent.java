package it.multicraft.api.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerFirstJoinEvent extends PlayerJoinEvent{

	public PlayerFirstJoinEvent(Player playerJoined, String joinMessage) {
		super(playerJoined, joinMessage);
	}

}
