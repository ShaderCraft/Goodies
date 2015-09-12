package de.dunklesToast.nilober.goodies.commands;

import java.io.File;
import java.net.MalformedURLException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;








import de.dunklesToast.nilober.goodies.Main;
import de.dunklesToast.nilober.goodies.Utilitys.DownloadFavicon;
import de.dunklesToast.nilober.goodies.Utilitys.ErrorLED;

public class cmdFavicon implements CommandExecutor{

	
    public cmdFavicon(Main plugin) {
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 
		if(args.length == 1){
		 	
			try {
				//final URL url = new URL("");
				String url = "http://www.mcping.net/api/" + args[0] + "/favicon.png";
		        String filename = args[0].toLowerCase();
		        cs.sendMessage(">>> Downloading Favicon from " + args[0]);
		        
		        
		        DownloadFavicon.downloadFavicon(url, filename,  cs);
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			return true;
		}	
		
		if(args.length == 2){
		 	
			if(args[0].equals("clone")){
			
			try {
				//final URL url = new URL("");
				String url = "http://www.mcping.net/api/" + args[0] + "/favicon.png";
		        String filename = args[0];
		        String location = args[0] + filename;
		        new File(location);
		        cs.sendMessage("dsfb");
		       
		        DownloadFavicon.downloadFavicon(url, filename, cs);
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			}
			return true;
		}		
		return false;
		
		
		
	        }
	 
}
