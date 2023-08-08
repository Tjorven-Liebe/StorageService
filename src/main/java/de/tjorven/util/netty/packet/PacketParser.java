package de.tjorven.util.netty.packet;

import java.io.*;
import java.util.Base64;

public class PacketParser {

    public static String getObjectBytes(Packet<?> v) throws IOException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(arrayOutputStream);
        outputStream.writeObject(v);
        outputStream.close();
        arrayOutputStream.close();
        return Base64.getEncoder().encodeToString(arrayOutputStream.toByteArray());
    }

    public static Packet<?> getObjectBytes(String base64) throws IOException, ClassNotFoundException {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(base64));
        ObjectInputStream inputStream = new ObjectInputStream(arrayInputStream);
        Packet<?> packet = (Packet<?>) inputStream.readObject();
        arrayInputStream.close();
        inputStream.close();
        return packet;
    }
}
