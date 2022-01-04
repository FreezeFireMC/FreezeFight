package de.chaos.mc.freezefight.utils;

import de.chaos.mc.freezefight.FreezeFight;
import de.chaos.mc.serverapi.utils.playerlibary.languageLibary.LanguageInterface;
import de.chaos.mc.serverapi.utils.playerlibary.languageLibary.LanguageType;

import java.util.UUID;

public class FreezeFightStringLoader {
    private static final LanguageInterface languageInterface = FreezeFight.getServerAPI().getLanguageInterface();

    public static void loadLanguage(UUID uuid) {
        GamePlayerLanguage playerLanguage = null;
        switch (languageInterface.getLanguageType(uuid)) {
            case EG:
                playerLanguage = GamePlayerLanguage.builder()
                        .uuid(uuid)
                        .type(LanguageType.EG)
                        .build();
                FreezeFight.getOnlinePlayers().put(uuid, playerLanguage);
                break;
            case DE:
                playerLanguage = GamePlayerLanguage.builder()
                        .uuid(uuid)
                        .type(LanguageType.DE)
                        .build();
                FreezeFight.getOnlinePlayers().put(uuid, playerLanguage);
                break;
            case FR:
                playerLanguage = GamePlayerLanguage.builder()
                        .uuid(uuid)
                        .type(LanguageType.FR)
                        .build();
                FreezeFight.getOnlinePlayers().put(uuid, playerLanguage);
                break;
            case OTHER:
                playerLanguage = GamePlayerLanguage.builder()
                        .uuid(uuid)
                        .type(LanguageType.OTHER)
                        .build();
                FreezeFight.getOnlinePlayers().put(uuid, playerLanguage);
        }

    }
}
