package com.semihakin685.essentials;

import cn.nukkit.plugin.PluginBase;
import com.semihakin685.essentials.manager.CommandManager;;

public class Main extends PluginBase {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Essentials enable!");
        new CommandManager(this).registerCommands();
    }

    public static Main getInstance() {
        return instance;
    }
}
