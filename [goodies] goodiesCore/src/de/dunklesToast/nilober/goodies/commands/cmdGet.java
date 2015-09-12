package de.dunklesToast.nilober.goodies.commands;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dunklesToast.nilober.goodies.Main;
import de.dunklesToast.nilober.goodies.Utilitys.UUIDFetcher;
import de.dunklesToast.nilober.goodies.Utilitys.Update;

public class cmdGet implements CommandExecutor{

	private Main main;
	public cmdGet(Main main) {
		this.main = main;
	}

	@SuppressWarnings({ "deprecation" })
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		
		if (args.length < 1){
			if ( s instanceof Player){
				Player p = (Player)s;
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bHelp&c>>>>>>>>>>>>>>>>"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &e/get uuid <player name>"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &e/get lastname <player name>"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &e/get plugin <url>"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bHelp&c>>>>>>>>>>>>>>>>"));
				return true;
			} else {
				s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bHelp&c>>>>>>>>>>>>>>>>"));
				s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &e/get uuid <player name>"));
				s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &e/get lastname <player name>"));
				s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &e/get plugin <url>"));
				s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bHelp&c>>>>>>>>>>>>>>>>"));
				return true;
			}
		} else if (args.length >= 1){
			if (args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("update")){
				
				s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> &eChecking for new Version..."));
				String post = "version=" + Main.currentversion;
				s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> &eCurrent Plugin Version: &b" + Main.currentversion));
				try {
					String newv = new String(Update.checkforupdate("http://shadercraft.de/api/shaderupdate.php", post.getBytes()));
					if (newv.equalsIgnoreCase(Main.currentversion)){
						s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> &eNo Update available!"));
					} else {
						s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> &eUpdate available! Version: &b" + newv));
						String postnewversion = "version=" + newv;
						String newdownload = new String(Update.checkforupdate("http://shadercraft.de/api/downloadlink.php", postnewversion.getBytes()));
						s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> &eYou can download this version here: &b" + newdownload));
					}
					
					
				} catch (Exception e) {
					s.sendMessage(Main.epre + "Sorry, we encountered an Error while Checking for an Update! Check the console for more informations!");
					e.printStackTrace();
					Bukkit.getConsoleSender().sendMessage(Main.epre + "Please go to §awww.goodies.com/errors");
				}
				
				
				
			}
			
			if (args.length == 2){
				if (args[0].equalsIgnoreCase("uuid")){
					if (s instanceof Player){
						if (Bukkit.getOfflinePlayer(args[1]).isOnline() == false){
							Player p = (Player)s;
							p.sendMessage("");
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bUUID&c>>>>>>>>>>>>>>>>"));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> Name: &e" + args[1]));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> UUID: &a" + UUIDFetcher.getUUID(args[1])));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bUUID&c>>>>>>>>>>>>>>>>"));
						} else {
							Player p = (Player)s;
							p.sendMessage("");
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bUUID&c>>>>>>>>>>>>>>>>"));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> Name: &e" + args[1]));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> UUID: &a" + this.main.getServer().getPlayer(args[1]).getUniqueId()));
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bUUID&c>>>>>>>>>>>>>>>>"));
						}
					} else {
						if (Bukkit.getOfflinePlayer(args[1]).isOnline() == false){
							s.sendMessage("");
							s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bUUID&c>>>>>>>>>>>>>>>>"));
							s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> Name: &e" + args[1]));
							s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> UUID: &a" + UUIDFetcher.getUUID(args[1])));
							s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bUUID&c>>>>>>>>>>>>>>>>"));
						} else {
							s.sendMessage("");
							s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bUUID&c>>>>>>>>>>>>>>>>"));
							s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> Name: &e" + args[1]));
							s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> UUID: &a" + this.main.getServer().getPlayer(args[1]).getUniqueId()));
					s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bUUID&c>>>>>>>>>>>>>>>>"));
						}
					}
				}
				if (args[0].equalsIgnoreCase("lastname")){
					s.sendMessage("");
					s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bLast Name&c>>>>>>>>>>>>>>>>"));
					s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> Current Name: &e" + args[1]));
					String uuid = UUIDFetcher.getUUID(args[1]);
					ArrayList<String> ln = UUIDFetcher.getLastName(uuid);
					int i2 = 0;
					for (int i = 0; i < ln.size(); i++){
						i2++;
						if (ln.size() == 1){
							s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> &eThis User never changed his name."));
						} else {
							if (i+1 == ln.size()){
							
							} else {
								if (i2 == 1){
									s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>>&c First Name: &e" + ln.get(i)));
								} else {
									s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>>> " + i2 + " Name: &e" + ln.get(i)));
								}
							}
						}
					}
					s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c<<<<<<<<<<<<<<<<&bLast Name&c>>>>>>>>>>>>>>>>"));
				}
				if (args[0].equalsIgnoreCase("plugin")){
					s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eStart Downloading..."));
					String name = FilenameUtils.getBaseName(args[1]);
					String ext = FilenameUtils.getExtension(args[1]);
					if (ext.equalsIgnoreCase(".jar")){
						s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4>>> &cThe File must be a jar."));
						s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eDone."));
						return true;
					} else {
						String fullname = name+"."+ext;
						try {
							URL ur = new URL(args[1]);
							File finishedfile = new File("" + fullname);
							FileUtils.copyURLToFile(ur,finishedfile);
				            
				            s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eDownload Done!"));
				            s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eFile Path: &c" + finishedfile.getAbsolutePath()));
				            s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eMoving File to Plugin Direction..."));
				            File ff2 = new File("plugins/" + fullname);
							if (finishedfile.renameTo(new File("plugins/" + finishedfile.getName()))){
								s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eSuccess Moved!"));
								s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eNew Path: &c" + ff2.getAbsolutePath()));
								s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> §eRELOADING SERVER IN 5 SECONDS!"));
								
								Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
									
									@Override
									public void run() {
										s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eReloading Server."));
										Main.getInstance().getServer().dispatchCommand(Bukkit.getConsoleSender(), "reload");
										
									}
								}, 100L);
								

							} else {
								s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eDownload failed..."));
								s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eVisit §6goodies.com/dl§e for informations!"));
							}
				        } catch (IOException e) {
				            e.printStackTrace();
				            s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eError"));
				            s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eThe URL must be a §cdirect path §eto a file."));
				            return true;
				        }
					}
					
					
					
					
					
					
					
				}
			
				
				
			}
			
		}
		return true;
	}

}
