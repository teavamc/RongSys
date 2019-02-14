package com.ruoyi;

import com.rouyi.websocket.server.NettyServer;
import io.netty.channel.ChannelFuture;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.net.InetSocketAddress;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan({"com.ruoyi.*.mapper"})
//@ComponentScan(value = "com.ruoyi.api.controller.broad")
public class RuoYiApplication
{

    /**
        * Netty端口
        */
    @Value("${n.port}")
    private int port;

    /**
     * Netty路由
     */
    @Value("${n.url}")
    private String url;

    /**
     * Netty服务器
     */
    @Autowired
    private NettyServer socketServer;

    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("老天保佑....融媒体平台顺利启动成功！！！\n");
    }


    /**
        * 启动Netty服务器
        * @author 张超 teavamc
        * @date 2019/2/14
        * @param [strings]
        * @return void
        */
    public void run(String... strings) {
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