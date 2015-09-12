package de.dunklesToast.nilober.goodies.listener;



import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import de.dunklesToast.nilober.goodies.Main;

public class CustomDMListener implements Listener {


	public CustomDMListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		
		if(p.getKiller() != null){
			Player k = p.getKiller();
		}
		
		if(e.getDeathMessage().contains("ground to hard")){
			e.setDeathMessage(p.getName() + " kannte den Boden näher kennen, als ihm Lieb war!");
		}
		if(e.getDeathMessage().contains("starved")){
			e.setDeathMessage(p.getName() + " wurde von einem Kaktus erstochen");
		}
		if(e.getDeathMessage().contains("was slain by")){
			e.setDeathMessage(p.getName() + " wurde von " + p.getKiller().getName() + " mit seinem " + p.getKiller().getInventory().getItemInHand().getItemMeta().getDisplayName() + " ermordert!");
		}

	
	}
}
