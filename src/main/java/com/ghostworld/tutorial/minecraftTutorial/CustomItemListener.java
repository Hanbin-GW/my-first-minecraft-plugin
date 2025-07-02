package com.ghostworld.tutorial.minecraftTutorial;

import org.bukkit.ChatColor;
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
        if (event.isCancelled()) return;

        Block block = event.getClickedBlock();
        if (block == null) return;

        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (!item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) return;

        String name = ChatColor.stripColor(item.getItemMeta().getDisplayName());
        if (!name.equals("Drill")) return;
        block.breakNaturally(item);
        player.swingMainHand();
    }

}
