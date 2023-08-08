import de.tjorven.program.logger.Logger;
import de.tjorven.program.logger.LoggingLevel;
import de.tjorven.util.Services;
import de.tjorven.util.netty.packet.Packet;
import de.tjorven.util.netty.packet.PacketParser;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    Logger logger = new Logger();

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("Hooking into channel");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Packet<?> packet = (Packet<?>) msg;
        logger.log(LoggingLevel.INFORMATION, packet.getValue());
    }
}
