package de.chaos.mc.freezefight.listeners;

import de.chaos.mc.freezefight.FreezeFight;
import de.chaos.mc.freezefight.utils.FreezeFightStringLoader;
import de.chaos.mc.serverapi.utils.stringLibary.AbstractMessages;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ConnectionListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, false);
        PotionEffect jumpboost = new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1, true, false);
        player.addPotionEffect(speed);
        player.addPotionEffect(jumpboost);
        player.teleport(FreezeFight.getLocationInterface().getLocation("Spawn"));
        event.setJoinMessage(AbstractMessages.joinMessage(player));
        player.setGameMode(GameMode.ADVENTURE);
        FreezeFightStringLoader.loadLanguage(player.getUniqueId());

        player.getInventory().clear();
        FreezeFight.getSortingInv().setInventory(player);
    }
}
