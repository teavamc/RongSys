package com.ruoyi.streamsocket.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.socket.SocketChannel;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.socket.WebSocketSession;

/**
 * @author 张超 teavamc
 * @Description:TODO
 * @ClassName NettyClient
 * @date 2019/2/16 15:43
 **/
public class NettyClient {

    private static final Logger log = LoggerFactory.getLogger(NettyClient.class);
//    //思信地址
//    private  String host = "110.53.162.164";

    // 张超服务器地址
    private  String host = "120.79.42.11";
//    交互端口
    private  int port = 8800;

//    声明一个 WebSocketSession 对象 conn
    public WebSocketSession conn;
    public String message;

    /**
        * 初始化一个 NettyClient 对象
        * @author 张超 teavamc
        * @date 2019/2/16
        * @param [connection, message]
        * @return
        */
    public NettyClient(WebSocketSession connection,String message) {
        this.host = host;
        this.port = port;
        this.message = message;
        this.conn = connection;
    }

    /**
        * NettyClient 的线程执行体
        * @author 张超 teavamc
        * @date 2019/2/16
        * @param []
        * @return void
        */
    public void start() throws Exception {
        // 创建一个新的 EventLoopGroup 类型是 异步 UDP 对象
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // 创建一个 启动类 实例
            Bootstrap b = new Bootstrap();
            // 注册线程池
            b.group(group)
                    // 使用NioSocketChannel来作为连接用的channel类 ， TCP Socket
                    .channel(NioSocketChannel.class)
                    // 绑定连接端口和host信息
                    .remoteAddress(new InetSocketAddress(this.host, this.port))
                    // 绑定连接初始化器
                    .handler(new ChannelInitializer<SocketChannel>() {
                        // 注册通道
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
//	                                     System.out.println(" connected...");
                            ch.pipeline().addLast(new NettyClientHandler(conn,message));
                        }
                    });
//	             System.out.println(" created..");
            // 异步连接服务器
            ChannelFuture cf = b.connect().sync();
//	             System.out.println(" connected..."); // 连接完成
            // 异步等待关闭连接channel
            cf.channel().closeFuture().sync();
//	             System.out.println(" closed.."); // 关闭完成
        } finally {
            // 释放线程池资源
            group.shutdownGracefully().sync();
        }
    }
}
