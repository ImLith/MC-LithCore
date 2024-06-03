package com.lith.lithcore.config;

import com.lith.lithcore.Plugin;
import com.lith.lithcore.Static.ConfigKeys;
import lombok.Getter;
import com.lith.lithcore.abstractClasses.AbstractConfigManager;

public class ConfigManager extends AbstractConfigManager<Plugin, ConfigManager> {
    @Getter
    private ConfigMessages configMsg;

    public ConfigManager(final Plugin plugin) {
        super(plugin);
    }

    @Override
    public void load() {
        super.load();

        this.configMsg = new ConfigMessages();
    }

    public class ConfigMessages {
        public final String onlyPlayer;
        public final String noPermission;

        public ConfigMessages() {
            this.onlyPlayer = getMessage(ConfigKeys.Messages.ONLY_PLAYER);
            this.noPermission = getMessage(ConfigKeys.Messages.NO_PERMISSION);
        }
    }
}
