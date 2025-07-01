package com.ghostworld.tutorial.minecraftTutorial;

import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftTutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("My First Tutorial Plugin Enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("My First Tutorial Plugin Disabled!");
    }
}
