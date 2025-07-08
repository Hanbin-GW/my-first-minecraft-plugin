package com.ghostworld.tutorial.minecraftTutorial;

import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.NoteBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class CustomBlockPlacer implements Listener {
    @EventHandler
    public void onUseTV(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (!item.hasItemMeta() || !item.getItemMeta().hasDisplayName())
            return;
        if (!item.getItemMeta().getDisplayName().equals("TV Placer"))
            return;

        Block target = event.getClickedBlock().getRelative(event.getBlockFace());
        target.setType(Material.NOTE_BLOCK);

        // instrument=bit, note=5 적용
        NoteBlock noteBlock = (NoteBlock) target.getBlockData();
        noteBlock.setInstrument(org.bukkit.Instrument.BIT);
        noteBlock.setNote(new Note(5));  // 5는 노트 숫자
        target.setBlockData(noteBlock);

        if (item.getAmount() > 1) {
            item.setAmount(item.getAmount() - 1);
        } else {
            player.getInventory().setItemInMainHand(null);
        }
        player.sendMessage("TV가 설치되었습니다!");
        event.setCancelled(true);
    }
}
