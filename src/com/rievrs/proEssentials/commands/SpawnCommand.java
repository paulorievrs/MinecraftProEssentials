package com.rievrs.proEssentials.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SpawnCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		if(!(sender instanceof Player)) {
		    return false;
		}
		Player p = (Player)sender;
		
		Location spawnpoint = Bukkit.getServer().getWorld("world").getSpawnLocation();
	
		p.teleport(spawnpoint);
		p.sendMessage("§6[ProEssentials] - §2Teleportando para spawnpoint");
		p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
		return true;
		
	}
}
