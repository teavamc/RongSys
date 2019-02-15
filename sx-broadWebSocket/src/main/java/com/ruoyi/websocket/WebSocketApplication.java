package com.ruoyi.websocket;

import com.ruoyi.websocket.server.NettyServer;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * @author 张超 teavamc
 * @Description: Netty服务启动
 * @ClassName WebSocketApplication
 * @date 2019/2/15 21:34
 **/
@Component
public class WebSocketApplication implements CommandLineRunner {
    @Value("${n.port}")
    private int port;

    @Value("${n.url}")
    private String url;

    @Autowired
    private   NettyServer socketServer;

    @Override
    public void run(String... strings) {
        System.out.println("》》》》》》》》融媒体系统启动成功《《《《《《《\n"+
                "》》》》》》》》Netty程序启动《《《《《《《");
        InetSocketAddress address = new InetSocketAddress(url, port);
        ChannelFuture future = socketServer.run(address);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                socketServer.destroy();
            }
        });
        future.channel().closeFuture().syncUninterruptibly();
    }
}
