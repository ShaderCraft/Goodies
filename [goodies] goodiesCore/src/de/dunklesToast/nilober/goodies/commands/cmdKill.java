package de.dunklesToast.nilober.goodies.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dunklesToast.nilober.goodies.Main;

public class cmdKill implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdKill(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
	        Player p = (Player)cs;
	        if(args.length == 0){
	        
	        	p.setHealth(0D);
	        	p.sendMessage("§aOh no.");
	        	Bukkit.broadcastMessage(p.getName() + " took his own life");


	        	
	        }if(args.length == 1){
	        	
	        	
	        	Player target = Bukkit.getPlayer(args[0]);
	        	if(target != null){
	        	target.setHealth(0D);
	        	Bukkit.broadcastMessage(args[0] + "´s life was taken by" + p.getName());
	        	target.sendMessage("§aYou were killed by " + p.getName());
	        	}else{
	        		p.sendMessage("The Player " + args[0] + " isn´t online yet.");
	        	}
	        	
	        	return true;
	        }
	        return false;
	        }

}
