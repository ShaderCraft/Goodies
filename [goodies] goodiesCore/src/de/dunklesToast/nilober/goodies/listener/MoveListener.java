package de.dunklesToast.nilober.goodies.listener;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.dunklesToast.nilober.goodies.Main;

public class MoveListener implements Listener {


	public MoveListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		e.getPlayer();
		
		
		
		
		List<String> nbe = new ArrayList<String>();
		File file = new File("plugins/goodies.yml", "vnames.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("names", nbe);
	
	}
}
