package de.tjorven.util.netty.coder;

import de.tjorven.util.netty.packet.Packet;
import de.tjorven.util.netty.packet.PacketParser;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class PacketDecoder extends ReplayingDecoder<Packet<?>> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(PacketParser.getObjectBytes((String) in.readCharSequence(in.readInt(), StandardCharsets.UTF_8)));
    }
}
