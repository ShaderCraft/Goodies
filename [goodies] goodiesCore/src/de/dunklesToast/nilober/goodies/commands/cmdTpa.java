package de.dunklesToast.nilober.goodies.commands;

import java.util.ArrayList;
import java.util.HashMap;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dunklesToast.nilober.goodies.Main;

public class cmdTpa implements CommandExecutor{
	
	
	private Main plugin;
	public cmdTpa(Main plugin){
		
		this.plugin = plugin;
	}
	private HashMap<Player, Integer> time = new HashMap<Player, Integer>();
	private ArrayList<Player> ab = new ArrayList<Player>();
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if (s instanceof Player){
			Player p = (Player)s;
			if (args.length == 0){
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bHelp&c>>>>>>>>>>>>>>>>"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &e/tpa &c<Player>"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bHelp&c>>>>>>>>>>>>>>>>"));
				
			} 
			if (args.length == 1){
				if (Bukkit.getOfflinePlayer(args[0]).isOnline()){
					
					if (Bukkit.getPlayer(args[0]) == p){
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &eYou can not send a Tp Request to yourself."));
					} else {
						Player p2 = Bukkit.getPlayer(args[0]);
						
						if (Main.tpa.containsKey(p2)){
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &eThe Player have already a Tp request."));
						} else {
							if (this.ab.contains(p)){
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> You can use Tpa again in &e" + this.time.get(p) + "&c."));
							} else {
								p2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &e" + p.getDisplayName() + " want to teleport to you."));
								p2.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &e You can accept with &c/tpaccept &e or deny with &c/tpdeny"));
								Main.tpa.put(p2, p);
								this.ab.add(p);
								this.time.put(p, 5);
								Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable(){
									@Override
									public void run() {
										int i = 5;
										i--;
										cmdTpa.this.time.replace(p, i);
										
									}
									
								}, 5*20L, 20L);
								Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable(){

									@Override
									public void run() {
										cmdTpa.this.ab.remove(p);
										
									}
									
								}, 5*20L);
							}
							
						}
					}
					
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bHelp&c>>>>>>>>>>>>>>>>"));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &eThe Player is not on this Server."));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bHelp&c>>>>>>>>>>>>>>>>"));
					
				}
			}
		} else {
			s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &bPlayer Command only!"));
		}
		
		
		return true;
	}

	
	
}
