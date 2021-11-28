package de.chaos.mc.freezefight;

import de.chaos.mc.freezefight.commands.setSpawnLocaton;
import de.chaos.mc.freezefight.listeners.ConnectionListener;
import de.chaos.mc.freezefight.listeners.DeathListener;
import de.chaos.mc.freezefight.listeners.EventListener;
import de.chaos.mc.freezefight.listeners.ProjectileListener;
import de.chaos.mc.freezefight.utils.locationlibary.LocationInterface;
import de.chaos.mc.freezefight.utils.locationlibary.LocationRepository;
import de.chaos.mc.freezefight.utils.stats.StatsInterface;
import de.chaos.mc.freezefight.utils.stats.StatsRepository;
import de.chaos.mc.serverapi.api.ServerAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;


public class FreezeFight extends JavaPlugin {
    public FreezeFight instance;
    private static ServerAPI serverAPI;
    private static LocationInterface locationAPI;
    public static String NAMESPACE = "FreezeFight";
    public static String currentMap = null;
    public static boolean inMode = false;

    private StatsRepository statsRepository;
    private StatsInterface statsInterface;

    private LocationRepository locationRepository;

     @Override
     public void onLoad() {
         instance = this;
     }

    @Override
    public void onEnable() {
        serverAPI = new ServerAPI();
        int randonMap = new Random().nextInt(locationAPI.getAllKeys(NAMESPACE).size());

        currentMap = locationAPI.getAllKeys(NAMESPACE).get(randonMap);

        statsRepository = new StatsRepository(serverAPI.getConnectionSource());
        statsInterface = statsRepository;

        locationRepository = new LocationRepository(serverAPI.getConnectionSource());
        locationAPI = locationRepository;


        if (locationAPI.getAllMaps().size() != 0) {
            currentMap = locationAPI.getAllMaps().get(new Random().nextInt(locationAPI.getAllMaps().size()));
            inMode = true;
        } else {
            inMode = false;
        }

        getCommand("setSpawn").setExecutor(new setSpawnLocaton());

        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new ConnectionListener(), this);
        pluginManager.registerEvents(new EventListener(), this);
        pluginManager.registerEvents(new ProjectileListener(), this);
        pluginManager.registerEvents(new DeathListener(statsInterface, locationAPI), this);
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
