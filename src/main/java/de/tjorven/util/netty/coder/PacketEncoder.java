package de.tjorven.util.netty.coder;

import de.tjorven.util.netty.packet.Packet;
import de.tjorven.util.netty.packet.PacketParser;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

public class PacketEncoder extends MessageToByteEncoder<Packet<?>> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet<?> msg, ByteBuf out) throws Exception {
        String base64 = PacketParser.getObjectBytes(msg);
        out.writeInt(base64.length());
        out.writeCharSequence(base64, StandardCharsets.UTF_8);
    }
}
