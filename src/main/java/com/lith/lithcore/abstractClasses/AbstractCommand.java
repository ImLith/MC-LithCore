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
    protected final String permission;
    protected final Boolean onlyPlayer;
    protected final Integer minArgsLength;

    public AbstractCommand(P plugin, String commandName) {
        this(plugin, commandName, null, null, true);
    }

    public AbstractCommand(P plugin, String commandName, Integer minArgsLength) {
        this(plugin, commandName, minArgsLength, null, true);
    }

    public AbstractCommand(P plugin, String commandName, String permission) {
        this(plugin, commandName, null, permission, true);
    }

    public AbstractCommand(P plugin, String commandName, Integer minArgsLength, String permission) {
        this(plugin, commandName, minArgsLength, permission, true);
    }

    public AbstractCommand(P plugin, String commandName, Boolean onlyPlayer) {
        this(plugin, commandName, null, null, onlyPlayer);
    }

    public AbstractCommand(P plugin, String commandName, Integer minArgsLength, Boolean onlyPlayer) {
        this(plugin, commandName, minArgsLength, null, onlyPlayer);
    }

    public AbstractCommand(P plugin, String commandName, String permission, Boolean onlyPlayer) {
        this(plugin, commandName, null, permission, onlyPlayer);
    }

    public AbstractCommand(P plugin, String commandName, Integer minArgsLength, String permission, Boolean onlyPlayer) {
        this.plugin = plugin;
        this.commandName = commandName;
        this.minArgsLength = minArgsLength;
        this.permission = permission;
        this.onlyPlayer = onlyPlayer;
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

        if (onlyPlayer && !(sender instanceof Player)) {
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
