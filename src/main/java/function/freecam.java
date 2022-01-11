package function;

import core.logger;
import main.main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class freecam {
    public static File dataFile;
    public static YamlConfiguration data;

    public static void FreeCam(String playerName){
        org.bukkit.entity.Player player=getServer().getPlayer(playerName);
        File f = new File(main.folder, "PlayerData.yml");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                logger.log("ERROR","FreeCamera_FreeCam",e.getMessage());
            }
        }
        dataFile = f;
        data = YamlConfiguration.loadConfiguration(f);
        assert player != null;
        if(player.getGameMode()== GameMode.SURVIVAL){
            data.set(playerName, player.getLocation());
            saveData();
            player.setGameMode(GameMode.SPECTATOR);
            Bukkit.broadcastMessage(playerName+" \u5df2\u9032\u5165 \u81ea\u7531\u8996\u89d2 \u6a21\u5f0f");
        }else {
            if(data.getLocation(playerName)==null){
                player.sendMessage("\u6578\u64da\u7570\u5e38\uff0c\u7121\u6cd5\u57f7\u884c");
                return;
            }
            player.teleport(Objects.requireNonNull(data.getLocation(playerName)));
            player.setGameMode(GameMode.SURVIVAL);
            Bukkit.broadcastMessage(playerName+" \u5df2\u96e2\u958b \u81ea\u7531\u8996\u89d2 \u6a21\u5f0f");
        }
    }

    public static void saveData() {
        try {
            data.save(dataFile);
        } catch (IOException e) {
            logger.log("ERROR","FreeCamera_FreeCam",e.getMessage());
        }
    }
}
