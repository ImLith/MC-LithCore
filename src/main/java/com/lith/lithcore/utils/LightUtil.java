package com.lith.lithcore.utils;

import com.lith.lithcore.constants.LightConstant;

public final class LightUtil {
    public static int setLevel(int level) {
        return setLevel(level, false);
    }

    public static int setLevel(int level, Boolean rotate) {
        return validateLightLevelLogic(level, LightConstant.MIN, LightConstant.MAX, rotate);
    }

    public static int setLevel(int level, int min) {
        return setLevel(level, min, false);
    }

    public static int setLevel(int level, int min, Boolean rotate) {
        return validateLightLevelLogic(level, getMinLightLevel(min), LightConstant.MAX, rotate);
    }

    public static int setLevel(int level, int min, int max) {
        return setLevel(level, min, max, false);
    }

    public static int setLevel(int level, int min, int max, Boolean rotate) {
        return validateLightLevelLogic(level, getMinLightLevel(min), getMaxLightLevel(max), true);
    }

    public static int getMinLightLevel(int lvl) {
        return Math.max(lvl, LightConstant.MIN);
    }

    public static int getMaxLightLevel(int lvl) {
        return Math.min(lvl, LightConstant.MAX);
    }

    private static int validateLightLevelLogic(int level, int min, int max, Boolean rotate) {
        if (!rotate)
            return Math.min(Math.max(level, min), max);

        if (level > max)
            return min;

        if (level < min)
            return max;

        return level;
    }
}
