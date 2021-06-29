package com.rievrs.proEssentials;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils {
	public static ItemStack createCustomItem(String key, String value, Material item) {
		ItemStack is = new ItemStack(item);
		ItemMeta itemMeta = is.getItemMeta();
		
		itemMeta.setDisplayName(key + value);
		
		is.setItemMeta(itemMeta);
		
		return is;
	}
}
