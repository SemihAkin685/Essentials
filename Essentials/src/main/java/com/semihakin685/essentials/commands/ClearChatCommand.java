package com.semihakin685.essentials.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.Player;
import cn.nukkit.Server;

public class ClearChatCommand extends Command {

    public ClearChatCommand() {
        super("clearchat", "You clear the chat completely.");
        this.setPermission("essentials.command.clearchat");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!sender.hasPermission("essentials.command.clearchat")) {
            sender.sendMessage("§c§cYou do not have permission to use this command.");
            return false;
        }

        for (Player player : Server.getInstance().getOnlinePlayers().values()) {
            for (int i = 0; i < 100; i++) {
                player.sendMessage("");
            }
            player.sendMessage("§eChat §fStaff" + " §ecleared by!");
        }

        return true;
    }
}
