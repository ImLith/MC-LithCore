package com.lith.lithcore.utils;

import java.util.Map;
import org.bukkit.World;
import com.lith.lithcore.constants.WorldConstant;

public class WorldUtil {
    public static boolean isDay(final World world) {
        final long time = world.getTime();

        return time >= WorldConstant.DAY_TIME_MIN_VALUE && time < WorldConstant.DAY_TIME_MAX_VALUE;
    }

    public static boolean isNight(final World world) {
        return (!(WorldUtil.isDay(world)));
    }
}
