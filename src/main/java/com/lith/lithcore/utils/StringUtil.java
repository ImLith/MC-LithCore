package com.lith.lithcore.utils;

import java.util.regex.Matcher;
import com.lith.lithcore.constants.PatternConstant;
import net.md_5.bungee.api.ChatColor;

public class StringUtil {
    public static String addColors(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String addUnicodes(String text) {
        Matcher matcher = PatternConstant.unicodeSearch.matcher(text);
        StringBuilder builder = new StringBuilder();
        int lastEnd = 0;

        while (matcher.find()) {
            builder.append(text.substring(lastEnd, matcher.start()));
            builder.append(Integer.parseInt(matcher.group(1), 16));
            lastEnd = matcher.end();
        }

        builder.append(text.substring(lastEnd));
        return builder.toString();
    }
}
