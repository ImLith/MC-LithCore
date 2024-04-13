package com.lith.lithcore.config;

import com.lith.lithcore.Static.ConfigKeys;
import com.lith.lithcore.abstractClasses.AbstractPlugin;
import lombok.Getter;
import com.lith.lithcore.abstractClasses.AbstractConfigManager;

public class ConfigManager<P extends AbstractPlugin<P, ConfigManager<P>>>
        extends AbstractConfigManager<P, ConfigManager<P>> {
    @Getter
    private ConfigMessages configMsg;

    public ConfigManager(final P plugin) {
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
