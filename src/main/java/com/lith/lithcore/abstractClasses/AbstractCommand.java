package com.lith.lithcore.abstractClasses;

import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.lith.lithcore.Plugin;

public abstract class AbstractCommand<P extends JavaPlugin> implements TabExecutor {
    protected final P plugin;
    protected final String commandName;
    protected final String permission = null;
    protected final Boolean onlyPlayer = true;

    public AbstractCommand(P plugin, String commandName) {
        this.plugin = plugin;
        this.commandName = commandName;
    }

    public abstract boolean onExecute(CommandSender sender, Command command, String label, String[] args);

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase(this.commandName))
            return false;

        if (this.onlyPlayer && !(sender instanceof Player)) {
            sender.sendMessage(Plugin.plugin.cm.messages().onlyPlayer);
            return true;
        }

        if (this.permission != null && !sender.hasPermission(this.permission)) {
            sender.sendMessage(Plugin.plugin.cm.messages().noPermission);
            return true;
        }

        return onExecute(sender, command, label, args);
    }
}
