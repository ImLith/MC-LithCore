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
    protected final Integer minArgsLength;

    public AbstractCommand(P plugin, String commandName) {
        this.plugin = plugin;
        this.commandName = commandName;
        this.minArgsLength = null;
    }

    public AbstractCommand(P plugin, String commandName, Integer minArgsLength) {
        this.plugin = plugin;
        this.commandName = commandName;
        this.minArgsLength = minArgsLength;
    }

    public abstract boolean onExecute(CommandSender sender, Command command, String label, String[] args);

    public abstract String usage();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase(this.commandName))
            return false;

        if (this.onlyPlayer && !(sender instanceof Player)) {
            sender.sendMessage(Plugin.plugin.configs.getConfigMsg().onlyPlayer);
            return true;
        }

        if (this.permission != null && !sender.hasPermission(this.permission)) {
            sender.sendMessage(Plugin.plugin.configs.getConfigMsg().noPermission);
            return true;
        }

        if (this.minArgsLength != null && args.length < this.minArgsLength) {
            sender.sendMessage(usage());
            return true;
        }

        return onExecute(sender, command, label, args);
    }
}
