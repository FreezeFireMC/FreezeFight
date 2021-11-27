package de.chaos.mc.freezefight.utils;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class GameUtils {
    public static void setInvItems(Player player) {
        PlayerInventory inventory = player.getInventory();
        inventory.clear();
        inventory.setItem(0, new ItemBuilder(Material.IRON_SWORD).name("§6Schwert").unbreakable(true).itemStack());
        inventory.setItem(1, new ItemBuilder(Material.BOW).name("§6Bogen").enchantment(Enchantment.ARROW_DAMAGE, 3).unbreakable(true).enchantment(Enchantment.ARROW_KNOCKBACK, 1).itemStack());
        inventory.setItem(10, new ItemBuilder(Material.ARROW, 32).itemStack());
        inventory.setItem(3, new ItemBuilder(Material.SNOWBALL, 16).name("§6Frostball").itemStack());
    }
    public static AttributeInstance setCountdown(Player player) {
        AttributeInstance attributeInstance = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
        attributeInstance.setBaseValue(10);
        player.saveData();
        return attributeInstance;
    }
}
