/**  
 * @Title:  MinaCastThread.java   
 * @Package com.nettycast.cast   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: Shuofang     
 * @date:   2019年1月10日 下午3:22:16   
 * @version V1.0 
 * @Copyright: 2019 
 */
package com.ruoyi.broadserver.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shuofang
 *	TODO
 */
public class MinaCastThread implements Runnable {
	private MinaCastHandler mHandler;
	private NioSocketAcceptor Acceptor;
	//private NioDatagramAcceptor netheartAcceptor;
	private Integer port; 
	private String ip = null;
    private static Logger logger = LoggerFactory.getLogger(MinaCastThread.class);
    /**
	 * 
	 * TODO 无地址初始化
	 * 时间：2019年1月10日
	 */
	public MinaCastThread(int loginport) {
		// TODO Auto-generated constructor stub
		this.port = loginport;
	}
	/**
	 * 
	 * TODO 有地址初始化
	 * 时间：2019年1月10日
	 */
	public MinaCastThread(int port,String ip) {
		// TODO Auto-generated constructor stub
		this.port = port;
		this.ip = ip;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		mHandler = new MinaCastHandler();
		// TODO Auto-generated method stub
		// ** loginAcceptor设置
        Acceptor = new NioSocketAcceptor();
        // 此行代码能让你的程序整体性能提升10倍
        Acceptor.getFilterChain()
                .addLast("loginIOThreadPool", new ExecutorFilter(Executors.newCachedThreadPool())); 
        Acceptor.setReuseAddress(true);//加上这句话，避免重启时提示地址被占用
        // 设置MINA2的IoHandler实现类
        Acceptor.setHandler(mHandler);
        logger.info("创建 Acceptor");
        // 设置会话超时时间（单位：毫秒），不设置则默认是10秒，请按需设置
        //Acceptor.setSessionRecycler(new ExpiringSessionRecycler(8 * 1000));
        // ** TCP通信配置
		SocketSessionConfig cfg = (SocketSessionConfig) Acceptor.getSessionConfig();  
		Acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 300);
		//Acceptor.getSessionConfig().setUseReadOperation(true);
		cfg.setSoLinger(0);
        // ** UDP通信配置
       /* DatagramSessionConfig logindcfg = Acceptor.getSessionConfig();
        logindcfg.setReuseAddress(true);*/
        // 设置输入缓冲区的大小，压力测试表明：调整到2048后性能反而降低
        //logindcfg.setReceiveBufferSize(1024);
        // 设置输出缓冲区的大小，压力测试表明：调整到2048后性能反而降低
        //logindcfg.setSendBufferSize(1024);
        //acceptor.bind(arg0, arg1);
        // ** UDP服务端开始侦听
        //acceptor.bind(new InetSocketAddress(6970));
      /*  ////** netheartAcceptor设置
        netheartAcceptor = new NioDatagramAcceptor();
        // 此行代码能让你的程序整体性能提升10倍
        netheartAcceptor.getFilterChain()
                .addLast("netheartIOThreadPool", new ExecutorFilter(Executors.newCachedThreadPool())); 
        // 设置MINA2的IoHandler实现类
        netheartAcceptor.setHandler(mHandler);
        // 设置会话超时时间（单位：毫秒），不设置则默认是10秒，请按需设置
        netheartAcceptor.setSessionRecycler(new ExpiringSessionRecycler(8 * 1000));
         */
        try {
        	if(ip != null) {
        		Acceptor.bind(new InetSocketAddress(ip,port));
        	}else {
        		Acceptor.bind(new InetSocketAddress(port));
        	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
        logger.info("TCP服务器正在端口 "+port+" 上监听中...");
        if(ip != null) {
        	logger.info("TCP服务器监听IP为 "+ip);
        }
	}
	/**
	 * @return the mHandler
	 */
	public MinaCastHandler getmHandler() {
		return mHandler;
	}
	/**
	 * @return the acceptor
	 */
	public NioSocketAcceptor getAcceptor() {
		return Acceptor;
	}
	
}
