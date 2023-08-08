package de.tjorven.util.netty;

import de.tjorven.util.Services;
import de.tjorven.util.netty.packet.Packet;
import de.tjorven.util.netty.packet.PacketParser;
import de.tjorven.util.netty.packet.packets.SavePacket;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ProcessingHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        Services.logger.info("Registering channel: " + ctx.channel().localAddress().toString());
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        Services.logger.info("Unregistering channel: " + ctx.channel().localAddress().toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Services.logger.info("Received packet");
        Packet<?> packet = (Packet<?>) msg;
        packet.run();
    }
}
