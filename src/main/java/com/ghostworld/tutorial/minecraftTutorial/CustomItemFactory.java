package com.ghostworld.tutorial.minecraftTutorial;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CustomItemFactory {
    public static ItemStack createLegendarySword() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6§l전설의 검");
        meta.setLore(List.of("§7강력한 힘이 깃든 검"));
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.FLAME, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }
}
