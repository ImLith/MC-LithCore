package com.lith.lithcore.utils;

import com.lith.lithcore.constants.WorldConstant;

public final class TimeUtil {
    public static long convertMinsToSeconds(final long min) {
        return min * 60;
    }

    public static long convertMinsToTicks(final long min) {
        return TimeUtil.convertMinsToSeconds(min) * WorldConstant.TICKS_IN_SEC;
    }
}
