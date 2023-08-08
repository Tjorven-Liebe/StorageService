import de.tjorven.util.netty.coder.PacketDecoder;
import de.tjorven.util.netty.coder.PacketEncoder;
import de.tjorven.util.netty.packet.Packet;
import de.tjorven.util.netty.packet.packets.SavePacket;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.List;

public class NettyClient {

    private final ChannelFuture future;

    public static void main(String[] args) throws Exception {
        NettyClient nettyClient = new NettyClient();
    }

    public NettyClient() throws InterruptedException {
        Bootstrap b = new Bootstrap();
        b.group(new NioEventLoopGroup());
        b.channel(NioSocketChannel.class);
        b.option(ChannelOption.SO_KEEPALIVE, true);
        b.handler(new SocketChannelInitializer());
        future = b.connect("localhost", 8080).sync();
    }

    public void sendPacket(Packet<?> packet) {
        try {
            future.channel().writeAndFlush(packet).sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class SocketChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel ch) {
        ch.pipeline().addLast(new PacketEncoder(), new PacketDecoder(), new ClientHandler());
    }
}
