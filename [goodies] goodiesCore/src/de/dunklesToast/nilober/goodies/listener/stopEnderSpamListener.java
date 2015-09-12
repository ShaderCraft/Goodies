package de.dunklesToast.nilober.goodies.listener;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

import de.dunklesToast.nilober.goodies.Main;

public class stopEnderSpamListener implements Listener {

	List<Player> stop = new ArrayList<Player>();

	
	private Main plugin;

	public stopEnderSpamListener(Main plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void launchevent(ProjectileLaunchEvent e) {
		
		Long cd = plugin.getConfig().getLong("cooldown")*20;
		
		if(e.getEntity().getShooter() instanceof Player){
			
			Player p = (Player) e.getEntity().getShooter();
				if(e.getEntityType() == EntityType.ENDER_PEARL){
					if(stop.contains(p)){
						e.setCancelled(true);
						p.sendMessage("§d>>> §ePlease wait some seconds before throw a new Pearl");
						p.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
					}else{
						stop.add(p);
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
							
							@Override
							public void run() {
								stop.remove(p);
								
							}
						}, cd);
					}
				}
		}
		
	}
}
