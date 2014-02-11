package it.multicraft.api.base;

import it.multicraft.api.command.MCCommand;

public class MainCommand extends MCCommand{

	@Override
	public String getMainCommandName() {
		return "multicraft";
	}
	
	@Override
	public void registerSubcommands() {
		
	}
}
