package de.tjorven.util.netty;

import de.tjorven.util.Services;
import de.tjorven.util.netty.coder.PacketDecoder;
import de.tjorven.util.netty.coder.PacketEncoder;
import de.tjorven.util.netty.packet.Packet;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

    private final int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        ServerBootstrap bootstrap = new ServerBootstrap();
        Services.logger.info("Enabling Server");
        bootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup());
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(new SocketChannelInitializer());
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);

        ChannelFuture future = bootstrap.bind(port).sync();
        future.channel().closeFuture().sync();
    }
}

class SocketChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel ch) {
        ch.pipeline().addLast(new PacketDecoder(), new PacketEncoder(), new ProcessingHandler());
    }
}
