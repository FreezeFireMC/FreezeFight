package de.chaos.mc.freezefight.listeners;

import de.chaos.mc.freezefight.FreezeFight;
import de.chaos.mc.freezefight.utils.GameUtils;
import de.chaos.mc.serverapi.utils.locationlibary.LocationInterface;
import de.chaos.mc.serverapi.utils.stringLibary.DefaultMessages;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

public class ConnectionListener implements Listener {
    LocationInterface locationInterface;
    public ConnectionListener() {
        locationInterface = FreezeFight.getLocationAPI();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(DefaultMessages.joinMessage(player));
        player.setGameMode(GameMode.ADVENTURE);
        GameUtils.setCountdown(player);
        GameUtils.setInvItems(player);
        if (locationInterface.getAllKeys(FreezeFight.NAMESPACE).size() != 0) {
            int random = new Random().nextInt(locationInterface.getAllKeys(FreezeFight.NAMESPACE).size());
            String stringName = locationInterface.getAllKeys(FreezeFight.NAMESPACE).get(random);
            Location spawnLocation = locationInterface.getLocation(stringName);

            player.teleport(spawnLocation);
        }
    }
}
