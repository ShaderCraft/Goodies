package de.dunklesToast.nilober.goodies.listener;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.dunklesToast.nilober.goodies.Main;
import de.dunklesToast.nilober.goodies.messages.Messages;

public class JoinListener implements Listener {


	private Main plugin;

	public JoinListener(Main plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
	if(plugin.getConfig().getBoolean("join-message") == true){
		e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', Messages.getMessage("join.message").replace("%Player", p.getName()).replace("%Servername", plugin.getConfig().getString("servername"))));
		
		}
	

	}
}
