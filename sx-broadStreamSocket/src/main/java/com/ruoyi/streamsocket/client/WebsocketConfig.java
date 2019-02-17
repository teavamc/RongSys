package com.ruoyi.streamsocket.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author 张超 teavamc
 * @Description:TODO
 * @ClassName WebsocketConfig
 * @date 2019/2/16 15:57
 **/

//
//@Configuration
//@EnableWebMvc
//@EnableWebSocket
public class WebsocketConfig  implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // TODO Auto-generated method stub

        registry.addHandler(streamWebSocketHandler(), "/stream"); //提供符合W3C标准的Websocket数据
    }
    @Bean
    public WebSocketHandler streamWebSocketHandler() {
        return new StreamHandler();
    }
}

