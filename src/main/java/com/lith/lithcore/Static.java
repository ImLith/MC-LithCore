package com.lith.lithcore;

import java.util.logging.Logger;

public class Static {
    public static final String pluginName = "LithCore";
    public static final Logger log = Logger.getLogger(Static.pluginName);

    public static class ConfigKeys {
        public static final class Messages {
            public static final String SECTION = "messages";
            public static final String ONLY_PLAYER = "only_players";
            public static final String NO_PERMISSION = "no_permission";
        }
    }

    public static class Default {
        public static final class Messages {
            public static final String ONLY_PLAYER = "&cOnly players can use this command.";
            public static final String NO_PERMISSION = "&cYou don't have permission to use this command.";
        }
    }
}
