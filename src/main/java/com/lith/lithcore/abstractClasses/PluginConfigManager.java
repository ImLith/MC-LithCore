package com.lith.lithcore.abstractClasses;

import org.bukkit.configuration.file.FileConfiguration;

import com.lith.lithcore.utils.StringUtil;

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

    protected String getMessage(String key) {
        return getMessage(key, true, true);
    }

    protected String getMessage(String key, Boolean addColors) {
        return getMessage(key, addColors, true);
    }

    protected String getMessage(String key, Boolean addColors, Boolean addUnicodes) {
        String text = getString(key);

        if (text == null)
            return null;
        if (addColors)
            text = StringUtil.addColors(text);
        if (addUnicodes)
            text = StringUtil.addUnicodes(text);

        return text;
    }

    protected String getString(String key) {
        return config.getString(key);
    }

    protected Boolean getBool(String key) {
        return config.getBoolean(key);
    }

    protected Long getLong(String key) {
        return config.getLong(key);
    }

    protected Object getObject(String key) {
        return config.get(key);
    }
}
