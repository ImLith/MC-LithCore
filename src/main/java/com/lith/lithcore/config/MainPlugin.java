package com.lith.lithcore.config;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class MainPlugin<T extends PluginConfigManager> extends JavaPlugin {
    public T cm = null;
}
