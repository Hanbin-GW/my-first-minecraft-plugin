package com.ghostworld.tutorial.minecraftTutorial;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Base64;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Component prompt = Component.text("⚠ 서버 전용 리소스팩이 필요해요!");
        player.setResourcePack("https://www.ghost-world.co.kr/static/GW_Resource_Pack/ghostcraft12.zip", "eeff1cfc7a5cff98c2c77ac5f2a9da117fb3dfdb",true);
        player.sendTitle("Hello " + player.getName() + "!", "Welcome to the server!", 10, 70, 20);
    }
}
