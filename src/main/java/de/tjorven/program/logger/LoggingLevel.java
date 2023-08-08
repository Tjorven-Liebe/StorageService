package de.tjorven.program.logger;

import java.sql.Date;
import java.text.SimpleDateFormat;

public enum LoggingLevel {

    INFORMATION("§8[§3INFORMATION§8]§r"), WARNING("§8[§eWARNING§8]§r"), ERROR("§8[§cERROR§8]§4");

    private final String text;

    LoggingLevel(String text) {
        this.text = text;
    }

    private String time() {
        Date date = new Date(System.currentTimeMillis());
        return ("§8" + new SimpleDateFormat("hh:mm:ss").format(date) + " §r");
    }

    public String getText() {
        return time() + text;
    }
}
