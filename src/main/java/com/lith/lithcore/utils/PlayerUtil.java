package com.lith.lithcore.utils;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerUtil {
    public static List<String> getOnlinePlayerNames() {
        return PlayerUtil.generateOnlinePlayerNames(null);
    }

    public static List<String> getOnlinePlayerNames(ArrayList<String> ignoreNames) {
        return PlayerUtil.generateOnlinePlayerNames(ignoreNames);
    }

    private static List<String> generateOnlinePlayerNames(ArrayList<String> ignoreNames) {
        List<String> names = new ArrayList<>();

        for (Player player : Bukkit.getOnlinePlayers()) {
            final String playerName = player.getName();

            if (ignoreNames != null && !ignoreNames.contains(playerName))
                names.add(player.getName());
        }

        return names;
    }
}
