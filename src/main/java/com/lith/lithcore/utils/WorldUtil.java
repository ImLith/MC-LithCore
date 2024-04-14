package com.lith.lithcore.utils;

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
}
