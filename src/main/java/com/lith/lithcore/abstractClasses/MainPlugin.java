package com.lith.lithcore.abstractClasses;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class MainPlugin<T extends PluginConfigManager> extends JavaPlugin {
    public T cm = null;

    public void registerConfigs() {
        throw new UnsupportedOperationException("Unimplemented method 'onExecute'");
    }
}
