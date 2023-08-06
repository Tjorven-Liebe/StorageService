package de.tjorven.util;

import de.tjorven.program.Options;

import java.util.Map;

public class Services {

    private static Options options;

    private Services() {
    }

    public static void load() {
        options = new Options();
    }

    private static Map<String, String> getSetting() {
        return options.getSettings();
    }

    public static boolean isEnabled(String key) {
        return Boolean.parseBoolean(options.getSettings().get(key));
    }

    public static String getSetting(String key) {
        return getSetting().get(key);
    }
}
