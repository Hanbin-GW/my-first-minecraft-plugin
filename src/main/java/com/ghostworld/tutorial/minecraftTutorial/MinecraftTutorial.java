package com.ghostworld.tutorial.minecraftTutorial;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftTutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("My First Tutorial Plugin Enabled!");
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getCommand("givesword").setExecutor(new GiveSwordCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("My First Tutorial Plugin Disabled!");
        HandlerList.unregisterAll(this);
    }
}
