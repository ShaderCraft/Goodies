package de.dunklesToast.nilober.goodies.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import de.dunklesToast.nilober.goodies.Main;
import de.dunklesToast.nilober.goodies.messages.Messages;

public class cmdGoodies implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdGoodies(Main plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		if(!(cs instanceof Player)){
			cs.sendMessage(ChatColor.translateAlternateColorCodes('&',Messages.getMessage("general.onlyplayers")));
			return true;
		}else{
			Player p = (Player)cs;
			if(args.length == 0){
				p.sendMessage("Hey, " + p.getName());
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',Messages.getMessage("help.main")));
			}if(args.length == 1){
				if(args[0].equalsIgnoreCase("hat")){
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',Messages.getMessage("help.hat")));
				}
				if(args[0].equalsIgnoreCase("op")){
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',Messages.getMessage("help.op")));
				}				
				if(args[0].equalsIgnoreCase("kick")){
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',Messages.getMessage("help.kick")));
				}
				if(args[0].equalsIgnoreCase("kill")){
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',Messages.getMessage("help.kill")));
				}
				if(args[0].equalsIgnoreCase("config")){
					if(p.hasPermission("goodies.op") || p.hasPermission("goodies.*")){
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.getMessage("help.configbook")));
			
						
						
						
						ItemStack book = new ItemStack(Material.BOOK);
						BookMeta bmeta = (BookMeta) book.getItemMeta();
						bmeta.addPage("§aWelcome to the §3goodies §a Book! Here you can find any information about the Plugin and the config file!");
						bmeta.addPage("");
					}
				}
			}
		}
		
		
		return false;
	        }
	 
}
