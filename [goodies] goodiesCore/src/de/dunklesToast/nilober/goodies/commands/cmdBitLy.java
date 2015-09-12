package de.dunklesToast.nilober.goodies.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.dunklesToast.nilober.goodies.Main;
import de.dunklesToast.nilober.goodies.Utilitys.BitLyFetcher;

public class cmdBitLy implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdBitLy(Main plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		
		String lurl = args[0]; 
		
		cs.sendMessage(BitLyFetcher.getShortLink(lurl, cs));
		
		return false;
	        }
	 
}
