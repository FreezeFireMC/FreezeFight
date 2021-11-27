package de.chaos.mc.freezefight.listeners;

import de.chaos.mc.freezefight.utils.stats.StatsInterface;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    private StatsInterface statsInterface;
    public DeathListener(StatsInterface statsInterface) {
        this.statsInterface = statsInterface;
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player.getKiller() instanceof Player) {
            Player killer = player.getKiller();
            statsInterface.addKills(killer.getUniqueId(), 1);
            killer.setHealth(20);
        }
        statsInterface.addDeath(player.getUniqueId(), 1);
    }
}
