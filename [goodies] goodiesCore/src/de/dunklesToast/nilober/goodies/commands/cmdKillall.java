package de.dunklesToast.nilober.goodies.commands;

import java.util.Iterator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import de.dunklesToast.nilober.goodies.Main;
import de.dunklesToast.nilober.goodies.messages.Messages;

public class cmdKillall implements CommandExecutor{

    private Main plugin;
	
	public cmdKillall(Main plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 
		if(cs instanceof Player){
			Player p = (Player)cs;
			if(p.isOp()){
				
				
				 String world = ((Entity)cs).getWorld().getName();
			        for (Iterator<Entity> iterator = plugin.getServer().getWorld(world).getEntities().iterator(); iterator.hasNext();)
			        {
			          Entity entity = (Entity)iterator.next();
			          if ((entity.getType() == EntityType.PLAYER) && (entity.getType() != EntityType.ITEM_FRAME) && (entity.getType() != EntityType.MINECART)) {
			            entity.remove();
			          }
			        }
				
			}else{
				p.sendMessage(Messages.getMessage("general.noperm"));
			}
		}
		
		return false;
	        }
	 
}
