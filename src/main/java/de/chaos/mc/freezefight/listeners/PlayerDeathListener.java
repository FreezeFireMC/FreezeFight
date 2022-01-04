package de.chaos.mc.freezefight.listeners;

import de.chaos.mc.freezefight.FreezeFight;
import de.chaos.mc.freezefight.utils.GamePlayerLanguage;
import de.chaos.mc.freezefight.utils.stats.StatsInterface;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    private StatsInterface statsInterface;

    public PlayerDeathListener setStatsInterface(StatsInterface statsInterface) {
        this.statsInterface = statsInterface;
        return this;
    }

    @EventHandler
    public void onDeat(PlayerDeathEvent event) {
        event.setDeathMessage(null);
        Player player = event.getPlayer();
        Player killer = player.getKiller();
        for (Player all : Bukkit.getOnlinePlayers()) {
            GamePlayerLanguage playerLanguage = FreezeFight.getOnlinePlayers().get(all.getUniqueId());
            all.sendMessage(playerLanguage.playerWasKilled(player, killer));
        }
        statsInterface.addDeath(player.getUniqueId(), 1);
        statsInterface.addKills(player.getUniqueId(), 1);
    }
}
