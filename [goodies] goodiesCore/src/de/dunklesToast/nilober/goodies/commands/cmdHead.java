package de.dunklesToast.nilober.goodies.commands;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import de.dunklesToast.nilober.goodies.Main;
import de.dunklesToast.nilober.goodies.messages.Messages;

public class cmdHead implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdHead(Main plugin) {
		this.plugin = plugin;
	}
	

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 if(cs == Bukkit.getConsoleSender()){
		 
			 cs.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.nocon));
		 
		 }else{	 
			 
		 Player p = (Player)cs;
	
		 
		 if(p.hasPermission("goodies.head") || p.hasPermission("goodies.*")){
		 
	        if(args.length == 0){
	        
	        	p.sendMessage("§2Here is your head!");

	        	String name = ChatColor.translateAlternateColorCodes('&', Messages.getMessage("head.local"));
    			
	        	
    			ItemStack freunde = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
    			SkullMeta freundemeta = (SkullMeta) freunde.getItemMeta();
    			freundemeta.setOwner(p.getName());
    			freundemeta.setDisplayName(name);
    			freunde.setItemMeta(freundemeta);
    			p.getInventory().addItem(freunde);

	        }if(args.length == 1){
	        	
	        	
	        	
	        		
	        		OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
	        		
	        	
	        		if(target == null){
	        	
	        			
	        				p.sendMessage(Main.epre + "This Player does not exists :(");
	        	
	        				
	        		}else{
	        			
	        			String name = ChatColor.translateAlternateColorCodes('&', Messages.getMessage("head.extern")).replace("%headowner", target.getName());
	        			
	        			
	        			ItemStack freunde = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	        			SkullMeta freundemeta = (SkullMeta) freunde.getItemMeta();
	        			freundemeta.setOwner(target.getName());
	        			freundemeta.setDisplayName(name);
	        			freunde.setItemMeta(freundemeta);
	        			p.getInventory().addItem(freunde);
	        					return true;
	        			}
	        		}
	        	
		 }else{
			 p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.noperm));
		 }
	 }
		 			return false;
   }
} 
