package com.ghostworld.tutorial.minecraftTutorial;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftTutorial extends JavaPlugin {
    private static MinecraftTutorial instance;

    @Override
    public void onEnable() {
        instance = this;
        registerAllRecipes();
        // Plugin startup logic
        getLogger().info("My First Tutorial Plugin Enabled!");
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new CustomItemListener(), this);
        getServer().getPluginManager().registerEvents(new CustomBlockPlacer(), this);
        getCommand("giveItem").setExecutor(new GiveItemCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("My First Tutorial Plugin Disabled!");
        HandlerList.unregisterAll(this);
    }
    public static MinecraftTutorial getInstance() {
        return instance;
    }
    private void registerAllRecipes() {
        // TV 설치기
        ShapedRecipe tv = new ShapedRecipe(
                new NamespacedKey(MinecraftTutorial.getInstance(), "tv_placer"),
                CustomItemFactory.createTVPlacer()
        );
        tv.shape("IRI", "ISI", "IRI");
        tv.setIngredient('I', Material.IRON_INGOT);
        tv.setIngredient('R', Material.REDSTONE);
        tv.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(tv);

        // 산탄활
        ShapedRecipe shotgun = new ShapedRecipe(new NamespacedKey(MinecraftTutorial.getInstance(), "shotgun"), CustomItemFactory.createShotgunArrow());
        shotgun.shape("GGG", "SBS", " I ");
        shotgun.setIngredient('G', Material.GUNPOWDER);
        shotgun.setIngredient('S', Material.STRING);
        shotgun.setIngredient('B', Material.BOW);
        shotgun.setIngredient('I', Material.IRON_INGOT);
        Bukkit.addRecipe(shotgun);
    }
}
