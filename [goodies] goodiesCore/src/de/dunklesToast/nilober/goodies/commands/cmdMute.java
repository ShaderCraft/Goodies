package de.dunklesToast.nilober.goodies.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dunklesToast.nilober.goodies.Main;
import de.dunklesToast.nilober.goodies.messages.Messages;

public class cmdMute implements CommandExecutor{

	
	
    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdMute(Main plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		if(!(cs instanceof Player)){
			cs.sendMessage("§cYou can only use this command as Player");
			return true;
		}else if(cs.hasPermission("goodies.mute") || cs.hasPermission("goodies.*")){
			
			
			Player p = (Player) cs;
			if(args.length == 0){
				
				p.sendMessage("§4Use: /mute <player> (reason)");
			}if(args.length == 1){
				Player target = Bukkit.getPlayerExact(args[0]);
				if(Main.muted != null){
				if(Main.muted.contains(target)){
					p.sendMessage(target.getName() + " §ais now unmuted!");
					target.sendMessage(p.getName() + " has unmuted you!");
					Main.muted.remove(target);
				}else{
					Main.muted.add(target);
					p.sendMessage("§4You muted " + target.getName());
					target.sendMessage("§4You were muted by " + p.getName());
				}
			}
			}
			if(args.length == 2){
				Bukkit.broadcastMessage("1");
				Player target = Bukkit.getPlayerExact(args[0]);
					String reason = args[1];
					if(Main.muted != null){
					if(Main.muted.contains(target)){
						p.sendMessage(target.getName() + " §ais now unmuted!");
						target.sendMessage(p.getName() + " has unmuted you!");
						Main.muted.remove(target);
					}else{
						Main.muted.add(target);
						p.sendMessage("§4You muted " + target.getName() + " for reason: " + reason);
						target.sendMessage("§4You were muted by " + p.getName() + " for §e" + reason);
					}
					}
			}
			
		}else{
			cs.sendMessage(Messages.getMessage("general.noperm"));
		}
		
		
		
		return false;
	        }
	 
}
