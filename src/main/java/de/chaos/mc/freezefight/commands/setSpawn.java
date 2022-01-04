package de.chaos.mc.freezefight.commands;

import de.chaos.mc.freezefight.FreezeFight;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class setSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission("FreezeFire.setLocation")) {
            FreezeFight.getLocationInterface().addLocation("Spawn", player.getLocation());
        }
        return false;
    }
}
