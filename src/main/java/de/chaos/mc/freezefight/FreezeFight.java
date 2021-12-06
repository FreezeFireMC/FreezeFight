package de.chaos.mc.freezefight;

import de.chaos.mc.freezefight.utils.stats.StatsInterface;
import de.chaos.mc.freezefight.utils.stats.StatsRepository;
import de.chaos.mc.serverapi.api.ServerAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.IOException;

public class FreezeFight extends JavaPlugin implements Listener {
	private static ServerAPI serverAPI;
	private StatsRepository statsRepository;
	private static StatsInterface statsInterface;
	public static File locations;
	public static FileConfiguration loc;
	
	public void onEnable() {
		serverAPI = new ServerAPI();
		this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6FreezeFight&7] &aLoading contents"));
		loadCommands();
		loadEvents();
		loadFiles();

		statsRepository = new StatsRepository(serverAPI.getConnectionSource());
		statsInterface = statsRepository;

		for(Player all : Bukkit.getOnlinePlayers()) {
			PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, false);
			PotionEffect jumpboost = new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1, true, false);
			all.addPotionEffect(speed);
			all.addPotionEffect(jumpboost);
		}
	}

	public void onDisable() {
		this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6Paintball&7] &aPlugin disabled"));
		this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6Paintball&7] &aDeveloped by &cKorzHorz"));
	}

	public void loadCommands() {
		this.getCommand("SetSpawn").setExecutor(new CMD_SetSpawn(this));
		this.getCommand("Stats").setExecutor(new CMD_Stats(this));
	}
	
	public void loadEvents() {
		getServer().getPluginManager().registerEvents(new EVT_ItemDropEvent(this), this);
		getServer().getPluginManager().registerEvents(new EVT_ItemPickupEvent(this), this);
		getServer().getPluginManager().registerEvents(new EVT_PlayerDeathEvent(this), this);
		getServer().getPluginManager().registerEvents(new EVT_PlayerJoinEvent(this), this);
		getServer().getPluginManager().registerEvents(new EVT_PlayerQuitEvent(this), this);
		getServer().getPluginManager().registerEvents(new EVT_PlayerMoveEvent(this), this);
		getServer().getPluginManager().registerEvents(new EVT_FoodLevelChangeEvent(), this);
		getServer().getPluginManager().registerEvents(new EVT_FallDamageEvent(), this);
		getServer().getPluginManager().registerEvents(new EVT_EntityDamageByEntityEvent(), this);
		getServer().getPluginManager().registerEvents(new EVT_ProjectileHitEvent(this), this);
	}

	public void loadFiles() {
		FreezeFight.locations = new File(this.getDataFolder(), "locations.yml");
		if (this.getDataFolder().exists()) {
			this.getDataFolder().mkdir();
		}

		if (!locations.exists()) {
			try {
				locations.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		FreezeFight.loc = YamlConfiguration.loadConfiguration(FreezeFight.locations);
	}

	public static StatsInterface getStatsInterface() {
		return statsInterface;
	}
}