package de.chaos.mc.freezefight.utils.invlibary;

import de.chaos.mc.freezefight.utils.invlibary.itemnames.EnglishFreezeFightTranslations;
import de.chaos.mc.freezefight.utils.invlibary.itemnames.FrenchFreezeFightTranslations;
import de.chaos.mc.freezefight.utils.invlibary.itemnames.GermanFreezeFightTranslations;
import de.chaos.mc.freezefight.utils.invlibary.ormlite.UpdateFreezeFightInventorySortingInterface;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    private final UpdateFreezeFightInventorySortingInterface sortingInterface;

    public InventoryClickListener(UpdateFreezeFightInventorySortingInterface inventorySortingInterface) {
        this.sortingInterface = inventorySortingInterface;
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getAction() == InventoryAction.HOTBAR_SWAP) {
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(GermanFreezeFightTranslations.INVNAME.getTranslation()) || event.getView().getTitle().equalsIgnoreCase(EnglishFreezeFightTranslations.INVNAME.getTranslation()) || event.getView().getTitle().equalsIgnoreCase(FrenchFreezeFightTranslations.INVNAME.getTranslation())) {
            if (event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
                event.setCancelled(true);
            }
        } else {
            event.setCancelled(true);
        }
    }
}
