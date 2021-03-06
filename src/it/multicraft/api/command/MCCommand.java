package it.multicraft.api.command;

import it.multicraft.api.Chat;
import it.multicraft.api.command.MCSubcommand.MCCommandSender;

import java.util.HashMap;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;
import org.bukkit.entity.Player;

public abstract class MCCommand implements CommandExecutor{
	
	public HashMap<String, MCSubcommand> cmdlist;
	
	public MCCommand(){
		cmdlist = new HashMap<String, MCSubcommand>();
		registerSubcommands();
	}
	
	public abstract void registerSubcommands();
	
	public abstract String getMainCommandName();
	
	@Override
	public boolean onCommand(CommandSender snd, Command cmd, String str, String[] args){
		if (!cmd.getName().equalsIgnoreCase(getMainCommandName()))return false;
		if(args.length<1)return false;
		if(!cmdlist.containsKey(args[0]))return false;
		MCSubcommand mcsc = cmdlist.get(args[0]);
		if(!snd.hasPermission(mcsc.getPermission())){
			return false;
		}
		if (!mcsc.commandSender().equals(parseSender(snd, mcsc))){
			Chat.errorMsg(snd, "Wrong command sender!");
			return true;
		}
		if (mcsc.executeCommand(snd, cmd, args)){
			return true;
		}
		else{
			Chat.errorMsg(snd, mcsc.getHelp());
			return false;
		}
	}
	
	private MCCommandSender parseSender(CommandSender s, MCSubcommand mcsc){
		if (mcsc.commandSender().equals(MCCommandSender.GENERIC) || mcsc.commandSender().equals(null)){
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
