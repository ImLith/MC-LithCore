package com.lith.lithcore.utils;

import com.lith.lithcore.constants.LightConstant;

public final class LightUtil {
    public static int subtractLevel(int current) {
        return addLevel(current, -1);
    }

    public static int addLevel(int current) {
        return addLevel(current, 1);
    }

    public static int addLevel(int current, int amount) {
        return getValidatedLevel(current + amount, LightConstant.MIN, LightConstant.MAX);
    }

    public static int setLevel(int level) {
        return getValidatedLevel(level, LightConstant.MIN, LightConstant.MAX);
    }

    public static int setLevel(int level, int min) {
        return getValidatedLevel(level, min, LightConstant.MAX);
    }

    public static int setLevel(int level, int min, int max) {
        return getValidatedLevel(level, min, max);
    }

    private static int getValidatedLevel(int level, int min, int max) {
        return Math.min(Math.max(Math.min(Math.max(level, min), max), LightConstant.MIN), LightConstant.MAX);
    }
}
