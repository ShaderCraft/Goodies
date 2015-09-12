package de.dunklesToast.nilober.goodies.Utilitys;

import java.util.UUID;

import net.minecraft.server.v1_8_R3.NBTTagCompound;

import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class NBTUtility {
	
	public static ItemStack setTag(ItemStack bukkitItem, String tagname, String tagvalue){
		net.minecraft.server.v1_8_R3.ItemStack item = CraftItemStack.asNMSCopy(bukkitItem);
		NBTTagCompound tag = item.hasTag() ? item.getTag() : new NBTTagCompound();
		tag.setString(tagname, tagvalue);
		item.setTag(tag);
		return CraftItemStack.asBukkitCopy(item);

	}
	
	public static ItemStack setInventoryTags(ItemStack bukkitItem, ItemStack[] inv){
		
		net.minecraft.server.v1_8_R3.ItemStack item = CraftItemStack.asNMSCopy(bukkitItem);
		NBTTagCompound tag = item.hasTag() ? item.getTag() : new NBTTagCompound();
		tag.setString("Backpackid", UUID.randomUUID().toString());
		
		return CraftItemStack.asBukkitCopy(item);
		
		
	}
	
	

}