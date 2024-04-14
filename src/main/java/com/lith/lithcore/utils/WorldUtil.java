package com.lith.lithcore.utils;

import java.util.Set;
import java.util.stream.Stream;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import com.lith.lithcore.constants.WorldConstant;

public final class WorldUtil {
    public static boolean isDay(@NotNull final World world) {
        final long time = world.getTime();

        return time >= WorldConstant.DAY_TIME_MIN_VALUE && time < WorldConstant.DAY_TIME_MAX_VALUE;
    }

    public static boolean isNight(@NotNull final World world) {
        return (!(WorldUtil.isDay(world)));
    }

    public static void setDaylightCycle(boolean value) {
        setDaylightCycle(value, null);
    }

    public static void setDaylightCycle(boolean value, Set<String> forWorlds) {
        Stream<World> worlds = Bukkit.getWorlds().stream();

        if (forWorlds != null)
            worlds = worlds.filter(world -> forWorlds.contains(world.getName()));

        worlds.forEach(world -> {
            world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, value);
        });
    }
}
