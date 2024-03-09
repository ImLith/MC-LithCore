package com.lith.lithcore.config;

import org.bukkit.configuration.ConfigurationSection;
import com.lith.lithcore.Static;
import com.lith.lithcore.abstractClasses.MainPlugin;
import com.lith.lithcore.abstractClasses.PluginConfigManager;

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
            ConfigurationSection section = config.getConfigurationSection(Static.ConfigKeys.Messages.SECTION);

            if (section == null) {
                this.onlyPlayer = Static.Default.Messages.ONLY_PLAYER;
                this.noPermission = Static.Default.Messages.NO_PERMISSION;
            } else {
                this.onlyPlayer = section.getString(Static.ConfigKeys.Messages.ONLY_PLAYER);
                this.noPermission = section.getString(Static.ConfigKeys.Messages.NO_PERMISSION);
            }
        }
    }
}
