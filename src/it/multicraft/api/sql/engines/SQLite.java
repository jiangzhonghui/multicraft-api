package it.multicraft.api.sql.engines;

import java.sql.Connection;

import org.bukkit.plugin.Plugin;

import it.multicraft.api.sql.Database;

public class SQLite extends Database{

	protected SQLite(Plugin plugin) {
		super(plugin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Connection openConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkConnection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		
	}

}
