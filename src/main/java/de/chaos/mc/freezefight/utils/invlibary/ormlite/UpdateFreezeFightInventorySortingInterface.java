package de.chaos.mc.freezefight.utils.invlibary.ormlite;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public interface UpdateFreezeFightInventorySortingInterface {
    FreezeFightInvSortingDAO getInventory(UUID uuid);

    void updateInventory(FreezeFightInvSortingDAO inventoryDAO);

    void checkIfFirstJoin(UUID uuid);

    void updateSorting(Player player, Inventory inventory);
}
