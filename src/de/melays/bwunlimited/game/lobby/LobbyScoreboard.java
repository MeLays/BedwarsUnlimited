package de.melays.bwunlimited.game.lobby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.melays.bwunlimited.Main;
import de.melays.bwunlimited.game.arenas.Arena;
import de.melays.bwunlimited.game.arenas.state.ArenaState;
import de.melays.bwunlimited.scoreboard.ScoreBoardTools;

public class LobbyScoreboard {
	
	Main main;
	
	public LobbyScoreboard (Main main) {
		this.main = main;
	}
	
	HashMap<Player , ScoreBoardTools> scoreboards = new HashMap<Player , ScoreBoardTools>();
	
	public ArrayList<Player> getAll(){
		ArrayList<Player> players = new ArrayList<Player>();
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (!main.getArenaManager().isInGame(p)) {
				players.add(p);
			}
		}
		return players;
	}
	
	public void create () {
		for (Player p : getAll()) {
			create (p);
		}
	}
	
	public void create (Player p) {
		ScoreBoardTools tools = new ScoreBoardTools(p , main.c(main.getSettingsManager().getFile().getString("lobby.scoreboard.title")));
		List<String> lines = main.getSettingsManager().getFile().getStringList("lobby.scoreboard.content");
		int value = lines.size();
		
		//Initializing Scoreboard
		UUID from = p.getUniqueId();
		HashMap<String , Integer> int_values = new HashMap<String , Integer>();
		int_values.put("%points%", main.getStatsManager().getKey(from, "points"));
		int_values.put("%games%", main.getStatsManager().getKey(from, "games"));
		int_values.put("%kills%", main.getStatsManager().getKey(from, "kills"));
		int_values.put("%deaths%", main.getStatsManager().getKey(from, "deaths"));
		int_values.put("%won%", main.getStatsManager().getKey(from, "won"));
		int_values.put("%lost%", main.getStatsManager().getKey(from, "lost"));
		int_values.put("%beds%", main.getStatsManager().getKey(from, "beds"));
		int games_running = 0;
		for (Arena a : main.getArenaManager().getArenas()) {
			if (a.state == ArenaState.INGAME) {
				games_running ++;
			}
		}
		int_values.put("%games_running%", games_running);
		int_values.put("%players_online%", Bukkit.getOnlinePlayers().size());
		int_values.put("%players_lobby%", getAll().size());
		int group_size = 0;
		int group_max = 0;
		try {
			group_size = main.getGroupManager().getGroup(p).getPlayers().size();
			group_max = main.getGroupManager().getMaxPlayers(p);
		}
		catch(Exception e) {
			
		}
		int_values.put("%group_size%", group_size);
		int_values.put("%group_max%", group_max);
		
		HashMap<String , Double> double_values = new HashMap<String , Double>();
		if (int_values.get("%deaths%") != 0) {
			double_values.put("%kd%", ((double)int_values.get("%kills%") / (double)int_values.get("%deaths%")));
		}
		else {
			double_values.put("%kd%", (double)int_values.get("%kills%"));
		}
		
		if (int_values.get("%lost%") != 0) {
			double_values.put("%wl%", ((double)int_values.get("%won%") / (double)int_values.get("%lost%")));
		}
		else{
			double_values.put("%wl%",(double)int_values.get("%won%"));
		}
		
		if (int_values.get("%games%") != 0) {
			double_values.put("%bg%", ((double)int_values.get("%beds%") / (double)int_values.get("%games%")));
		}
		else{
			double_values.put("%bg%",(double)int_values.get("%beds%"));
		}
		//---------------------------
		
		for (String s : lines) {
			
			for (String key : int_values.keySet()) {
				s = s.replace(key, int_values.get(key).toString());
			}
			for (String key : double_values.keySet()) {
				int temp = (int)(double_values.get(key)*100.0);
			    double shortDouble = ((double)temp)/100.0;
			    s = s.replace(key, shortDouble + "");
			}
			
			tools.addNormalLine(s , value);
			value -= 1;
		}
		tools.set();
		scoreboards.put(p, tools);
	}
	
	public void update () {
		remove();
		this.create();
	}
	public void remove() {
		for (Player p : getAll()) {
			p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		}
	}

}
