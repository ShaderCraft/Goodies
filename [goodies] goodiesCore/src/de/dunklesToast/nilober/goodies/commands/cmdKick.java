package de.dunklesToast.nilober.goodies.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.dunklesToast.nilober.goodies.Main;

public class cmdKick implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdKick(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 /*if(cs == Bukkit.getConsoleSender()){
			 ConsoleCommandSender c = Bukkit.getConsoleSender();
			 if(args.length == 0){
				 c.sendMessage("§cUsage: /kick <player> <reason>");
				 return true;
			 }
			 if(args.length == 1){
			 Player target = Bukkit.getPlayer(args[0]);
	        	if(target != null){
	        		target.setOp(true);
	        		if(args[1] != null){
	        		target.kickPlayer(args[1]);
	        		//c.sendMessage("§aYou have succesfully kicked Player " + args[0] + " for " + args [1]);
	        		c.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.getMessage("kick.succes").replace("%Player", args[0]).replace("%Reason", args[1])));
					return true;
	        		}
	        	else{
	        			target.kickPlayer("You were kicked from this Server!");
	        		}
	        		
	        	}
	        	if(target == null){
	        		c.sendMessage("§cThere was an error while kicking " + args[0]);
	        		c.sendMessage("§cHe is offline!");
					return true;
	        	}
	        	}
		 }*/
		
		if(cs == Bukkit.getConsoleSender()){
			ConsoleCommandSender c = Bukkit.getConsoleSender();
			if(args.length == 0){
				c.sendMessage("§cUsage /kick <player> <reason>");
			}
			if(args.length == 1){
				Player target = Bukkit.getPlayerExact(args[0]);
				
				if(target == null){
					c.sendMessage("The Player is offline!");
				}else{
					target.kickPlayer("You were kicked!");
				}
				
			}
		}
	 
		 else{
		 
		 Player p = (Player)cs;
	
	        if(args.length == 0){
	        
	        	p.sendMessage("§4Usage: /kick <player> <reason>");
	        	

	        }if(args.length == 1){
	        	if(p.hasPermission("goodies.op") || p.hasPermission("goodies.*") || p.hasPermission("goodies.kick")){
	        	Player target = Bukkit.getPlayer(args[0]);
	        	if(target != null){
	        		if(args[1] != null){
	        		target.kickPlayer(args[1]);
	        		p.sendMessage("§aYou have succesfully kicked Player " + args[0] + " for " + args [1]);
					return true;
					
	        		}
	        		else
	        		{
	        			target.kickPlayer("You were kicked from this Server!");
	        		}
					
	        		return true;
	        		}
	        	
	        	if(target == null){
	        	
	        		p.sendMessage("This Player is not online, so you cant kick him :(");
					
	        		return true;
	        	}
	        }
	        }else{
	        	
	        
	        	if(args[0] == p.getName()){
	        		p.sendMessage("You cannot kick yourself!");
	        	}else{
	        		p.sendMessage("§e" + args[0] + " left the Server!");
	        	}
	        }
	        	return true;
	 }
		return false;
	        }
	 
}
