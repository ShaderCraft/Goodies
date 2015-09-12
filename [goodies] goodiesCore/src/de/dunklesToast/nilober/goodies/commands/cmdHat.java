package de.dunklesToast.nilober.goodies.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dunklesToast.nilober.goodies.Main;
import de.dunklesToast.nilober.goodies.messages.Messages;

public class cmdHat implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdHat(Main plugin) {
		this.plugin = plugin;
	}
	
	 public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
	        Player p = (Player)cs;
	        
	        if(args.length == 0){
	      if(p.getItemInHand().getType() != Material.AIR){
	        p.getInventory().setHelmet(p.getItemInHand());
	        p.sendMessage(ChatColor.translateAlternateColorCodes('&',Messages.getMessage("hat.newhat")));
	        	
	        return true;
	        	
	        }else{
	        	p.sendMessage(ChatColor.translateAlternateColorCodes('&',Messages.getMessage("hat.musthaveinhand")));
	        	return true;
	        }
	        }
	      
	        
	        if(args.length > 1){
	        	p.sendMessage(ChatColor.translateAlternateColorCodes('&',Messages.getMessage("general.toomuchargs")));
	      }
	      
	        return false;
	        }

}
