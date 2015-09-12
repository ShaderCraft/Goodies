package de.dunklesToast.nilober.goodies.listener;


import java.util.List;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.dunklesToast.nilober.goodies.Main;

public class WayPointListener implements Listener {


	public WayPointListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public static void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		
		List<Entity>  nbe = p.getNearbyEntities(10, 10, 10);
		for (Entity ent : nbe){
			if(ent instanceof ArmorStand){
				ArmorStand as = (ArmorStand) ent;
					if(as.getCustomName() != null || as.getCustomName().equals("§4Ziel von §a" + p.getName())){
						as.remove();
						p.sendMessage("Sie haben ihr Ziel erreicht!");
						
						
					}
			}
		
	
	
		}
	}
}
