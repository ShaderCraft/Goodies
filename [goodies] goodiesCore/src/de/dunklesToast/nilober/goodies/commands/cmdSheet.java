package de.dunklesToast.nilober.goodies.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.dunklesToast.nilober.goodies.Main;

public class cmdSheet implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdSheet(Main plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 
		return false;
	        }
	 
}
