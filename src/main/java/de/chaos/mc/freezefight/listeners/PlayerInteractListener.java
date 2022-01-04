package de.chaos.mc.freezefight.listeners;

import de.chaos.mc.freezefight.FreezeFight;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onPlayerInterct(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getMaterial() == Material.EGG) {
                final Item grenade = player.getWorld().dropItem(player.getEyeLocation(), new ItemStack(Material.EGG));
                Bukkit.getScheduler().scheduleSyncDelayedTask(FreezeFight.getFreezeFight(), new Runnable() {
                    @Override
                    public void run() {
                        grenade.getWorld().createExplosion(grenade.getLocation().getX(), grenade.getLocation().getY(), grenade.getLocation().getZ(), 3, false, false);
                    }
                }, 20 * 3);

            }
        }
    }
}
