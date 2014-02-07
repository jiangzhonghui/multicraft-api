package it.multicraft.api;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;
import org.bukkit.entity.Player;

public abstract class MCCommand implements CommandExecutor{
	
	protected abstract MCCommandSender getCommandSenderType();
	
	protected abstract String getPermission();
	
	protected abstract String getHelp();
	
	protected abstract boolean executeCommand(CommandSender sender, Command command, String[] args);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args){
		if(!parseSender(sender).equals(getCommandSenderType())){
			Chat.errorMsg(sender, "Wrong command sender");
			return true;
		}
		if (!sender.hasPermission(getPermission())){
			return false;
		}
		if (executeCommand(sender, cmd, args)){
			return true;
		}else{
			return false;
		}
	}

	private MCCommandSender parseSender(CommandSender s){
		if (getCommandSenderType().equals(MCCommandSender.GENERIC)){
			return MCCommandSender.GENERIC;
		}
		else if (s instanceof ConsoleCommandSender){
			return MCCommandSender.CONSOLE;
		}
		else if (s instanceof Player){
			return MCCommandSender.PLAYER;
		}
		else if (s instanceof RemoteConsoleCommandSender){
			return MCCommandSender.REMOTE;
		}
		else if (s instanceof BlockCommandSender){
			return MCCommandSender.COMMANDBLOCK;
		}else{
			return MCCommandSender.GENERIC;
		}
	}

}
enum MCCommandSender{
	GENERIC,
	CONSOLE,
	PLAYER,
	REMOTE,
	COMMANDBLOCK;
}
