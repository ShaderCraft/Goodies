package de.dunklesToast.nilober.goodies.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import de.dunklesToast.nilober.goodies.Main;

public class cmdServer implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdServer(Main plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 
		cs.sendMessage("§d----------------------[§egoodies§d]----------------------");
		cs.sendMessage("§bJavaVendor: 	§a" + System.getProperty("java.vendor"));
		cs.sendMessage("§bJavaVersion: 	§a" + System.getProperty("java.version"));
		cs.sendMessage("§bArchitecture:	§a" + System.getProperty("os.arch"));
		cs.sendMessage("§bOS:          	§a" + System.getProperty("os.name"));
		cs.sendMessage("§bOS Version:  	§a" + System.getProperty("os.version"));
		cs.sendMessage("§bProcessors:    §a" + Runtime.getRuntime().availableProcessors());
		cs.sendMessage("§d----------------------[§egoodies§d]----------------------");		
		
		return false;
	        }
	 
}
