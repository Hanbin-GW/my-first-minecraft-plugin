package com.ghostworld.tutorial.minecraftTutorial;

import net.kyori.adventure.key.Key;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import net.kyori.adventure.sound.Sound;

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
        Key key = Key.key("ghostcraft", "drilling");
        Sound sound = Sound.sound(key, Sound.Source.MASTER, 0.8f, 1.0f);
        player.playSound(sound);
        block.breakNaturally(item);
        player.swingMainHand();
    }

    @EventHandler
    public void onShoot(EntityShootBowEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!(event.getProjectile() instanceof Arrow originalArrow)) return;

        ItemStack bow = event.getBow();
        if (bow == null || !bow.hasItemMeta()) return;

        // 커스텀 활 여부 확인 (예: 이름 비교 또는 PersistentDataContainer 사용)
        String displayName = bow.getItemMeta().getDisplayName();
        String name = ChatColor.stripColor(bow.getItemMeta().getDisplayName());
        if("BFC".equals(displayName))
        {

        }

        else if ("Shotgun Arrow".equals(displayName)) {

            // 원래 화살은 그대로 두고, 추가 화살 4개 발사
            Location loc = player.getEyeLocation();
            Vector direction = loc.getDirection().normalize();

            for (int i = 0; i < 4; i++) {
                Arrow arrow = player.getWorld().spawnArrow(loc, direction, 2.0f, 1.0f);
                arrow.setShooter(player);
                arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);

                // 산탄 퍼짐: 방향 약간 회전
                Vector spread = direction.clone();

                double yawSpread = (Math.random() - 0.5) * 0.4; // 좌우
                double pitchSpread = (Math.random() - 0.5) * 0.4; // 상하

                spread = spread.add(new Vector(yawSpread, pitchSpread, yawSpread)).normalize();
                arrow.setVelocity(spread.multiply(2.0));
            }
        }
    }
}
