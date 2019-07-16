package com.ruoyi.broadserver.server.handle;

import java.nio.ByteBuffer;
import java.util.Date;

import com.ruoyi.streamsocket.server.NettyServerHandler;
import org.apache.mina.core.session.IoSession;
import com.ruoyi.broad.utils.bConvert;
import com.ruoyi.broadserver.global.ProtocolsToClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class DefaultCommand implements Command{
	protected static final Logger logger = LoggerFactory.getLogger(DefaultCommand.class);
    //private SessionManager sessionservice = (SessionService) SpringContextUtils.getBeanByClass(SessionService.class);
    
	protected IoSession session;
	protected byte[] content;
	protected String datainfo = null;
	
	
	public DefaultCommand(IoSession session, byte[] content) {
		this.session = session;
		this.content = content;
	}
	//默认调用返回的格式
	protected byte[] returnBytes(String type,String command,String data) {//data可能为null
		ByteBuffer encoded = ByteBuffer.allocate(data.length()+20);
		encoded.put(bConvert.hexStringToBytes(ProtocolsToClient.PACKETHEAD));//发包的数据头
		encoded.put(bConvert.hexStringToBytes(type));//发包的类型
		encoded.put(bConvert.intToByteArray(command.length()+(data!= null?data.length():0)));//发包的数据长度
		encoded.put(bConvert.hexStringToBytes(command));//发包命令
		if(data != null)encoded.put(data.getBytes());//发包数据
		encoded.put(bConvert.hexStringToBytes(ProtocolsToClient.CHECKCODE+ProtocolsToClient.ENDCHECK));//发包的校验以及结尾
		encoded.flip();  
		byte[] bs = new byte[encoded.remaining()];
		encoded.get(bs);
		encoded.clear();
		return bs;
	}
	//插入日志
	protected void loggersession() {
		if(datainfo != null && !datainfo.equals("")) {
			//do sth
			/*Session mysession = new Session();
			mysession.setSessiondata(datainfo);
			mysession.setSessiondate(new Date());
			mysession.setSessionuser(ProtocolsToClient.SESSIONCLIENT);
			try {
				sessionservice.saveSession(mysession);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
}
