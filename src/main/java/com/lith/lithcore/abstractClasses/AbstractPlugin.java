package com.lith.lithcore.abstractClasses;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import java.util.ArrayList;
import org.bukkit.event.HandlerList;

public abstract class AbstractPlugin<T extends AbstractConfigManager> extends JavaPlugin {
    protected ArrayList<Listener> registeredEvents = new ArrayList<>();
    public T cm = null;

    public void registerConfigs() {
        throw new UnsupportedOperationException("Unimplemented method 'onExecute'");
    }

    protected void registerEvent(Listener event) {
        registerEvent(event, false);
    }

    protected void registerEvent(Listener event, Boolean isSilent) {
        getServer().getPluginManager().registerEvents(event, this);

        if (!isSilent)
            registeredEvents.add(event);
    }

    protected void unregisterAllEvents() {
        for (Listener event : registeredEvents) {
            HandlerList.unregisterAll(event);
        }

        registeredEvents.clear();
    }
}
