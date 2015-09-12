package de.dunklesToast.nilober.goodies.API;



import java.net.MalformedURLException;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import de.dunklesToast.nilober.goodies.Main;
import de.dunklesToast.nilober.goodies.Utilitys.DownloadFavicon;
import de.dunklesToast.nilober.goodies.Utilitys.DownloadFile;
import de.dunklesToast.nilober.goodies.messages.Messages;

public class GoodiesAPI extends JavaPlugin {

    @SuppressWarnings("unused")
	private Main plugin;
	
	public GoodiesAPI(Main plugin) {
		this.plugin = plugin;
	}
	
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
	
}
