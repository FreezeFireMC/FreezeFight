package de.chaos.mc.freezefight.utils.translations;

import de.chaos.mc.serverapi.utils.stringLibary.AbstractMessages;
import org.bukkit.entity.Player;

public class FreezeFightEnglishTranslations {
    public static String playerWasKilled(Player player, Player killer) {
        return AbstractMessages.normalMessage(player.getName() + "wurde von" + killer.getName() + " getötet!");
    }
}