package com.lith.lithcore;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
  private static final Logger LOGGER = Logger.getLogger("lithcore");

  public void onEnable() {
    LOGGER.info("lithcore enabled");
  }

  public void onDisable() {
    LOGGER.info("lithcore disabled");
  }
}
