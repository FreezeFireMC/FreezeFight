package de.chaos.mc.freezefight.utils;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class GameUtils {
    public static AttributeInstance setCountdown(Player player) {
        AttributeInstance attributeInstance = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
        attributeInstance.setBaseValue(10);
        player.saveData();
        return attributeInstance;
    }
}
