package de.chaos.mc.freezefight.utils;

import de.chaos.mc.freezefight.FreezeFight;
import de.chaos.mc.freezefight.utils.translations.FreezeFightEnglishTranslations;
import de.chaos.mc.freezefight.utils.translations.FreezeFightGermanTranslations;
import org.bukkit.entity.Player;

public class FreezeFightAbstractMessages {
    public static String playerWasKilled(Player player, Player killer) {
        String string = null;
        switch (FreezeFight.getServerAPI().getLanguageInterface().getLanguageType(player.getUniqueId())) {
            case EG:
                string = FreezeFightEnglishTranslations.playerWasKilled(player, killer);
                break;
            case DE:
                string = FreezeFightGermanTranslations.playerWasKilled(player, killer);
            case FR:
                string = FreezeFightEnglishTranslations.playerWasKilled(player, killer);
                break;
            case OTHER:
                string = FreezeFightEnglishTranslations.playerWasKilled(player, killer);
                break;
        }
        return string;
    }
}
