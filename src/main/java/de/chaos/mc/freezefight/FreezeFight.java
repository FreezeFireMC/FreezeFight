package de.chaos.mc.freezefight;

import de.chaos.mc.freezefight.listeners.ConnectionListener;
import de.chaos.mc.freezefight.listeners.EventListener;
import de.chaos.mc.freezefight.listeners.PlayerDeathListener;
import de.chaos.mc.freezefight.utils.GamePlayerLanguage;
import de.chaos.mc.freezefight.utils.invlibary.SortingInv;
import de.chaos.mc.freezefight.utils.invlibary.ormlite.UpdateFreezeFightInvSortingRepository;
import de.chaos.mc.freezefight.utils.invlibary.ormlite.UpdateFreezeFightInventorySortingInterface;
import de.chaos.mc.freezefight.utils.locationlibary.LocationInterface;
import de.chaos.mc.freezefight.utils.locationlibary.LocationRepository;
import de.chaos.mc.freezefight.utils.stats.StatsInterface;
import de.chaos.mc.freezefight.utils.stats.StatsRepository;
import de.chaos.mc.serverapi.api.ServerAPI;
import lombok.Getter;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class FreezeFight extends JavaPlugin implements Listener {
	private static ServerAPI serverAPI;
	private StatsRepository statsRepository;
	private static StatsInterface statsInterface;
	private static FreezeFight freezeFight;
	private static LocationInterface locationInterface;
	@Getter
	private static HashMap<UUID, GamePlayerLanguage> onlinePlayers;
	private static SortingInv sortingInv;
	private UpdateFreezeFightInventorySortingInterface sortingInterface;

	public static FreezeFight getFreezeFight() {
		return freezeFight;
	}

	public static SortingInv getSortingInv() {
		return sortingInv;
	}

	public static ServerAPI getServerAPI() {
		return serverAPI;
	}

	public static LocationInterface getLocationInterface() {
		return locationInterface;
	}

	public void onDisable() {
		this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&bFreeze&cFight&7] &aPlugin disabled"));
		this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&bFreeze&cFight&7] &aDeveloped by &cFreezeFire"));
	}

	public void init() {
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new ConnectionListener(), this);
		pluginManager.registerEvents(new EventListener(), this);
		pluginManager.registerEvents(new PlayerDeathListener().setStatsInterface(statsInterface), this);
	}

	public static StatsInterface getStatsInterface() {
		return statsInterface;
	}

	public StatsRepository getStatsRepository() {
		return statsRepository;
	}

	public void onEnable() {
		freezeFight = this;
		serverAPI = new ServerAPI();
		this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6FreezeFight&7] &aLoading contents"));
		statsRepository = new StatsRepository(serverAPI.getConnectionSource());
		statsInterface = statsRepository;
		locationInterface = new LocationRepository();
		onlinePlayers = new HashMap<>();
		sortingInterface = new UpdateFreezeFightInvSortingRepository(serverAPI.getConnectionSource());
		sortingInv = new SortingInv(sortingInterface, serverAPI.getLanguageInterface());
		init();
	}
}