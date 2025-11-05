package com.semihakin685.essentials.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.Player;

public class HealCommand extends Command {

    public HealCommand() {
        super("heal", "You fill your life bar.");
        this.setPermission("essentials.command.heal");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly players can use this command.");
            return false;
        }

        Player player = (Player) sender;

        if(!sender.hasPermission("essentials.command.heal")) {
            player.sendMessage("§cYou do not have permission to use this command.");
            return false;
        }

        player.setHealth(player.getMaxHealth());
        player.sendPopup("§ayour life bar is filled.");
        return true;
    }
}
