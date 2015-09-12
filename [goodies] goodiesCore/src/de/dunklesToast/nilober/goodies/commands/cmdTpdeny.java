package de.dunklesToast.nilober.goodies.commands;

import net.md_5.bungee.api.ChatColor;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dunklesToast.nilober.goodies.Main;

public class cmdTpdeny implements CommandExecutor{

	public cmdTpdeny(Main plugin){
	}
	
	

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if (s instanceof Player){
			Player p = (Player)s;
			if (args.length == 0){
				if (Main.tpa.containsKey(p)){
					//s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>&e You have one open request from &c"+ Main.tpa.get(p)+"&e."));
					if (Main.tpa.get(p).isOnline()){
						Player p2 = Main.tpa.get(p);
						Main.tpa.remove(p);
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &e You have deny the request from &c" + p2.getDisplayName() + "&e."));
						p2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &e" + p.getDisplayName() + "&c don't accept your Teleport Request."));
					} else {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &e The player is not on the Server. The request was removed."));
						Main.tpa.remove(p);
					}
				} else {
					s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>&e You have not a Tp request!"));
				}
				
			}
		} else {
			s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &bPlayer Command only!"));
		}
		
		return true;
	}

	
	
	
}
