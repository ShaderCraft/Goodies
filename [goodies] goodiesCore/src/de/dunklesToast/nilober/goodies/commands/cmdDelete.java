package de.dunklesToast.nilober.goodies.commands;

import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.dunklesToast.nilober.goodies.Main;

public class cmdDelete implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdDelete(Main plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 
		if(args.length != 2){
			cs.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eUsage: /delete plugin <FILENAME>"));
			cs.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eThis command does not work on Windows Servers, because Windows dont let us remove the Plugin because its running on the Server :("));
			cs.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eLinux dont care."));
		}
		
		if(args.length == 2){
			
			if(System.getProperty("os.name").contains("Windows")){
				cs.sendMessage("Sorry, this command does not work on Windows. We´re sorry.");
				return true;
			}
			cs.sendMessage(System.getProperty("os.name"));
			cs.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eStart deleting &c" + args[1]));
			File filefordelete = new File("plugins/" + args[1]);
			if(filefordelete.exists()){
				
				try {
					filefordelete.setWritable(true);
					filefordelete.delete();
					String file = filefordelete.getAbsolutePath().toString();
					cs.sendMessage(file);
					cs.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eSuccesfully removed " + args[1] + ". Please reload the Server!"));
				} catch (Exception e) {
					cs.sendMessage("There was an error");
				}
				
				
				
			}else{
				cs.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d>>> &eCant find this file"));
			}
		}
		
		return false;
	        }
	 
}
