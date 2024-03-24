package com.lith.lithcore.abstractClasses;

import org.bukkit.configuration.file.FileConfiguration;

@SuppressWarnings("rawtypes")
public abstract class PluginConfigManager {
    public final FileConfiguration config;

    @SuppressWarnings("unchecked")
    public PluginConfigManager(final MainPlugin plugin) {
        plugin.reloadConfig();
        plugin.saveDefaultConfig();

        plugin.cm = this;
        this.config = plugin.getConfig();
    }
}
