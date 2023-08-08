package de.tjorven.util.netty.packet.packets;

import de.tjorven.util.Services;
import de.tjorven.util.netty.packet.Packet;

public class SavePacket<V> extends Packet<V> {

    private final String key;

    public SavePacket(String key, V information) {
        super(information);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public void run() {
        Services.logger.info("info: " + getKey() + ":" + getValue());
    }
}
