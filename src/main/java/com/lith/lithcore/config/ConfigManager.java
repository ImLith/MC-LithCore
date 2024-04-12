package com.lith.lithcore.config;

import com.lith.lithcore.Static.ConfigKeys;
import com.lith.lithcore.abstractClasses.AbstractPlugin;
import com.lith.lithcore.abstractClasses.AbstractConfigManager;
import net.md_5.bungee.api.ChatColor;

public class ConfigManager extends AbstractConfigManager {
    private final ConfigMessages messages;

    public ConfigManager(final AbstractPlugin<ConfigManager> plugin) {
        super(plugin);

        this.messages = new ConfigMessages();
    }

    public ConfigMessages messages() {
        return this.messages;
    }

    public class ConfigMessages {
        public final String onlyPlayer;
        public final String noPermission;

        public ConfigMessages() {
            this.onlyPlayer = get(ConfigKeys.Messages.ONLY_PLAYER);
            this.noPermission = get(ConfigKeys.Messages.NO_PERMISSION);
        }

        private String get(String key) {
            return ChatColor.translateAlternateColorCodes('&',
                    config.getString(key));
        }
    }
}
