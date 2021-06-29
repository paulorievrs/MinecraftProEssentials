package com.rievrs.proEssentials;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import com.rievrs.proEssentials.commands.FakeCommand;
import com.rievrs.proEssentials.commands.SpawnCommand;
import com.rievrs.proEssentials.commands.StatsCommand;

import com.rievrs.proEssentials.commands.EnderchestCommand;
import com.rievrs.proEssentials.commands.CraftingTableCommand;


public class Main extends JavaPlugin {
	
	public static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		Bukkit.getConsoleSender().sendMessage("§2Plugin Iniciado - §6Pro Essentials");
		
		this.commands();
		this.craft();
		
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerEvents(this), this);
		
	}
	
	public void craft() {
		
		Bukkit.addRecipe(Crafts.createHonneyPiston());
		
	}
	
	public void commands() {
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("fake").setExecutor(new FakeCommand());
		getCommand("ec").setExecutor(new EnderchestCommand());
		getCommand("craft").setExecutor(new CraftingTableCommand());
		getCommand("stats").setExecutor(new StatsCommand());
	}
}

