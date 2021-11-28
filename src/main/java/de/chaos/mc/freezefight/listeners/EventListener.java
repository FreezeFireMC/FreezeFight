package de.chaos.mc.freezefight.listeners;

import org.bukkit.Bukkit;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;


public class EventListener implements Listener {
    @EventHandler
    public void omDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                event.setCancelled(true);
            }
            if (event.getCause() == EntityDamageEvent.DamageCause.DROWNING) {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onPlayerHungerEvent(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerItemDrop(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onWeatherChangeEvent(WeatherChangeEvent event) {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.setPlayerWeather(WeatherType.CLEAR);
        }
    }
}