package com.lith.lithcore;

import com.lith.lithcore.abstractClasses.AbstractPlugin;
import com.lith.lithcore.config.ConfigManager;

public class Plugin extends AbstractPlugin<ConfigManager> {
  public static AbstractPlugin<ConfigManager> plugin;

  public void onEnable() {
    Plugin.plugin = this;

    new ConfigManager(this);

    Static.log.info("Plugin enabled");
  }

  public void onDisable() {
    Static.log.info("Plugin enabled");
  }
}
