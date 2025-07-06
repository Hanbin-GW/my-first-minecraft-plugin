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
        player.setResourcePack("https://www.ghost-world.co.kr/static/GW_Resource_Pack/ghostcraft.zip", "1686d4c1f4c5840e436771ecc0ee14dde2b2b521",true);
        player.sendTitle("Hello " + player.getName() + "!", "Welcome to the server!", 10, 70, 20);
    }
}
