package com.rievrs.proEssentials.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.rievrs.proEssentials.Utils;


public class StatsCommand implements CommandExecutor {
	
	public static List<String> viewing = new ArrayList<String>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		if(!(sender instanceof Player)) {
		    return false;
		}
		
		Player p = (Player)sender;
		String name = p.getName();
		
		if(args.length > 0) {
			name = args[0];
		}
		
		Player statusP = Bukkit.getPlayer(name);
		
		if(statusP == null) {
			p.sendMessage("§6[ProEssentials] - §2Jogador não encontrado.");
			return true;
		}
		
		int deaths = statusP.getStatistic(Statistic.DEATHS);
		int killedMobs = statusP.getStatistic(Statistic.MOB_KILLS);
		int jumps = statusP.getStatistic(Statistic.JUMP);
		
		Inventory inv = Bukkit.createInventory(p, InventoryType.CHEST, "Player Stats - " + name);
		
		ItemStack deathPaper = Utils.createCustomItem("§8Mortes: ", "§f" + String.valueOf((deaths)), Material.PAPER);
		ItemStack mobkillPaper = Utils.createCustomItem("§9Mobs matados: ", "§f" + String.valueOf((killedMobs)), Material.PAPER);
		ItemStack jumpPaper = Utils.createCustomItem("§6Pulos: ", "§f" + String.valueOf((jumps)), Material.PAPER);
		
		inv.addItem(deathPaper);
		inv.addItem(mobkillPaper);
		inv.addItem(jumpPaper);
		
		
		viewing.add(p.getName());
		
		p.openInventory(inv);
		
		return true;
		
	}
	
}


