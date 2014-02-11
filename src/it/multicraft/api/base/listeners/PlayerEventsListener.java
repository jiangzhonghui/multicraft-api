package it.multicraft.api.base.listeners;

import it.multicraft.api.GeoIP;
import it.multicraft.api.MCApi;
import it.multicraft.api.config.PlayersData;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerEventsListener implements Listener{
	
	private MCApi main;
	
	public PlayerEventsListener(){
		main=MCApi.getInstance();
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	@EventHandler(priority=EventPriority.NORMAL, ignoreCancelled=true)
	public void onPlayerJoin(PlayerJoinEvent event){
		Player P = event.getPlayer();
		if((int)PlayersData.get(P.getName(), "version")==0){
			PlayersData.set(P.getName(), "nation", GeoIP.getNationByIp(P));
			String code;
			if (GeoIP.getCodeByIp(P).equals("IT")){
				code="IT";
			}else{
				code="EN";
			}
			PlayersData.set(P.getName(), "code", code);
		}
	}

}
