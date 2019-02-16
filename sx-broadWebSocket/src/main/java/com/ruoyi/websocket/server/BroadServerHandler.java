package com.ruoyi.websocket.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author 张超 teavamc
 * @Description: 服务端逻辑处理类
 * @ClassName BroadServerHandler
 * @date 2019/2/14 22:29
 **/
public class BroadServerHandler extends SimpleChannelInboundHandler<Object> {

    /**
        * 业务逻辑处理
        * @author 张超 teavamc
        * @date 2019/2/16
        * @param [ctx, msg]
        * @return void
        */
    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) {
        System.out.println("服务器返回信息 :" + msg);
        ctx.channel().writeAndFlush("服务器已接收信息" + msg);
        ctx.close();
    }

    /**
        * 建立连接后，发送信息
        * @author 张超 teavamc
        * @date 2019/2/16
        * @param [ctx]
        * @return void
        */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("线程通道激活>>>>>>>>");
    }
}