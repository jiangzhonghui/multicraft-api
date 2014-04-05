package it.multicraft.api;

import java.sql.Connection;

import it.multicraft.api.config.PlayersData;
import it.multicraft.api.games.GamesManager;
import it.multicraft.api.sql.Database;
import it.multicraft.api.sql.engines.MySQL;

import org.bukkit.plugin.java.JavaPlugin;

public class MCApi extends JavaPlugin{
	
	private static MCApi instance;
	private static GamesManager gamesManager;
	private static Database sql;
	private static Connection conn;
	public PlayersData playersData;
	
	public void onLoad(){
		instance=this;
	}
	
	public void onEnable(){
		String[] s={getConfig().getString("mysql.host"), getConfig().getString("mysql.port"), getConfig().getString("mysql.database"),
				getConfig().getString("mysql.username"), getConfig().getString("mysql.password")};
		setDatabase(new MySQL(this, s[0], s[1], s[2], s[3], s[4]));
		playersData = new PlayersData();
		gamesManager=new GamesManager();
	}
	
	public void onDisable(){
		
	}
	
	/**
	 * Get the Main class instance
	 * @return Main class instance
	 */
	public static MCApi API(){
		return instance;
	}
	
	public static GamesManager GAMESMANAGER(){
		return gamesManager;
	}
	
	public static Database SQL(){
		return sql;
	}
	
	public static Connection DATABASECON(){
		return conn;
	}
	
	public static void setDatabase(Database database){
		sql=database;
		conn=sql.openConnection();
	}

}
