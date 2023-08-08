package de.tjorven.program.logger;

import java.io.PrintStream;

public class Logger {

    private final PrintStream out = System.out;

    public <T> void log(LoggingLevel loggingLevel, T text) {
        out.println(loggingLevel.getText() + " " + text);
    }

    public <T> void log(ConsoleColor color, T text) {
        out.println(color.getColor() + text);
    }

    public void log(Throwable throwable) {
        String error = translateAlternateColorCodes(LoggingLevel.ERROR.getText());
        out.println(error + " " + throwable.getMessage());
        for (StackTraceElement stackTraceElement : throwable.getStackTrace()) {
            out.println(error + " " + stackTraceElement);
        }
        out.print(error + " For a more detailed log, don't use Logger");
        out.println(translateAlternateColorCodes("§r"));
    }

    public void logRaw(String string) {
        out.println(translateAlternateColorCodes(string + "§r"));
    }

    public void log(LoggingLevel loggingLevel, String string) {
        out.println(translateAlternateColorCodes(loggingLevel.getText() + " " + string));
    }

    public void info(String string) {
        out.println(translateAlternateColorCodes(LoggingLevel.INFORMATION.getText() + " " + string));
    }

    public void warn(String string) {
        out.println(translateAlternateColorCodes(LoggingLevel.WARNING.getText() + " " + string));
    }

    private String translateAlternateColorCodes(String string) {
        for (ConsoleColor value : ConsoleColor.values())
            string = string.replace(value.code, value.color);
        return string;
    }
}