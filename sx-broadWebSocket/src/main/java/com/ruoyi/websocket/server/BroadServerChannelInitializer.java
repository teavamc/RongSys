package com.ruoyi.websocket.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author 张超 teavamc
 * @Description: 服务端通道初始化
 * @ClassName BroadServerChannelInitializer
 * @date 2019/2/14 22:28
 **/
public class BroadServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) {
        // 解码
        socketChannel.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
        // 编码
        socketChannel.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
        // 逻辑实现
        socketChannel.pipeline().addLast(new BroadServerHandler());
    }
}