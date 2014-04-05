package it.multicraft.api.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class MCSubcommand{
	
	public abstract String getSubcommandName();
	
	protected MCCommandSender commandSender(){
		return MCCommandSender.GENERIC;
	}
	
	protected abstract String getPermission();
	
	protected abstract String getHelp();
	
	protected abstract boolean executeCommand(CommandSender sender, Command command, String[] args);

	public static enum MCCommandSender{
		GENERIC,
		CONSOLE,
		PLAYER,
		REMOTE,
		COMMANDBLOCK;
	}
	
}

