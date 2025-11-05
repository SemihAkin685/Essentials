package com.semihakin685.essentials.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.window.SimpleForm;

public class RulesCommand extends Command {

    public RulesCommand() {
        super("rules", "Shows the rules of the server.");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if ((!(sender instanceof Player))) {
            return false;
        }

        SimpleForm form = new SimpleForm(
                "Server Rules",
                "Rules1\nRules2\nRules3"
        )
                .addButton("Exit");

        form.send((Player) sender);

        return true;
    }
}