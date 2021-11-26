package de.chaos.mc.freezefight.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ProjectileListener implements Listener {
    @EventHandler
    public void onProjectile(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getDamager().getType() == EntityType.ARROW) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 3, 1, true, false, false));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 3, 1, true, false, false));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 3, 1, true, false, false));
            }
        }

    }
}
