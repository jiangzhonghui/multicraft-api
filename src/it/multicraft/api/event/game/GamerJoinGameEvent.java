package it.multicraft.api.event.game;

import it.multicraft.api.games.Game;
import it.multicraft.api.games.Gamer;

import org.bukkit.entity.Player;

public class GamerJoinGameEvent extends GameEvent{

	private Player player;
	private Game game;
	
	public GamerJoinGameEvent(Gamer gamer){
		this(gamer.getPlayer(), gamer.getGame());
	}
	
	public GamerJoinGameEvent(Player player, Game game){
		this.player=player;
		this.game=game;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public Game getGame(){
		return game;
	}
	
}
