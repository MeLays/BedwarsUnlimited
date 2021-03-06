/*******************************************************************************
 * Copyright (C) Philipp Seelos - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Philipp Seelos <seelos@outlook.com>, December 2017
 ******************************************************************************/
package de.melays.bwunlimited.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import de.melays.bwunlimited.Main;
import de.melays.bwunlimited.game.arenas.Arena;
import de.melays.bwunlimited.game.arenas.state.ArenaState;

public class BlockBreakEventListener implements Listener{

	Main main;
	
	public BlockBreakEventListener (Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (main.getArenaManager().isInGame(p)) {
			Arena arena = main.getArenaManager().searchPlayer(p);
			
			//Arena relevant Event stuff
			if (arena.state == ArenaState.LOBBY || arena.state == ArenaState.ENDING) {
				e.setCancelled(true);
			}
			else if (arena.state == ArenaState.INGAME) {
				if (!arena.blockManager.removeBlock(e.getBlock().getLocation(), p)) {
					e.setCancelled(true);
				}
				else {
					double x = e.getBlock().getLocation().getX();
					double z = e.getBlock().getLocation().getZ();
					ItemStack stack = e.getPlayer().getItemInHand();
					if (e.getBlock().getDrops(stack).size() != 0 && !main.getConfig().getStringList("game.no_drop").contains(e.getBlock().getType().toString())) {
						try {
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(x > 0 ? 0.5 : -0.5, 0.0, z > 0 ? 0.5 : -0.5), arena.blockManager.getDrop(e.getBlock().getLocation()));
						} catch (Exception e1) {

						}
					}
					e.getBlock().setType(Material.AIR);
				}
			}
			
		}
		else if (!main.canOperateInLobby(p)) {
			e.setCancelled(true);
		}
		else {
			if (main.getTemplateSignManager().removeSign(e.getBlock().getLocation())) {
				p.sendMessage(main.prefix + "A sign has been removed from config.");
			}
		}
	}
	
}
