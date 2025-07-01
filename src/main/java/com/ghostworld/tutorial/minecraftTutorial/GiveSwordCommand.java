package com.ghostworld.tutorial.minecraftTutorial;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveSwordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player.getInventory().addItem(CustomItemFactory.createLegendarySword());
            player.sendMessage("§b전설의 검을 지급했습니다!");
            return true;
        }
        return false;
    }
}