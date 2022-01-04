package de.chaos.mc.freezefight.utils;

import de.chaos.mc.serverapi.utils.playerlibary.languageLibary.LanguageType;
import lombok.Builder;
import lombok.Data;
import org.bukkit.entity.Player;

import java.util.UUID;

@Data
@Builder
public class GamePlayerLanguage {
    public UUID uuid;
    public LanguageType type;

    public String playerWasKilled(Player player, Player killer) {
        return FreezeFightAbstractMessages.playerWasKilled(player, killer);
    }
}
