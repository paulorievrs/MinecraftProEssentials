package com.rievrs.proEssentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderchestCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		if(!(sender instanceof Player)) {
		    return false;
		}
		Player p = (Player)sender;
		
		p.openInventory(p.getEnderChest());
		
		
		
		return true;
		
	}
}
