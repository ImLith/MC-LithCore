package com.lith.lithcore.utils;

import net.md_5.bungee.api.ChatColor;

public final class StringUtil {
    public static String addColors(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String addUnicodes(String text) {
        StringBuilder builder = new StringBuilder();
        int i = 0;

        while (i < text.length()) {
            char currentChar = text.charAt(i);
            if (currentChar == '\\' && i + 1 < text.length() && text.charAt(i + 1) == 'u') {
                try {
                    builder.append((char) Integer
                            .parseInt(text.substring(i + 2, i + 6), 16));
                    i += 6;
                } catch (NumberFormatException e) {
                    builder.append(currentChar);
                    i++;
                }
            } else {
                builder.append(currentChar);
                i++;
            }
        }

        return builder.toString();
    }
}
