package com.lith.lithcore;

import com.lith.lithcore.abstractClasses.MainPlugin;
import com.lith.lithcore.config.ConfigManager;

public class Plugin extends MainPlugin<ConfigManager> {
  public static MainPlugin<ConfigManager> plugin;

  public void onEnable() {
    Plugin.plugin = this;

    new ConfigManager(this);

    Static.log.info("Plugin enabled");
  }

  public void onDisable() {
    Static.log.info("Plugin enabled");
  }
}
