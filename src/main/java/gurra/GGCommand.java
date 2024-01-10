package gurra;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;

public class GGCommand implements TabExecutor {

    Map<String, Object> config = ConfigLoader.loadConfig("config.yml");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2){
            try {
                int mode = Integer.parseInt(args[1]);
                if (sender instanceof Player){
                } else {
                    assert sender != null;
                    if (sender.isOp()){
                        sendGG(mode);
                    }
                    sendGG(mode);
                }
            } catch (NumberFormatException e) {
                // Parsing failed, the argument is not an integer
                sender.sendMessage("The argument is not an integer.");
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }

    public void sendGG(int mode){
        float time = System.currentTimeMillis();
        List<String> ggList = (List<String>) config.get(String.valueOf(mode));

        try {
            while((time + 10000) > System.currentTimeMillis()) {
                sendColoredMessagesToConsole(ggList);
            }
        } catch (NullPointerException e) {
            System.err.println("Error: 'stringList' not found in the configuration file.");
            e.printStackTrace();
        }
    }

    private void sendColoredMessagesToConsole(List<String> coloredMessages) {
        // Send each colored message to the console
        for (String message : coloredMessages) {
            String coloredMessage = ChatColor.translateAlternateColorCodes('&', message);
            Bukkit.getServer().getConsoleSender().sendMessage(coloredMessage);
        }
    }
}
