package com.ghostworld.tutorial.minecraftTutorial;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CustomItemListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.LEFT_CLICK_BLOCK) return;
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.hasItemMeta() && item.getItemMeta().getDisplayName().equals("Drill")) {
            block.breakNaturally(item);
            player.swingMainHand();
        }
    }
}
