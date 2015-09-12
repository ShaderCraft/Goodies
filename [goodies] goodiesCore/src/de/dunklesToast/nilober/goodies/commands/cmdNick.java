package de.dunklesToast.nilober.goodies.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dunklesToast.nilober.goodies.Main;

public class cmdNick implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdNick(Main plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 
		if(!(cs instanceof Player)){
			cs.sendMessage("Player only!");
		}else{
			Player p = (Player) cs;
			if(args.length == 1){
				p.setCustomName(args[0]);
				p.setPlayerListName(args[0]);
			}
		}
		
		return false;
	        }
	 
}
