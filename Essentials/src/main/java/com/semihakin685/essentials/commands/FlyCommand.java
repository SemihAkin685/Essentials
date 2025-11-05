package com.semihakin685.essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.AdventureSettings;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class FlyCommand extends Command {

    public FlyCommand() {
        super("fly", "Toggle your flight mode on or off.");
        this.setPermission("essentials.command.fly");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly players can use this command!");
            return false;
        }

        if (!sender.hasPermission("essentials.command.fly")) {
            sender.sendMessage("§cYou don't have permission to use this command!");
            return false;
        }

        Player player = (Player) sender;
        toggleFly(player);
        return true;
    }

    private void toggleFly(Player player) {
        boolean newState = !player.getAllowFlight();
        player.setAllowFlight(newState);

        if (!newState) {
            player.getAdventureSettings().set(AdventureSettings.Type.FLYING, false);
            player.getAdventureSettings().update();
        }

        String message = newState ? "§aFlight mode enabled." : "§cFlight mode disabled.";
        player.sendPopup(message);
    }
}
