package de.tjorven.util;

import de.tjorven.program.Options;
import de.tjorven.program.logger.Logger;
import de.tjorven.util.netty.NettyServer;

import java.util.Map;

public class Services {

    public static Logger logger;

    private static Options options;

    private Services() {
    }

    public static void load() throws Exception {
        logger = new Logger();
        options = new Options();
        new NettyServer(8080).run();
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
