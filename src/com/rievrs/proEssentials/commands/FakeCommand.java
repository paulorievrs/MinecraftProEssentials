package com.rievrs.proEssentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		if(!(sender instanceof Player)) {
		    return false;
		}
		Player p = (Player)sender;
		
		p.setDisplayName(args[0]);
		p.setCustomName(args[0]);
		p.setPlayerListName(args[0]);
		p.setCustomNameVisible(true);
		
		return true;
		
	}
}
