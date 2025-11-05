package com.semihakin685.essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class FeedCommand extends Command {

    public FeedCommand() {
        super("feed", "You satisfy your hunger.");
        this.setPermission("essentials.command.feed");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly players can use this command!");
            return false;
        }

        Player player = (Player) sender;

        if(!sender.hasPermission("essentials.command.feed")) {
            player.sendMessage("§cYou do not have permission to use this command.");
            return false;
        }

        player.getFoodData().setFood(20);
        player.sendPopup("§aYour hunger is satisfied");
        return true;
    }
}
