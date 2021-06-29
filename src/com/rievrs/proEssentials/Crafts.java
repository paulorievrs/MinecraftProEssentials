package com.rievrs.proEssentials;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Crafts {
	
	public static ShapedRecipe createHonneyPiston() {
		
		ItemStack stickyPiston = Utils.createCustomItem("Honey Piston", "", Material.STICKY_PISTON);
		
		NamespacedKey piston_key = new NamespacedKey(Main.instance, "piston_key");
		ShapedRecipe honneyPiston = new ShapedRecipe(piston_key, stickyPiston);
		
		honneyPiston.shape("   "," P ", " H ");	
		honneyPiston.setIngredient('P', Material.PISTON);
		honneyPiston.setIngredient('H', Material.HONEY_BLOCK);
		
		return honneyPiston;
		
	}
}
