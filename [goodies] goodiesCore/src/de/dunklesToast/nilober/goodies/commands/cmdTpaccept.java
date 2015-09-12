package de.dunklesToast.nilober.goodies.commands;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dunklesToast.nilober.goodies.Main;

public class cmdTpaccept implements CommandExecutor{

	private Main plugin;
	public cmdTpaccept(Main plugin){
		
		this.plugin = plugin;
	}
	

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if (s instanceof Player){
			Player p = (Player)s;
			if (args.length == 0){
				if (Main.tpa.containsKey(p)){
					//s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>&e You have one open request from &c"+this.plugin.tpa.get(p).getDisplayName()+"&e."));
					if (Main.tpa.get(p).isOnline()){
						if (Main.tpa.containsKey(p)){
							Player p2 = Main.tpa.get(p);
							p2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> Teleport..."));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &eTeleport request accepted."));
							Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable(){

								@Override
								public void run() {
									p2.getWorld().playEffect(p2.getLocation(), Effect.ENDER_SIGNAL, 20);
									p2.getWorld().playSound(p2.getLocation(), Sound.ENDERMAN_TELEPORT, 10, 10);
									p2.teleport(p);
									Main.tpa.remove(p);
									p2.getWorld().playEffect(p2.getLocation(), Effect.ENDER_SIGNAL, 20);
									p2.getWorld().playSound(p2.getLocation(), Sound.ENDERMAN_TELEPORT, 10, 10);
								}
								
							}, 20L);
						} else {
							s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>&e You have not a Tp request!"));
						}
						
						
						
						
						
					} else {
						if (Main.tpa.containsKey(p)){
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>&e The player is not on the Server. The request was removed."));
							Main.tpa.remove(p);
						} else {
							s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>&e You have not a Tp request!"));
						}
						
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


