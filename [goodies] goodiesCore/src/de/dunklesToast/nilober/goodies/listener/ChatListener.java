package de.dunklesToast.nilober.goodies.listener;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import de.dunklesToast.nilober.goodies.Main;

@SuppressWarnings("deprecation")
public class ChatListener implements Listener {


	@SuppressWarnings("unused")
	private Main plugin;

	public ChatListener(Main plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onChat(PlayerChatEvent e){
		Player p = e.getPlayer();
		if(Main.muted.contains(p)){
			e.setCancelled(true);
			p.sendMessage("§4Sorry, you are muted!");
		}
	

	}
}
