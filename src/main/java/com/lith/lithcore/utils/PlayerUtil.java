package com.lith.lithcore.utils;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerUtil {
    public static List<String> getOnlinePlayerNames() {
        return PlayerUtil.generateOnlinePlayerNames(null);
    }

    public static List<String> getOnlinePlayerNames(List<String> ignoreNames) {
        return PlayerUtil.generateOnlinePlayerNames(ignoreNames);
    }

    public static int getExpForLevel(int level) {
        if (level <= 15)
            return 2 * level + 7;
        if (level <= 30)
            return 5 * level - 38;
        return 9 * level - 158;
    }

    public static int getCurrentExpInLevel(Player player) {
        return getCurrentExpInLevel(player.getLevel());
    }

    public static int getCurrentExpInLevel(int level) {
        if (level == 0)
            return 0;
        if (level <= 16)
            return (int) (Math.pow(level, 2) + 6 * level);
        if (level <= 31)
            return (int) (2.5 * Math.pow(level, 2) - 40.5 * level + 360);
        return (int) (4.5 * Math.pow(level, 2) - 162.5 * level + 2220);
    }

    public static int getCurrentExp(Player player) {
        return getCurrentExp(player.getLevel(), player.getExp(), player.getExpToLevel());
    }

    public static int getCurrentExp(int level, float expPercentage, int expToNextLevel) {
        return getCurrentExpInLevel(level) + Math.round(expPercentage * expToNextLevel);
    }

    private static List<String> generateOnlinePlayerNames(List<String> ignoreNames) {
        List<String> names = new ArrayList<>();

        for (Player player : Bukkit.getOnlinePlayers()) {
            final String playerName = player.getName();

            if (ignoreNames == null || !ignoreNames.contains(playerName))
                names.add(player.getName());
        }

        return names;
    }
}
