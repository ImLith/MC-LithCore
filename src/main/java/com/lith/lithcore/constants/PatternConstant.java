package com.lith.lithcore.constants;

import java.util.regex.Pattern;

public final class PatternConstant {
    public final static Pattern unicodeSearch = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
}
