package de.chaos.mc.freezefight.commands;

import de.chaos.mc.freezefight.FreezeFight;
import de.chaos.mc.serverapi.utils.locationlibary.LocationInterface;
import de.chaos.mc.serverapi.utils.stringLibary.DefaultMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setSpawnLocaton implements CommandExecutor {
    LocationInterface locationInterface;
    public setSpawnLocaton() {
        locationInterface = FreezeFight.getLocationAPI();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(DefaultPermissions.setSpawm)) {
                String name = "Spawn." + locationInterface.getAllKeys(FreezeFight.NAMESPACE);
                locationInterface.addLocation(FreezeFight.NAMESPACE, name, player.getLocation());
            } else {
                player.sendMessage(DefaultMessages.NOPERMISSION);
            }
        } else {
            sender.sendMessage(DefaultMessages.BEAPLAYER);
        }
        return false;
    }
}
