package de.dunklesToast.nilober.goodies.Utilitys;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.LivingEntity;


public class WayPointMaker {

	public static void mkLaser(World w, int x, int y, int z, String target_name, LivingEntity Laser_Target, Location target_location){
		
		
		 Location loc = new Location(w, x, y , z).clone().add(0, 0, 0); 
		
		
		 Location armor = target_location;
        
        
         ArmorStand a = armor.getWorld().spawn(loc,ArmorStand.class);
         a.setGravity(false);
         a.setVisible(false);
         a.setCustomName(target_name);
         a.setCustomNameVisible(true);
        
         Laser laser = new Laser(loc);
         laser.setTarget(Laser_Target);
        
         Object[] o = new Object[2];
         o[0] = a;
         o[1] = laser;
         
         
         
         
         
			}
	
}
