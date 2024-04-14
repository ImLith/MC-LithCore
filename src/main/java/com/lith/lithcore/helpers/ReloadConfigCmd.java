package com.lith.lithcore.helpers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import com.lith.lithcore.abstractClasses.AbstractCommand;
import com.lith.lithcore.abstractClasses.AbstractPlugin;

public class ReloadConfigCmd<P extends AbstractPlugin<P, ?>> extends AbstractCommand<P> {
    protected final String permission;
    protected final Boolean onlyPlayer = false;
    protected final String usage;

    public ReloadConfigCmd(P plugin, String permission, String cmd) {
        super(plugin, cmd);

        this.permission = permission;
        this.usage = "Use '" + cmd + "' to reload the configs";
        plugin.getCommand(cmd).setExecutor(this);
    }

    public ReloadConfigCmd(P plugin, String permission, String cmd, String usage) {
        super(plugin, cmd);

        this.permission = permission;
        this.usage = usage;
        plugin.getCommand(cmd).setExecutor(this);
    }

    @Override
    public boolean onExecute(CommandSender sender, Command command, String label, String[] args) {
        plugin.reloadConfigs();

        return true;
    }

    @Override
    public String usage() {
        return usage;
    }
}
