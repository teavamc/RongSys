package com.ruoyi.streamsocket.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 张超 teavamc
 * @Description: 流媒体 WebSocket 处理类
 * @ClassName StreamHandler
 * @date 2019/2/16 15:57
 **/
public class StreamHandler  implements WebSocketHandler {
    private final ArrayList<WebSocketSession> streams = new ArrayList<WebSocketSession>();
    private final ArrayList<String> streamids = new ArrayList<String>();
    private final ArrayList<Boolean> streamstates = new ArrayList<Boolean>();

    //	private final ArrayList<VlcStreamThread> vlcthreads = new ArrayList<VlcStreamThread>();//vlc直播线程

    ExecutorService executorService =  Executors.newFixedThreadPool(100);

    protected static final Logger log = LoggerFactory.getLogger(StreamHandler.class);

    /**
        * 连接关闭之前
        * @author 张超 teavamc
        * @date 2019/2/21
        * @param [session, arg1]
        * @return void
        */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1)
            throws Exception {
        for(int i=0;i<streams.size();i++){
            if(session==streams.get(i)){
                if(streamids.size()>i){
                    String sid = streamids.get(i);
                    streamids.remove(i);
                    if(streamstates.size()>i){
                        if(streamstates.get(i)){
                            //ws连接结束，并直播未关闭则关闭直播
                            sendCMDtoSocket(session,"end:"+sid);
                            streamstates.set(i, false);
                        }
                        streamstates.remove(i);
                    }
                }
            }
        }
        streams.remove(session);
        if(session.isOpen()) session.close();
        log.info( "正常日志："+session.getRemoteAddress() + " 断开连接!" );
    }

    /**
        * 连接后 创建 WebSocket Session
        * @author 张超 teavamc
        * @date 2019/2/20
        * @param [session]
        * @return void
        */
    @Override
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {
        streams.add(session);
        log.info( "正常日志："+session.getRemoteAddress() + ": 打开连接！"  );
    }

    /**
        * 业务信息处理 描述
        * @author 张超 teavamc
        * @date 2019/2/21
        * @param [conn, message]
        * @return void
        */
    @Override
    public void handleMessage(WebSocketSession conn, WebSocketMessage<?> message)
            throws Exception {
        System.out.println("String message: "+message.getPayload());
        String[] rs = message.getPayload().toString().split(":");
        String commd="";
        String imeilist="";
        String streamid="";
        if(rs.length>=2){
            commd=rs[0];
            streamid=rs[1];
            if(rs.length>2)
                imeilist=rs[2];
        }
        switch(commd){
            case "start":
                for(int i=0;i<streams.size();i++){
                    if(conn==streams.get(i)){
                        streamids.add(i, streamid);
                        streamstates.add(i,true);
                    }
                }
                conn.sendMessage(new TextMessage("start:success"));

                log.info( "正常日志："+conn.getRemoteAddress() + ":开始直播 ");
                break;
            case "end":
                for(int i=0;i<streams.size();i++){
                    if(conn==streams.get(i)){
                        if(streamstates.size()>i){
                            streamstates.add(i,false);
                        }
                    }
                }
                conn.sendMessage(new TextMessage("end:success"));
                log.info( "正常日志："+ conn.getRemoteAddress() + ":结束直播 ");
                break;
        }
        sendCMDtoSocket(conn,message.getPayload().toString());

        System.out.println( conn.getRemoteAddress() + ": " + message.getPayload() );
    }

    /**
        * 发送指令 描述
        * @author 张超 teavamc
        * @date 2019/2/21
        * @param [conn, msg]
        * @return void
        */
    private void sendCMDtoSocket(WebSocketSession conn,String msg){
        //给后台socket服务器发送命令
        executorService.execute(new Runnable(){
            @Override
            public void run() {
                try {
                    new NettyClient(conn,msg).start();
                } catch (Exception e) {
                    log.error( "错误日志："+e.getMessage()+ " ");
                    try {
                        conn.sendMessage(new TextMessage("error:socketconnect"));
                    } catch (IOException e1) {
                        log.error( "错误日志："+e1.getMessage()+ " ");
                    }
                }
            }
        });
    }
    @Override
    public void handleTransportError(WebSocketSession session, Throwable arg1)
            throws Exception {
        if(session.isOpen()){
            session.close();
        }
        log.error( "出错日志: IP:" +session.getRemoteAddress()+"  "+ arg1.getMessage() );
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }


}
