package com.lith.lithcore.classes.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import com.lith.lithcore.abstractClasses.AbstractCommand;
import com.lith.lithcore.abstractClasses.MainPlugin;

@SuppressWarnings("rawtypes")
public class ReloadConfigCmd<P extends MainPlugin> extends AbstractCommand<P> {
    protected final String permission;
    protected final Boolean onlyPlayer = false;

    public ReloadConfigCmd(P plugin, String permission, String cmd) {
        super(plugin, cmd);

        this.permission = permission;
        plugin.getCommand(cmd).setExecutor(this);
    }

    @Override
    public boolean onExecute(CommandSender sender, Command command, String label, String[] args) {
        plugin.registerConfigs();

        return true;
    }

    @Override
    public String usage() {
        return "Use '" + commandName + "' to reload the configs";
    }
}
