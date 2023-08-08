package de.tjorven.util.netty.packet.packets;

import de.tjorven.util.netty.packet.Packet;

public class DeletePacket extends Packet<String> {

    private final String key;

    public DeletePacket(String key) {
        super("delete");
        this.key = key;
    }

    @Override
    public void run() {

    }

    public String getKey() {
        return key;
    }
}
