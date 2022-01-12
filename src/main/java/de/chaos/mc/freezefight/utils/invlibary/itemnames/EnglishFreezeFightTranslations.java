package de.chaos.mc.freezefight.utils.invlibary.itemnames;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EnglishFreezeFightTranslations {
    SWORD("§7Sword"),
    BOW("§6Bow"),
    EGG("§6Egg"),
    ARROW("§6Arrow"),
    INVNAME("§66FreezeFight inventory sorting"),
    INVENTORYUPDATED("§6You inventory-sorting for freezefight was updated");

    @Getter
    private String translation;
}
