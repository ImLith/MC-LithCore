package com.lith.lithcore;

import com.lith.lithcore.abstractClasses.AbstractPlugin;
import com.lith.lithcore.config.ConfigManager;

public class Plugin extends AbstractPlugin<Plugin, ConfigManager<Plugin>> {
  public static Plugin plugin;

  @Override
  public void onEnable() {
    plugin = this;
    configs = new ConfigManager<Plugin>(this);

    super.onEnable();
  }
}
