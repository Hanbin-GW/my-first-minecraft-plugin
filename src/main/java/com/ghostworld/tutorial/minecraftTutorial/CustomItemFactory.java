package com.ghostworld.tutorial.minecraftTutorial;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CustomItemFactory {
    public static ItemStack createTVPlacer() {
        ItemStack item = new ItemStack(Material.STICK); // 또는 다른 아이템으로 변경 가능
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("TV Placer");
        meta.setLore(List.of("TV를 설치할 수 있는 특수 아이템입니다."));
        meta.setCustomModelData(1001); // 리소스팩에서 custom_model_data 1001과 연동
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack createLegendarySword() {
        ItemStack item = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("전설의 검");
        meta.setLore(List.of("강력한 힘이 깃든 검"));
        meta.setLore(List.of("무제한의 내구성을 가지고 있습니다!"));
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.POWER, 255, true);
        meta.addEnchant(Enchantment.FLAME, 255, true);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack createDrill() {
        ItemStack item = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Drill");
        meta.setLore(List.of("아주빠르게 블록을 캡니다"));
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack createShotgunArrow(){
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Shotgun Arrow");
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack createBigFuckingCrossbow(){
        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("BFC");
        item.setItemMeta(meta);
        return item;
    }
}
