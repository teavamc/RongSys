package com.ruoyi.broadserver.global;

import com.ruoyi.broadserver.server.MinaCastHandler;
import com.ruoyi.broadserver.server.MinaCastThread;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class GlobalInfo {
    private static ExecutorService executorService =  null;//终端交互处理线程池
    private static MinaCastThread minaCastThread;//服务器端口监听Mina处理Acceptor
    private static Map<String, IoSession> IMEI_Client = new HashMap<>();//终端IMEI与其对应IOSession
    private static final Logger logger = LoggerFactory.getLogger(GlobalInfo.class);

    /**
     * 将线程加入线程池运行
     * @param thread
     */
    public static void putThreadintoPool(Runnable thread){
        if(executorService!=null)
            executorService.execute(thread);
    }

    /**
     * 将终端加入Map中运行
     * @param session
     */
    public static void putClientToMap(IoSession session){
       synchronized (IMEI_Client){
           if(!IMEI_Client.get((String)session.getAttribute(MinaCastHandler.CLIENTINFO)).equals(session)){
               IMEI_Client.put((String)session.getAttribute(MinaCastHandler.CLIENTINFO),session);
           }
       }
    }
    /**
     *
     * @param senddata 发送的byte[]组
     * @param session 目标session
     * @param Timeout 延时长度
     * TODO	发送数据给终端
     * 时间：2019年1月11日
     */
    public static void SendData(byte[] senddata,IoSession session,int Timeout) {
        putThreadintoPool(new Runnable() {
            @Override
            public void run() {
                // IO线程池中运行
                if(Timeout > 0) {
                    try {
                        Thread.sleep(Timeout < 500 ? Timeout:500);
                    } catch (InterruptedException e) {
                        // TODO 延时长度，保证某些有序发送段能做到,防止线程池堵塞，最多延时500毫秒
                        e.printStackTrace();
                    }
                }
                if(senddata != null) {
                    IoBuffer buf = IoBuffer.wrap(senddata);
                    WriteFuture future = session.write(buf);
                    // 在100毫秒超时间内等待写完成
                    future.awaitUninterruptibly(100);
                    // The message has been written successfully
                    if( future.isWritten())
                    {
                        // send sucess!
                    }
                    // The messsage couldn't be written out completely for some reason.
                    // (e.g. Connection is closed)
                    else
                    {
                        logger.warn("回复给客户端的数据发送失败！IP:"+((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress());
                    }
                }
            }
        });
    }

    public static ExecutorService getExecutorService() {
        return executorService;
    }

    public static void setExecutorService(ExecutorService executorService) {
        GlobalInfo.executorService = executorService;
    }

    public static MinaCastThread getMinaCastThread() {
        return minaCastThread;
    }

    public static void setMinaCastThread(MinaCastThread minaCastThread) {
        GlobalInfo.minaCastThread = minaCastThread;
    }

    public static Map<String, IoSession> getIMEI_Client() {
        return IMEI_Client;
    }

    public static void setIMEI_Client(Map<String, IoSession> IMEI_Client) {
        GlobalInfo.IMEI_Client = IMEI_Client;
    }
}
