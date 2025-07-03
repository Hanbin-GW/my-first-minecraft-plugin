package com.ghostworld.tutorial.minecraftTutorial;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveItemCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) return false;

        if (args.length == 0) {
            player.sendMessage("§c아이템 종류를 입력해주세요. 사용법: /giveitem <sword|drill>");
            return true;
        }

        String itemType = args[0].toLowerCase();
        ItemStack item = null;

        switch (itemType) {
            case "sword":
                item = CustomItemFactory.createLegendarySword();
                player.sendMessage("§b전설의 검을 지급했습니다!");
                break;

            case "drill":
                item = CustomItemFactory.createDrill();
                player.sendMessage("슈퍼 드릴을 지급했습니다!");
                break;

            case "shotgun":
                item = CustomItemFactory.createShotgunArrow();
                player.sendMessage("샷건 화살이 지금되었습니다!");
                break;

            default:
                player.sendMessage("알 수 없는 아이템 종류입니다. 사용법: /giveitem <sword|drill>");
                return true;
        }

        player.getInventory().addItem(item);
        return true;
    }
}
