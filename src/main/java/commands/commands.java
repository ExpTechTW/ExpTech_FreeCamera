package commands;

import function.freecam;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class commands implements CommandExecutor{

    private final JavaPlugin plugin;

    public commands(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(Objects.equals(label, "cam")) {
            if(!sender.getName().equals("CONSOLE")) {
                    freecam.FreeCam(sender.getName());
            }
        }
        return true;
    }
}
