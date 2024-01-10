package gurra;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public final class GG extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("sendgg").setExecutor(new GGCommand());
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

