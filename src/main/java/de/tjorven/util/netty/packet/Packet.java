package de.tjorven.util.netty.packet;

import de.tjorven.util.netty.packet.packets.DeletePacket;

import java.io.Serializable;

public abstract class Packet<V> implements Serializable {

    private V value;

    public Packet(V value) {
        this.value = value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public abstract void run();

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Packet{" +
                "value=" + value +
                '}';
    }
}
