package com.ruoyi.websocket.client;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;

//实现了可序列化接口，直接继承自java.net.SocketAddress类
import java.net.InetSocketAddress;

//这里使用slf4j记录日志
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 张超 teavamc
 * @Description: 客户端类
 * @ClassName BroadClient
 * @date 2019/2/14 22:30
 **/
public class BroadClient {
    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(BroadClient.class);
    // 客户端初始化对象
    private static Bootstrap b;
    // 异步结果返回对象
    private static ChannelFuture f;
    // 业务线程组对象
    private static final EventLoopGroup workerGroup = new NioEventLoopGroup();

    /**
        * 客户端初始
        * @author 张超 teavamc
        * @date 2019/2/16
        * @param []
        * @return void
        */
    private static void init () {
        try {
            log.info("NettyClient开始初始化");
            b = new Bootstrap();
            b.group(workerGroup);
            // 异步客户端的 TCP Socket 连接
            b.channel(NioSocketChannel.class);
            // SO_KEEPALIVE  Socket参数，连接保活，默认值为False
            // 启用该功能时，TCP会主动探测空闲连接的有效性。可以将此功能视为TCP的心跳机制
            // 需要注意的是：默认的心跳间隔是7200s即2小时。Netty默认关闭该功能
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel socketChannel) {
                    // 解码编码
                    socketChannel.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
                    socketChannel.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));

                    socketChannel.pipeline().addLast(new BroadClientHandler());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object startAndWrite(InetSocketAddress address, Object send) throws InterruptedException {
        init();
        f = b.connect(address).sync();
        // 传数据给服务端
        f.channel().writeAndFlush(send);
        f.channel().closeFuture().sync();
        return f.channel().attr(AttributeKey.valueOf("Attribute_key")).get();
    }

    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 7000);
        String message = "你好";
        try {
            Object result = BroadClient.startAndWrite(address, message);
            log.info("原因: " + result);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            f.channel().close();
            workerGroup.shutdownGracefully();
            log.info("关闭客户端!");
        }
    }
}
