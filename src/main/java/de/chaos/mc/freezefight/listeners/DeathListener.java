package de.chaos.mc.freezefight.listeners;

import de.chaos.mc.freezefight.FreezeFight;
import de.chaos.mc.freezefight.utils.GameUtils;
import de.chaos.mc.freezefight.utils.locationlibary.LocationInterface;
import de.chaos.mc.freezefight.utils.stats.StatsInterface;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.Random;

public class DeathListener implements Listener {
    private StatsInterface statsInterface;
    LocationInterface locationInterface;
    public DeathListener(StatsInterface statsInterface, LocationInterface locationInterface) {
        this.statsInterface = statsInterface;
        this.locationInterface = locationInterface;
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player.getKiller() != null) {
            Player killer = player.getKiller();
            statsInterface.addKills(killer.getUniqueId(), 1);
            killer.setHealth(20);
        }
        statsInterface.addDeath(player.getUniqueId(), 1);
        player.spigot().respawn();
    }
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        GameUtils.setInvItems(player);
        if (locationInterface.getAllKeys(FreezeFight.NAMESPACE).size() != 0) {
            int random = new Random().nextInt(locationInterface.getAllKeys(FreezeFight.NAMESPACE).size());
            String stringName = locationInterface.getAllKeys(FreezeFight.NAMESPACE).get(random);
            Location spawnLocation = locationInterface.getLocation(stringName);

            player.teleport(spawnLocation);
        }
    }
}
