package com.ruoyi.websocket.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author 张超 teavamc
 * @Description:TODO
 * @ClassName ServerHandler
 * @date 2019/2/14 22:29
 **/
public class ServerHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) {
        System.out.println("服务器返回信息 :" + msg);
        ctx.channel().writeAndFlush("服务器已接收信息" + msg);
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("线程通道激活>>>>>>>>");
    }
}