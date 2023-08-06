package de.tjorven.program.logger;

public enum ConsoleColor {
    /**
     * @see "https://gist.github.com/fnky/458719343aabd01cfb17a3a4f7296797"
     */
    RESET("\u001B[0m", "§r"), BLACK("\u001B[30m", "§0"), DARK_BLUE("\u001B[34m", "§1"), DARK_GREEN("\u001B[32m", "§2"), DARK_CYAN("\u001B[96m", "§3"), DARK_RED("\u001B[31m", "§4"), PURPLE("\u001B[35m", "§5"), GOLD("\u001B[33m", "§6"), GRAY("\u001B[39m", "§7"), DARK_GRAY("\u001B[90m", "§8"), BLUE("\u001B[36m", "§9"), GREEN("\u001B[92m", "§a"), CYAN("\u001B[94m", "§b"), RED("\u001B[91m", "§c"), MAGENTA("\u001B[95m", "§d"), YELLOW("\u001B[33m", "§e"), WHITE("\u001B[97m", "§f");

    final String color;
    final String code;

    ConsoleColor(String color, String code) {
        this.color = color;
        this.code = code;
    }

    public String getColor() {
        return color;
    }

    public String getCode() {
        return code;
    }
}
