/*******************************************************************************
 * Copyright (C) Philipp Seelos - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Philipp Seelos <seelos@outlook.com>, December 2017
 ******************************************************************************/
package de.melays.bwunlimited.commands.stats;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.melays.bwunlimited.Main;
import de.melays.bwunlimited.stats.StatsMode;

public class StatsCommand implements CommandExecutor {
	
	Main main;
	
	public StatsCommand(Main main) {
		this.main = main;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(main.prefix + "You cant run this command from the console!");
			return true;
		}
		Player p = (Player) sender;
		if (!main.getMessageFetcher().checkPermission(sender, "bwunlimited.stats")) {
			return true;
		}
		
		UUID check = p.getUniqueId();
		
		try {
			if (args.length > 0) {
				if (main.getStatsManager().mode == StatsMode.MYSQL) {
					check = UUID.fromString(main.getStatsManager().istatsapi.getUUIDFromName(args[0]));
				}
				else if (main.getStatsManager().mode == StatsMode.STATSAPI) {
					check = UUID.fromString(main.getStatsManager().statsapi.getUUIDFromName(args[0]));
				}
				else if (main.getStatsManager().mode == StatsMode.YAML) {
					check = Bukkit.getOfflinePlayer(args[0]).getUniqueId();
				}
			}
		}catch(Exception e) {
			p.sendMessage(main.getMessageFetcher().getMessage("stats_unknown_player", true));
			e.printStackTrace();
			return true;
		}
		
		try {
			main.getStatsManager().sendStatsMessage(p, check);
		}catch(Exception e) {
			p.sendMessage(main.getMessageFetcher().getMessage("stats_unknown_player", true));
			return true;
		}
		
		return true;
	}
	
}
