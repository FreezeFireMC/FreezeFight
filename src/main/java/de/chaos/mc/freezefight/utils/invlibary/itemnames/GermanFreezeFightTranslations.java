package de.chaos.mc.freezefight.utils.invlibary.itemnames;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum GermanFreezeFightTranslations {
    SWORD("§7Sword"),
    BOW("§6Bow"),
    EGG("§6Egg"),
    ARROW("§6Arrow"),
    INVNAME("§6FreezeFight InventarSortierung"),
    INVENTORYUPDATED("§6Deine Inventar Sortierung für FreezeFight wurde aktualisiert");

    @Getter
    private String translation;
}
