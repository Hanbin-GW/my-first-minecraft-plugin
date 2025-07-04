package com.ghostworld.tutorial.minecraftTutorial;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftTutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("My First Tutorial Plugin Enabled!");
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new CustomItemListener(), this);
        getCommand("giveItem").setExecutor(new GiveItemCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("My First Tutorial Plugin Disabled!");
        HandlerList.unregisterAll(this);
    }
}
