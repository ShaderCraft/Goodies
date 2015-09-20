package de.dunklesToast.nilober.goodies.Extra;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

import de.dunklesToast.nilober.goodies.Main;

public class TNTReg implements Listener{
	
	public static List<String> entitys = new ArrayList<String>();
	public static List<EntityType> en2 = new ArrayList<EntityType>();
	public static boolean all;
	public static boolean drop;
	public HashMap<Entity, Integer> task = new HashMap<Entity, Integer>();
	@EventHandler
	public void onExplode(EntityExplodeEvent e){
		Entity en = e.getEntity();
		
		if (this.all == true){
			List<Block> blocks = new ArrayList<Block>();
			blocks.addAll(e.blockList());
			
			List<Location> locs = new ArrayList<Location>();
			List<Material> mat = new ArrayList<Material>();
			List<Byte> bt = new ArrayList<Byte>();
		
			Collections.sort(blocks, new Comparator<Block>() {

	            @Override
	            public int compare(Block b1, Block b2) {
	                int y1 = b1.getY();
	                int y2 = b2.getY();
	                if(y1 < y2) {
	                    return -1;
	                } else if(y1 == y2) {
	                    return 0;
	                }
	                return 1;
	            }
	           
	        });
			for (int i = 0; i < blocks.size(); i++){
				locs.add(blocks.get(i).getLocation());
			}
			e.blockList().clear();
			for (int i2 = 0; i2 < locs.size(); i2++){
				mat.add(locs.get(i2).getBlock().getType());
				bt.add(locs.get(i2).getBlock().getData());
			}
			for (int i4 = 0; i4 < locs.size(); i4++){
				if (drop) {
					locs.get(i4).getBlock().breakNaturally(new ItemStack(mat.get(i4)));
				} else {
					locs.get(i4).getBlock().setType(Material.AIR);
				}
			}
			
			 this.task.put(en, Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable(){
				int i3;
				@Override
				public void run() {
					if (i3 < locs.size()){
						
						locs.get(i3).getBlock().setType(mat.get(i3));
						locs.get(i3).getBlock().setData(bt.get(i3));
						locs.get(i3).getBlock().getLocation().getWorld().playEffect(locs.get(i3), Effect.ENDER_SIGNAL, 1);
						locs.get(i3).getBlock().getLocation().getWorld().playSound(locs.get(i3), Sound.ENDERMAN_TELEPORT,(float) 1, (float) 1);
						i3++;
					} else {
						
						for (int i33 = 0; i33 < locs.size(); i33++){
							locs.get(i33).getBlock().setType(mat.get(i33));
							locs.get(i33).getBlock().setData(bt.get(i33));
						}
						locs.clear();
			            mat.clear();
			            bt.clear();
			            Bukkit.getScheduler().cancelTask(task.get(en));
			            task.remove(en);
			            en.getLocation().getBlock().getWorld().playEffect(en.getLocation().getBlock().getLocation(), Effect.ENDER_SIGNAL, 1);
						
					}
					
				}
				
			}, 3*20L, 1L));
		} else {
			if (this.en2.contains(en.getType())){
				List<Block> blocks = new ArrayList<Block>();
				blocks.addAll(e.blockList());
				
				List<Location> locs = new ArrayList<Location>();
				List<Material> mat = new ArrayList<Material>();
				List<Byte> bt = new ArrayList<Byte>();
			
				Collections.sort(blocks, new Comparator<Block>() {

		            @Override
		            public int compare(Block b1, Block b2) {
		                int y1 = b1.getY();
		                int y2 = b2.getY();
		                if(y1 < y2) {
		                    return -1;
		                } else if(y1 == y2) {
		                    return 0;
		                }
		                return 1;
		            }
		           
		        });
				for (int i = 0; i < blocks.size(); i++){
					locs.add(blocks.get(i).getLocation());
				}
				e.blockList().clear();
				for (int i2 = 0; i2 < locs.size(); i2++){
					mat.add(locs.get(i2).getBlock().getType());
					bt.add(locs.get(i2).getBlock().getData());
				}
				for (int i4 = 0; i4 < locs.size(); i4++){
					if (drop) {
						locs.get(i4).getBlock().breakNaturally(new ItemStack(mat.get(i4)));
					} else {
						locs.get(i4).getBlock().setType(Material.AIR);
					}
				}
				
				 this.task.put(en, Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable(){
					int i3;
					@Override
					public void run() {
						if (i3 < locs.size()){
							
							locs.get(i3).getBlock().setType(mat.get(i3));
							locs.get(i3).getBlock().setData(bt.get(i3));
							locs.get(i3).getBlock().getLocation().getWorld().playEffect(locs.get(i3), Effect.ENDER_SIGNAL, 1);
							locs.get(i3).getBlock().getLocation().getWorld().playSound(locs.get(i3), Sound.ENDERMAN_TELEPORT,(float) 1, (float) 1);
							i3++;
						} else {
							
							for (int i33 = 0; i33 < locs.size(); i33++){
								locs.get(i33).getBlock().setType(mat.get(i33));
								locs.get(i33).getBlock().setData(bt.get(i33));
							}
							locs.clear();
				            mat.clear();
				            bt.clear();
				            Bukkit.getScheduler().cancelTask(task.get(en));
				            task.remove(en);
				            en.getLocation().getBlock().getWorld().playEffect(en.getLocation().getBlock().getLocation(), Effect.ENDER_SIGNAL, 1);
							
						}
						
					}
					
				}, 3*20L, 1L));
			} else {
				System.out.println("!");
			}
		}
		
	}
	public static void init(){
		if (Main.getInstance().getConfig().getStringList("entitys").isEmpty() == true){
			entitys.add("ALL");
			Main.getInstance().getConfig().addDefault("entitys", entitys);
		}
		Main.getInstance().getConfig().addDefault("drop@explosion", false);
		Main.getInstance().getConfig().options().copyDefaults(true);
		Main.getInstance().saveConfig();
		if (Main.getInstance().getConfig().getBoolean("drop@explosion")){
			drop = true;
		} else {
			drop = false;
		}
		entitys = Main.getInstance().getConfig().getStringList("entitys");
		if (entitys.size() == 1){
			if (entitys.contains("ALL") || entitys.contains("all")){
				all = true;
			} else {
				all = false;
			}
		} else {
			all = false;
		}
		if (all == false){
			for (int i = 0; i < entitys.size(); i++){
				if (EntityType.valueOf(entitys.get(i)) != null){
					//en2.add(EntityType.fromName(entitys.get(i).replaceAll("&", "_")));
					en2.add(EntityType.valueOf(entitys.get(i)));
					if (Main.getInstance().debug){
						System.out.println("+");
					}
				} else {
					System.out.println(entitys.get(i) + " is not a type of entitys.");
				}
			}
			if (Main.getInstance().debug){
				System.out.println("X");
			}
		}
		
		
		if (Main.getInstance().debug){
			System.out.println(Main.getInstance().getConfig().getStringList("entitys"));
			System.out.println(all);
			System.out.println(en2);
		}
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &eThis Entitys were added to the Explosion List:"));
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c>> &e" + en2));
		
	}

}
