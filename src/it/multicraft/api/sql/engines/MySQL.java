package it.multicraft.api.sql.engines;

import it.multicraft.api.sql.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

import org.bukkit.plugin.Plugin;

public class MySQL extends Database{

	private Connection connection;
	private final String host;
	private final String port;
	private final String database;
	private final String username;
	private final String password;
	
	protected MySQL(Plugin plugin, String host, String port, String database, String username, String password){
		super(plugin);
		this.connection=null;
		this.host=host;
		this.port=port;
		this.database=database;
		this.username=username;
		this.password=password;
	}

	@Override
	public Connection openConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password);
		}catch(SQLException ex){
			
		}catch(ClassNotFoundException ex){
			plugin.getLogger().log(Level.SEVERE, "JDBC Driver not found!");
		}
		return connection;
	}

	@Override
	public boolean checkConnection(){
		return connection!=null;
	}

	@Override
	public Connection getConnection(){
		return connection;
	}

	@Override
	public void closeConnection(){
		try{
			connection.close();
		}catch(SQLException ex){
			
		}
		
	}

}
