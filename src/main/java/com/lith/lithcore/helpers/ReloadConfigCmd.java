package com.lith.lithcore.helpers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import com.lith.lithcore.abstractClasses.AbstractCommand;
import com.lith.lithcore.abstractClasses.AbstractPlugin;

public class ReloadConfigCmd<P extends AbstractPlugin<P, ?>> extends AbstractCommand<P> {
    protected final String usage;

    public ReloadConfigCmd(@NotNull P plugin, String permission, @NotNull String cmd) {
        this(plugin, permission, cmd, false);
    }

    public ReloadConfigCmd(@NotNull P plugin, String permission, @NotNull String cmd, Boolean onlyPlayer) {
        this(plugin, permission, cmd, "Use '" + cmd + "' to reload the configs", onlyPlayer);
    }

    public ReloadConfigCmd(@NotNull P plugin, String permission, @NotNull String cmd, @NotNull String usage) {
        this(plugin, permission, cmd, usage, false);
    }

    public ReloadConfigCmd(@NotNull P plugin, String permission, @NotNull String cmd, @NotNull String usage,
            Boolean onlyPlayer) {
        super(plugin, cmd, permission, onlyPlayer);

        this.usage = usage;
        plugin.getCommand(cmd).setExecutor(this);
    }

    @Override
    public boolean onExecute(CommandSender sender, Command command, String label, String[] args) {
        plugin.reloadConfigs();

        if ((sender instanceof Player))
            sender.sendMessage("Configs reloaded!");

        plugin.log.info("Configs reloaded!");
        return true;
    }

    @Override
    public String usage() {
        return usage;
    }
}
