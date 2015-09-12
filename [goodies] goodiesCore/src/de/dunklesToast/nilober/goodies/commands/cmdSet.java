package de.dunklesToast.nilober.goodies.commands;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.dunklesToast.nilober.goodies.Main;

public class cmdSet implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdSet(Main plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 	
		if(args[0].equalsIgnoreCase("favicon")){
			String url = "http://www.mcping.net/api/" + args[1] + "/favicon.png";
			String ext = FilenameUtils.getExtension(url);
			String fullname = "server-icon."+ext;
			
			
			try {
				URL ur = new URL(url); //The URL for the Icon
				
				
				File finishedfile = new File(fullname);  //The new Icon
				
				
				
				File oldFav = new File("OldServerIcon_" + UUID.randomUUID() + ".png");
				
				
					finishedfile.renameTo(oldFav); //rename old Favicon
					
					cs.sendMessage(ChatColor.COLOR_CHAR + "oOld Favicon was copied to §4" + oldFav.getName());
				
				FileUtils.copyURLToFile(ur,finishedfile);
				
				cs.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> §eRELOADING SERVER IN 5 SECONDS!"));
				
				Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
					
					@Override
					public void run() {
						cs.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eReloading Server."));
						Main.getInstance().getServer().dispatchCommand(Bukkit.getConsoleSender(), "reload");
						
					}
				}, 100L);
			} catch (IOException e) {
				e.printStackTrace();
					}
				}
				

  		
		
		return false;
	        }
	 
}
