package com.ruoyi.websocket.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

//这里使用slf4j记录日志
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * @author 张超 teavamc
 * @Description: 服务端类
 * @ClassName NettyServer
 * @date 2019/2/14 22:27
 **/
@Component
public class BroadServer {
    // 这里使用slf4j记录日志
    private static final Logger log = LoggerFactory.getLogger(BroadServer.class);

    // NIO Reactro
    // 创建boss线程组 用于服务端接收客户端的连接
    private final EventLoopGroup bossGroup = new NioEventLoopGroup();
    // 创建worker线程组 用于进行SocketChannel的数据读写
    private final EventLoopGroup workerGroup = new NioEventLoopGroup();
    // 创建通道对象
    private Channel channel;

    /**
     * 启动服务
     */
    public ChannelFuture run(InetSocketAddress address) {

        // 获取异步返回结果
        ChannelFuture f = null;
        try {
            // 创建 ServerBootstrap 对象
            ServerBootstrap b = new ServerBootstrap();
            // 使用 之前创建的两个EventLoopGroup
            b.group(bossGroup, workerGroup)
                    // 设置要被实例化的 NioServerSocketChannel 类，代表异步的服务器端 TCP Socket 连接
                    .channel(NioServerSocketChannel.class)
                    // 设置 进入服务端的 Client 的 SocketChannel 处理器
                    .childHandler(new BroadServerChannelInitializer())
                    // SO_BACKLOG  Socket参数
                    // 服务端接受连接的队列长度，如果队列已满，客户端连接将被拒绝
                    // 默认值，Windows为200，其他为128
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // SO_KEEPALIVE  Socket参数，连接保活，默认值为False
                    // 启用该功能时，TCP会主动探测空闲连接的有效性。可以将此功能视为TCP的心跳机制
                    // 需要注意的是：默认的心跳间隔是7200s即2小时。Netty默认关闭该功能
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            // 绑定端口
            f = b.bind(address).syncUninterruptibly();
            channel = f.channel();
        } catch (Exception e) {
            log.error("Netty启动报错:", e);
        } finally {
            // 打印信息
            if (f != null && f.isSuccess()) {
                log.info("Netty 服务监听地址名: " + address.getHostName() + "服务监听地址: " + address.getAddress() + " 端口号: " + address.getPort() + " 已连接");
            } else {
                log.error("Netty 服务启动错误!");
            }
        }

        return f;
    }

    public void destroy() {
        log.info("关闭Netty服务器");
        if (channel != null) {
            // 关闭服务端
            channel.close();
        }
        // 关闭两个 EventLoopGroup 对象
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
        log.info("关闭Netty服务器成功!");
    }
}