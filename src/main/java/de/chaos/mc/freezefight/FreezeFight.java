package de.chaos.mc.freezefight;

import de.chaos.mc.freezefight.listeners.ConnectionListener;
import de.chaos.mc.freezefight.listeners.EventListener;
import de.chaos.mc.freezefight.utils.locationlibary.LocationInterface;
import de.chaos.mc.freezefight.utils.locationlibary.LocationRepository;
import de.chaos.mc.freezefight.utils.stats.StatsInterface;
import de.chaos.mc.freezefight.utils.stats.StatsRepository;
import de.chaos.mc.serverapi.api.ServerAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FreezeFight extends JavaPlugin implements Listener {
	private static ServerAPI serverAPI;
	private StatsRepository statsRepository;
	private static StatsInterface statsInterface;
	private static FreezeFight freezeFight;
	private static LocationInterface locationInterface;

	public static FreezeFight getFreezeFight() {
		return freezeFight;
	}

	public void onDisable() {
		this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6Paintball&7] &aPlugin disabled"));
		this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6Paintball&7] &aDeveloped by &cKorzHorz"));
	}

	public static ServerAPI getServerAPI() {
		return serverAPI;
	}

	public static LocationInterface getLocationInterface() {
		return locationInterface;
	}

	public void onEnable() {
		freezeFight = this;
		serverAPI = new ServerAPI();
		this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6FreezeFight&7] &aLoading contents"));
		statsRepository = new StatsRepository(serverAPI.getConnectionSource());
		statsInterface = statsRepository;
		locationInterface = new LocationRepository();

		init();
	}

	public void init() {
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new ConnectionListener(), this);
		pluginManager.registerEvents(new EventListener(), this);
	}

	public static StatsInterface getStatsInterface() {
		return statsInterface;
	}

	public StatsRepository getStatsRepository() {
		return statsRepository;
	}
}