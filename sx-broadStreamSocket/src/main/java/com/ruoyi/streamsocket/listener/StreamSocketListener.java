package com.ruoyi.streamsocket.listener;

import com.ruoyi.streamsocket.server.StreamServer;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

/**
 * @author 张超 teavamc
 * @Description:  线程监听器
 * @ClassName StreamSocketListener
 * @date 2019/2/17 19:47
 **/
// SpringBoot 监听器
@WebListener
public class StreamSocketListener implements ServletContextListener {

    // 流媒体线程
    private StreamSocketThread socketThread;
    /**
        * 监听环境关闭
        * 服务器关闭时候执行
        * @author 张超 teavamc
        * @date 2019/2/17
        * @param [e]
        * @return void
        */
    @Override
    public void contextDestroyed(ServletContextEvent e){
        if (socketThread != null && !socketThread.isInterrupted()){
            socketThread.interrupt();
        }
    }

    /**
        * 监听环境初始化
        * @author 张超 teavamc
        * @date 2019/2/17
        * @param [e]
        * @return void
        */
    @Override
    public void contextInitialized(ServletContextEvent e){
        System.out.println("Server contextInitialized over");
        if (socketThread == null){
            // 创建S treamSocketThread
            socketThread = new StreamSocketThread(null);
            // 开启线程
            socketThread.start();
        }
    }
}

/**
    * 流媒体线程
    * @author 张超 teavamc
    * @date 2019/2/17
    */
class StreamSocketThread extends Thread{
    Integer count = 0;
    private StreamServer serverSocket;
    /**
        * 描述
        * @author 张超 teavamc
        * @date 2019/2/17
        * @param [serverSocket]
        * @return
        */
    public StreamSocketThread(StreamServer serverSocket){
        if (serverSocket == null){
            serverSocket = new StreamServer();
        }
        this.serverSocket=serverSocket;
    }
    public void run(){
        // 绑定线程池
        serverSocket.bind();
    }
}
