package it.multicraft.api.games;

import org.bukkit.entity.Player;

public class Gamer {

	private Player player;
	private Game game;
	
	public Gamer(Player player, Game game){
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
