//package com.rouyi.websocket.server;
//
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.SimpleChannelInboundHandler;
//
///**
// * @author 张超 teavamc
// * @Description:TODO
// * @ClassName ServerHandler
// * @date 2019/2/14 22:29
// **/
//public class ServerHandler extends SimpleChannelInboundHandler<Object> {
//
//    @Override
//    public void channelRead0(ChannelHandlerContext ctx, Object msg) {
//        System.out.println("服务器返回信息，server receive message :" + msg);
//        ctx.channel().writeAndFlush("服务器早已接收你的信息，yes server already accept your message" + msg);
//        ctx.close();
//    }
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) {
//        System.out.println("通过激活，channelActive>>>>>>>>");
//    }
//}