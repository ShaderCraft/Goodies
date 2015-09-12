package de.dunklesToast.nilober.goodies.commands;

import java.util.HashMap;





import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;


import org.bukkit.entity.Villager;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.util.Vector;

import de.dunklesToast.nilober.goodies.Main;
import de.dunklesToast.nilober.goodies.Utilitys.Laser;

public class cmdWayPoint implements CommandExecutor{

	HashMap<String,Object[]> list = new HashMap<String,Object[]>();


	

	private static Main plugin;
	
	public cmdWayPoint(Main plugin) {
		this.plugin = plugin;
	}
	

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) {
		 
		if(!(cs instanceof Player)){
			cs.sendMessage(Main.nocon);
		}
		
		else{
			
		
			Player p = (Player) cs;
			if(p.hasPermission("goodies.waypoint") || p.hasPermission("goodies.*")){

				if(args.length == 3){
					/*
					Bukkit.broadcastMessage("debug4");
					int x = Integer.parseInt(args[0]);
					int y = Integer.parseInt(args[1]);
					int z = Integer.parseInt(args[2]);
					Bukkit.broadcastMessage("debug5");
					Location loc = new Location(p.getWorld(), x, y , z);
					p.teleport(loc);
					Bukkit.broadcastMessage("debug6");
					ArmorStand a = loc.getWorld().spawn(loc,ArmorStand.class);
					a.setCustomName("Ziel von " + p.getName());
					a.setCustomNameVisible(true);
					a.setGravity(false);
					a.setVisible(false);

					Bukkit.broadcastMessage("debug7");
					
					 Laser laser = new Laser(p.getLocation());
                     laser.setTarget(a);
                    
                     Bukkit.broadcastMessage("debug8");
                     
                     Object[] o = new Object[2];
                     o[0] = a;
                     o[1] = laser;
					
                     
                     
                     */
					
					mkLaser(p, args);
					
					
				}
				
			}
			
		}
		
		return false;
	        }

	
	public static void mkLaser(Player p, String[] args){
		
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int z = Integer.parseInt(args[2]);
		Location loc = new Location(p.getWorld(), x, y , z).clone().add(0, 0, 0); 
		
		
		 Location armor = p.getLocation().clone().add(0, 250, 0);
        
        
         ArmorStand a = armor.getWorld().spawn(loc,ArmorStand.class);
         a.setGravity(false);
         a.setVisible(false);
         a.setCustomName("§4Ziel von §a" + p.getName());
         a.setCustomNameVisible(true);
        
         Laser laser = new Laser(loc);
         laser.setTarget(p);
        
         Object[] o = new Object[2];
         o[0] = a;
         o[1] = laser;
         
         p.sendMessage("" + loc);
         
         p.getLocation().distance(loc);
         
			}
	
	
	public static void removeLaser(ArmorStand a, Player p,Laser laser){

        ((ArmorStand)a).remove();
        laser.despawn(p);
		
	}
}
