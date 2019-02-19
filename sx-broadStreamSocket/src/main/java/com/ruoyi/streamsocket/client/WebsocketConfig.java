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

//WebsocketConfig 注册类
@Configuration
@EnableWebSocket
public class WebsocketConfig  implements WebSocketConfigurer {

    /**
        * 注册 WebSocket 业务类
        * @author 张超 teavamc
        * @date 2019/2/17
        * @param [registry]
        * @return void
        */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        // 提供符合W3C标准的Websocket数据
        // 注册WebSocket业务类，二参为地址
        // 前台推流器地址
        registry.addHandler(streamWebSocketHandler(), "/live_socket");
    }

    /**
        * WebSocket业务类
        * @author 张超 teavamc
        * @date 2019/2/17
        * @param []
        * @return org.springframework.web.socket.WebSocketHandler
        */

    @Bean
    public WebSocketHandler streamWebSocketHandler() {
        return new StreamHandler();
    }
}

