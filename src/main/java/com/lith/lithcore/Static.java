package com.lith.lithcore;

import com.lith.lithcore.abstractClasses.AbstractConfigKey;

public final class Static {
    public static final class ConfigKeys {
        public static final class Messages extends AbstractConfigKey {
            public static final String ONLY_PLAYER = setKey("only_players");
            public static final String NO_PERMISSION = setKey("no_permission");
        }
    }
}
