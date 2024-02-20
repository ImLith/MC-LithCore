package main.java.com.lith.lithcore.utils;

public class ConverterUtil {
    public static long convertMinsToSeconds(final long min) {
        return min * 60;
    }

    public static long convertMinsToTicks(final long min) {
        return ConverterUtil.convertMinsToSeconds(min) * 20;
    }
}
