package com.rievrs.proEssentials;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

import com.rievrs.proEssentials.commands.StatsCommand;

import net.md_5.bungee.api.ChatColor;


public class PlayerEvents implements Listener {
	
	public PlayerEvents(Main plugin) {
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		
		String nickStyle = ChatColor.GREEN + "" + ChatColor.BOLD + "PLEBEU " + ChatColor.GREEN + p.getName() + ChatColor.WHITE;
		
		if(p.isOp()) {
			nickStyle = ChatColor.RED + "" + ChatColor.BOLD + "DONO " + ChatColor.RED + p.getName() + ChatColor.WHITE;
		}
			
		p.setPlayerListName(nickStyle);
		p.setDisplayName(nickStyle);
		
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
		}
		
		event.setJoinMessage("§2Bem-vindo(a) - " + nickStyle);
	}
	
	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event) {
		Player p = event.getPlayer();
		event.setQuitMessage("§2Obrigado por jogar - §6" + p.getName());
	}
	
//	@EventHandler
//	public void onBlockBreak(BlockBreakEvent event) {
//		Block block = event.getBlock();
//				
//		Material blockType = block.getType();
//		
//		if(blockType ==  Material.SPAWNER) {
//			
//			CreatureSpawner cs = (CreatureSpawner) block.getState();
//			ItemStack spawner = new ItemStack(blockType, 1);
//			BlockStateMeta blockMeta = (BlockStateMeta) spawner.getItemMeta();
//			blockMeta.setBlockState(cs);
//			spawner.setItemMeta(blockMeta);
//			
//			event.getBlock().getWorld().dropItemNaturally(block.getLocation(), spawner);
//			
//		}
//	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		
		HumanEntity player = event.getWhoClicked();
		
		if (StatsCommand.viewing.contains(player.getName())) {
			
			event.setCancelled(true);
				
		}
	}
	
	@EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (StatsCommand.viewing.contains(event.getPlayer().getName())) {
        	StatsCommand.viewing.remove(event.getPlayer().getName());
        }
    }
}
