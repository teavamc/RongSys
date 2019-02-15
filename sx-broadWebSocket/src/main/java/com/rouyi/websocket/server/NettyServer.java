//package com.rouyi.websocket.server;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import org.springframework.stereotype.Component;
//
////这里使用slf4j记录日志
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.net.InetSocketAddress;
//
///**
// * @author 张超 teavamc
// * @Description:TODO
// * @ClassName NettyServer
// * @date 2019/2/14 22:27
// **/
//@Component
//public class NettyServer {
//    //这里使用slf4j记录日志
//    private static final Logger log = LoggerFactory.getLogger(NettyServer.class);
//
//    private final EventLoopGroup bossGroup = new NioEventLoopGroup();
//    private final EventLoopGroup workerGroup = new NioEventLoopGroup();
//
//    private Channel channel;
//
//    /**
//     * 启动服务
//     */
//    public ChannelFuture run(InetSocketAddress address) {
//
//        ChannelFuture f = null;
//        try {
//            ServerBootstrap b = new ServerBootstrap();
//            b.group(bossGroup, workerGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .childHandler(new ServerChannelInitializer())
//                    .option(ChannelOption.SO_BACKLOG, 128)
//                    .childOption(ChannelOption.SO_KEEPALIVE, true);
//
//            f = b.bind(address).syncUninterruptibly();
//            channel = f.channel();
//        } catch (Exception e) {
//            log.error("Netty start error:", e);
//        } finally {
//            if (f != null && f.isSuccess()) {
//                log.info("Netty server listening " + address.getHostName() + " on port " + address.getPort() + " and ready for connections...");
//            } else {
//                log.error("Netty server start up Error!");
//            }
//        }
//
//        return f;
//    }
//
//    public void destroy() {
//        log.info("关闭Netty服务器，Shutdown Netty Server...");
//        if (channel != null) {
//            channel.close();
//        }
//        workerGroup.shutdownGracefully();
//        bossGroup.shutdownGracefully();
//        log.info("关闭Netty服务器成功，Shutdown Netty Server Success!");
//    }
//}