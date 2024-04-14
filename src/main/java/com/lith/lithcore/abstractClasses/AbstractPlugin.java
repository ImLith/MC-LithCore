package com.lith.lithcore.abstractClasses;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import java.util.ArrayList;
import java.util.logging.Logger;

public abstract class AbstractPlugin<P extends AbstractPlugin<P, C>, C extends AbstractConfigManager<P, C>>
        extends JavaPlugin {
    protected ArrayList<Listener> registeredEvents = new ArrayList<>();
    public C configs = null;
    public final Logger log;

    public AbstractPlugin() {
        this.log = getLogger();
    }

    public void onEnable() {
        preRegisterConfigs();
        registerConfigs();
        preRegisterEvents();
        registerEvents();
        preRegisterCommands();
        registerCommands();
        onFinishLoading();

        log.info("Plugin enabled");
    }

    public void onDisable() {
        log.info("Plugin enabled");
    }

    public void reloadConfigs() {
        registerConfigs();
    }

    protected void preRegisterConfigs() {
    }

    protected void registerConfigs() {
        if (this.configs != null)
            configs.load();
    }

    protected void preRegisterEvents() {
    }

    protected void registerEvents() {
    }

    protected void preRegisterCommands() {
    }

    protected void registerCommands() {
    }

    protected void onFinishLoading() {
    };

    protected void registerEvent(Listener event) {
        registerEvent(event, false);
    }

    protected void registerEvent(Listener event, Boolean isSilent) {
        getServer().getPluginManager().registerEvents(event, this);

        if (!isSilent)
            registeredEvents.add(event);
    }

    protected void unregisterAllEvents() {
        for (Listener event : registeredEvents)
            HandlerList.unregisterAll(event);

        registeredEvents.clear();
    }
}
