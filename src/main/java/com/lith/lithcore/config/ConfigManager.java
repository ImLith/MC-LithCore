package com.lith.lithcore.config;

import com.lith.lithcore.Static.ConfigKeys;
import com.lith.lithcore.abstractClasses.MainPlugin;
import com.lith.lithcore.abstractClasses.PluginConfigManager;
import net.md_5.bungee.api.ChatColor;

public class ConfigManager extends PluginConfigManager {
    private final ConfigMessages messages;

    public ConfigManager(final MainPlugin<ConfigManager> plugin) {
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
                    config.getString(ConfigKeys.Messages.SECTION + "." + key));
        }
    }
}
