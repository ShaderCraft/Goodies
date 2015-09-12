package de.dunklesToast.nilober.goodies.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import de.dunklesToast.nilober.goodies.Main;

public class cmdInfobook implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdInfobook(Main plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 
		Player p = (Player)cs;
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bmeta = (BookMeta) book.getItemMeta();
		bmeta.addPage("§aWelcome to the Info Book! Here you can find many informations about this Server");
		bmeta.addPage("§1OnlinePlayers: §2        " + Bukkit.getOnlinePlayers().size()
					 +"§1MaxPlayers:         §2  " + Bukkit.getMaxPlayers()
					 +"§1BannedPlayers:§2        " + Bukkit.getBannedPlayers().size()
					 +"§1BukkitVersion:§2      " + Bukkit.getVersion().replaceAll(".+ \\(MC: ", "").replace(")", "")
					 +"§1InstalledPlugins:§2       " + Bukkit.getPluginManager().getPlugins().length
					 +"§aWe´re going to improve this!");
					 
		book.setItemMeta(bmeta);
			p.getInventory().addItem(book);
		
		return false;
	        }
	 
}
