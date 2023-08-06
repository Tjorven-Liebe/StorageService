package de.tjorven;

import de.tjorven.util.Services;

public class StorageService {

    public static void main(String[] args) {
        Services.load();
        System.out.println(Services.getSetting("test1"));
    }

}
