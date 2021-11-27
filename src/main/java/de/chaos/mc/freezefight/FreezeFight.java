package de.chaos.mc.freezefight;

import de.chaos.mc.freezefight.commands.setSpawnLocaton;
import de.chaos.mc.freezefight.listeners.ConnectionListener;
import de.chaos.mc.freezefight.listeners.DeathListener;
import de.chaos.mc.freezefight.listeners.EventListener;
import de.chaos.mc.freezefight.listeners.ProjectileListener;
import de.chaos.mc.freezefight.utils.stats.StatsInterface;
import de.chaos.mc.freezefight.utils.stats.StatsRepository;
import de.chaos.mc.serverapi.api.ServerAPI;
import de.chaos.mc.serverapi.utils.locationlibary.LocationInterface;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FreezeFight extends JavaPlugin {
    public FreezeFight instance;
    private static ServerAPI serverAPI;
    private static LocationInterface locationAPI;
    public static final String NAMESPACE = "FreezeWars";

    private StatsRepository statsRepository;
    private StatsInterface statsInterface;

     @Override
     public void onLoad() {
         instance = this;
     }

    @Override
    public void onEnable() {
        serverAPI = new ServerAPI();
        locationAPI = serverAPI.getLocationInterface();

        statsRepository = new StatsRepository(serverAPI.getConnectionSource());
        statsInterface = statsRepository;

        getCommand("setSpawn").setExecutor(new setSpawnLocaton());

        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new ConnectionListener(), this);
        pluginManager.registerEvents(new EventListener(), this);
        pluginManager.registerEvents(new ProjectileListener(), this);
        pluginManager.registerEvents(new DeathListener(statsInterface), this);
    }

    @Override
    public void onDisable() {
    }

    public FreezeFight getInstance() {
        return instance;
    }

    public static LocationInterface getLocationAPI() {
        return locationAPI;
    }
}
