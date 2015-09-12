package de.dunklesToast.nilober.goodies.API;

import java.net.MalformedURLException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;

import de.dunklesToast.nilober.goodies.Main;
import de.dunklesToast.nilober.goodies.Utilitys.DownloadFavicon;
import de.dunklesToast.nilober.goodies.Utilitys.DownloadFile;
import de.dunklesToast.nilober.goodies.Utilitys.WayPointMaker;
import de.dunklesToast.nilober.goodies.messages.Messages;

public interface API {
	
	
	public static String getPrefix() {
		
		return Messages.getMessage("goodies.prefix");
	
	}
	
	public static int getVersion() {
		return Integer.parseInt(Main.getInstance().getDescription().getVersion());
	}
	
	public static void downloadFavicon(String server, CommandSender cs) {
		
		String url = "http://www.mcping.net/api/" + server + "/favicon.png";
        String filename = server.toLowerCase();
       
       
        try {
			DownloadFavicon.downloadFavicon(url, filename, cs);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void downloadFile(String url, String filename) {
        
        try {
			DownloadFile.downloadFile(url, filename);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public static void makeWaypoint(World w, int x, int y, int z, String target_name, LivingEntity Laser_Target, Location target_location){
		
		WayPointMaker.mkLaser(w, x, y, z, target_name, Laser_Target, target_location);
		
	}
}
