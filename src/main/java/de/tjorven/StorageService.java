package de.tjorven;

import de.tjorven.program.logger.Logger;
import de.tjorven.program.logger.LoggingLevel;
import de.tjorven.util.Services;

public class StorageService {

    public static void main(String[] args) throws InterruptedException {
        Services.load();
        Logger logger = new Logger();
        try {
            test(null);
        } catch (NullPointerException e) {
            logger.log(e);
        }
        int a = 0;
        for (int i = 0; i < 150; i++) {
            a++;
            Thread.sleep(100);
            if (a % 3 == 0)
                logger.log(LoggingLevel.WARNING, i + " Total improvetes logging");
            else
                logger.log(LoggingLevel.INFORMATION, i + " Total improvetes logging");
        }
    }

    private static void test(String string) {
        System.out.println(string.length());
    }

}
