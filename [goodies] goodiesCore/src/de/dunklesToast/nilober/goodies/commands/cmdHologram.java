package de.dunklesToast.nilober.goodies.commands;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import de.dunklesToast.nilober.goodies.Main;
import de.dunklesToast.nilober.goodies.messages.Messages;

public class cmdHologram implements CommandExecutor{

		int i = 0;
	
		private Main plugin;
	
	public cmdHologram(Main plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 
		if(!(cs instanceof Player)){
			cs.sendMessage(Main.nocon);
		}else{
			
			Player p = (Player) cs;
		if(p.hasPermission("goodies.holo")){
			if(args.length == 0){
				p.sendMessage("§cUsage: /holo <text> §7| §c /holo rm <text from holo>");
			}else{
				
			if(args.length == 1){
				String text = ChatColor.translateAlternateColorCodes('&', args[0].toString());
				Location loc = p.getLocation();
				@SuppressWarnings("deprecation")
				ArmorStand stand = (ArmorStand) p.getWorld().spawnCreature(loc, EntityType.ARMOR_STAND);
				stand.setCustomName(text);
				stand.setCustomNameVisible(true);
				stand.setVisible(false);
				stand.setGravity(false);
				
				String msg = ChatColor.translateAlternateColorCodes('&',Messages.getMessage("holo.succes"));
				p.sendMessage(msg);
				
				
			}else{
				
				if(args.length == 2){
					if(args[0].equals("rm")){						
						for(Entity e : plugin.getServer().getWorld(p.getWorld().getName()).getEntities()){
							if(e instanceof ArmorStand){
								ArmorStand as = (ArmorStand) e;
								if(as.getCustomName() != null){
									if(as.getCustomName().equals(args[1])){
										as.remove();
										i++;
							}}}
						}
						if(i != 0){
						p.sendMessage("§eRemoved: " + i + " Holograms");
						i = 0;
						}else{
						p.sendMessage("§eThere were no Holograms matching §c" + args[1]);
						}
					}
				}
				
			}
			}
		}else{
			p.sendMessage(Main.noperm);
		}
		}
		return false;
	        }
	 
}
