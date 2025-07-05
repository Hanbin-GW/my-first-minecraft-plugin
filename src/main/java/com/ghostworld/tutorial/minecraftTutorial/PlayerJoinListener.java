package com.ghostworld.tutorial.minecraftTutorial;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Base64;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setResourcePack("https://www.ghost-world.co.kr/static/GW_Resource_Pack.zip", "467c860b4ed4e881322095322e6dc98aae533d65",true);
        player.sendTitle("Hello " + player.getName() + "!", "Welcome to the server!", 10, 70, 20);
    }
}
