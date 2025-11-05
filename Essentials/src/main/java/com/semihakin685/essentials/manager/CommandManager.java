package com.semihakin685.essentials.manager;

import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.plugin.Plugin;
import com.semihakin685.essentials.commands.*;

import java.util.List;

public class CommandManager {

    private final Plugin plugin;

    public CommandManager(Plugin plugin) {
        this.plugin = plugin;
    }

    public void registerCommands() {
        SimpleCommandMap map = Server.getInstance().getCommandMap();

        List<Command> commands = List.of(
                new FlyCommand(),
                new FeedCommand(),
                new HealCommand(),
                new RulesCommand(),
                new ClearChatCommand()
        );

        for (Command command : commands) {
            map.register(plugin.getName().toLowerCase(), command);
        }

        plugin.getLogger().info("Total" + commands.size() + " command saved successfully.");
    }
}