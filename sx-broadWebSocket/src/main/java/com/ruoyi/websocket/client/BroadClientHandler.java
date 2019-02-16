package com.ruoyi.websocket.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;

/**
 * @author 张超 teavamc
 * @Description: 客户端逻辑处理类
 * @ClassName BroadClientHandler
 * @date 2019/2/14 22:30
 **/
public class BroadClientHandler extends SimpleChannelInboundHandler<Object> {
    /**
        * 业务逻辑处理
        * @author 张超 teavamc
        * @date 2019/2/16
        * @param [channelHandlerContext, msg]
        * @return void
        */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg) {
        channelHandlerContext.channel().attr(AttributeKey.valueOf("Attribute_key")).set(msg);
        channelHandlerContext.close();
    }
}
