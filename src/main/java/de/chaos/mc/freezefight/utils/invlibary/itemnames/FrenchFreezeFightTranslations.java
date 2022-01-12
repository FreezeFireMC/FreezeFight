package de.chaos.mc.freezefight.utils.invlibary.itemnames;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FrenchFreezeFightTranslations {
    SWORD("§7Sword"),
    BOW("§6Bow"),
    EGG("§6Egg"),
    ARROW("§6Arrow"),
    INVNAME("§6Inventory-Sorting"),
    INVENTORYUPDATED("§6You inventory-sorting for mlgrush was updated");

    @Getter
    private String translation;
}
