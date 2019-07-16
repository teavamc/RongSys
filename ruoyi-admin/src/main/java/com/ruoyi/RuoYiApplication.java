package com.ruoyi;


import com.ruoyi.broadserver.global.GlobalInfo;
import com.ruoyi.broadserver.server.MinaCastThread;
import com.ruoyi.server.CheckServer;
import org.apache.mina.core.service.IoAcceptor;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import java.net.InetSocketAddress;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan({"com.ruoyi.*.mapper"})
// 监听器
@ServletComponentScan(value = "com.ruoyi.streamsocket.listener")
public class RuoYiApplication implements CommandLineRunner {
    @Autowired
    CheckServer checkServer;

    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);

    }

    @Override
    public void run(String... strings) throws Exception {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
        checkServer.run(address);
    }
}