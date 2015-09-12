package de.dunklesToast.nilober.goodies.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.dunklesToast.nilober.goodies.Main;

public class cmdOp implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdOp(Main plugin) {
		this.plugin = plugin;
	}
	

	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 if(cs == Bukkit.getConsoleSender()){
			 
			 //CONSOLE
			 
			 ConsoleCommandSender c = Bukkit.getConsoleSender();
			 if(args.length == 0){
				 c.sendMessage("§cUsage: /op <player>");
				 return true;
			 }
			 Player target = Bukkit.getPlayer(args[0]);
	        	if(target != null){
	        		if(target.isOp()){
	        			c.sendMessage(target.getName() + " is already OP!");
	        				return true;
	        		}
	        		else{
	        			target.setOp(true);
	        			target.sendMessage("You are now an Operator!");
	        			c.sendMessage("§aYou have succesfully opped " + args[0]);
	        			target.setOp(true);
							return true;
	        		}
	        		
	        	}
	        	if(target == null){
	        		c.sendMessage("§cThere was an error while opping " + args[0]);
	        		c.sendMessage("§cHe is offline!");
						return true;
	        	}
		 }
		 
		 //PLAYER
		 
		 else{
		 
			 
		 Player p = (Player)cs;
	
	        if(args.length == 0){
	        
	        	p.sendMessage("§4Usage: /op <player>");
	        	

	        }if(args.length == 1){
	        	if(p.hasPermission("goodies.op")){
	        	Player target = Bukkit.getPlayer(args[0]);
	        	if(target != null){
	        		if(target.isOp()){
	        			p.sendMessage(target.getName() + " is already OP!");
	        			return true;
	        		}
	        		
	        		else{
	        			target.setOp(true);
	        			target.sendMessage("You are now an Operator!");
	        			p.sendMessage("You opped " + target.getName());
	        				return true;
	        			}
	        		}
	        	
	        	if(target == null){
	        		p.sendMessage("This Player is not online!");
					return true;
	        	}
	        }else{
	        	p.sendMessage("§4You don´t have enough permission to execute this command!");
	        }
	      }
	        		return true;
	 }
		return false;
   }
	 
}
