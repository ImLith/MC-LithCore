package com.lith.lithcore.config;

import org.bukkit.configuration.file.FileConfiguration;

public abstract class PluginConfigManager {
    protected final FileConfiguration config;

    public PluginConfigManager(final FileConfiguration config) {
        this.config = config;
    }
}
