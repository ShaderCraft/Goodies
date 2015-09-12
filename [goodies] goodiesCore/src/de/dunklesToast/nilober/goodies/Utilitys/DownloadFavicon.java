package de.dunklesToast.nilober.goodies.Utilitys;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.command.CommandSender;

import de.dunklesToast.nilober.goodies.Main;

public interface DownloadFavicon {


	public static void downloadFavicon(String url, String filename, CommandSender cs) throws MalformedURLException{
		String name = filename;
		String ext = FilenameUtils.getExtension(url);
		String fullname = name+"."+ext;

		try {
			URL ur = new URL(url);
			File finishedfile = new File(Main.getPlugin(Main.class).getDataFolder() + "/favicons/" + fullname);
			FileUtils.copyURLToFile(ur,finishedfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*if(clone = true){
		try {
			URL ur = new URL(url);
			File finishedfile = new File(FilenameUtils.getBaseName(url));
			File oldFav = new File("OldServerIcon.png");
			if(finishedfile.exists()){
				finishedfile.renameTo(oldFav);
				cs.sendMessage(ChatColor.MAGIC + "Old Favicon was copied to §4OldFavicon.png ");
				
			}
			FileUtils.copyURLToFile(ur,finishedfile);
		} catch (IOException e) {
			e.printStackTrace();
				}
			}*/
		}
	
}