package com.lith.lithcore.abstractClasses;

import org.bukkit.configuration.file.FileConfiguration;
import com.lith.lithcore.utils.StringUtil;

public abstract class AbstractConfigManager<P extends AbstractPlugin<P, C>, C extends AbstractConfigManager<P, C>> {
    protected final P plugin;
    public FileConfiguration config = null;

    public AbstractConfigManager(final P plugin) {
        this.plugin = plugin;
    }

    public void load() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
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

    protected int getInt(String key) {
        return config.getInt(key);
    }

    protected int getRgbValue(String key) {
        int color = getInt(key);

        return color > 255 ? 255 : color < 0 ? 0 : color;
    }

    protected Object getObject(String key) {
        return config.get(key);
    }
}
