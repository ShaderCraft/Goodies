package de.dunklesToast.nilober.goodies.listener;


import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import de.dunklesToast.nilober.goodies.Main;

public class NoArmorOnHoloListener implements Listener {


	@SuppressWarnings("unused")
	private Main plugin;

	public NoArmorOnHoloListener(Main plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	
	public void manipulate(PlayerArmorStandManipulateEvent e) {
	
		if(!e.getRightClicked().isVisible()) {
			
			e.setCancelled(true);
			
		}
	}
}
