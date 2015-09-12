package de.dunklesToast.nilober.goodies.commands;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import de.dunklesToast.nilober.goodies.Main;

public class cmdHelix implements CommandExecutor{

    @SuppressWarnings("unused")
	private Main plugin;
	
	public cmdHelix(Main plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 
		
		if(!(cs instanceof Player)){
			cs.sendMessage(Main.nocon);
		}else{
		
			Player p = (Player)cs;
			if(args.length == 0){
				p.sendMessage("§aSpawning Default Helix...");
				p.sendMessage("§2Modify comes with the next update");
				
				Location loc = p.getLocation();
			    int radius = 1;
			    for(double y = 0; y <= 50; y+=0.05) {
			        double x = radius * Math.cos(y);
			        double z = radius * Math.sin(y);

			        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.FLAME, false, (float) (loc.getX() + x), (float) (loc.getY() + y), (float) (loc.getZ() + z), 0, 0, 0, 0, 1, null);
			        	
			        
			        for(Player pp : Bukkit.getOnlinePlayers()){
			            ((CraftPlayer) pp).getHandle().playerConnection.sendPacket(packet);
			        }
			    }

			
					}}
		return false;
	     
	}
}
