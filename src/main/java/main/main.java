package main;

import commands.commands;
import core.logger;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

import static main.whes1015.VersionCode;

public class main extends JavaPlugin implements Listener {

    public static Integer Support=22031;

    public static File folder;

    @Override
    public void onEnable() {
        if(VersionCode>=Support) {
            folder = getDataFolder();
            Objects.requireNonNull(getCommand("cam")).setExecutor(new commands(this));
            logger.log("INFO", "FreeCamera_onEnable", "Loading Success! - Designed by ExpTech.tw!");
        }else {
            logger.log("WARN","FreeCamera_onEnable","Please update your Core version");
            Bukkit.getPluginManager().disablePlugins();
        }
    }
}
