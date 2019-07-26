package com.ruoyi.broadserver.server.handle.impl;

import com.ruoyi.broadserver.domain.SocketInfo;
import com.ruoyi.broadserver.global.GlobalInfo;
import com.ruoyi.broadserver.global.ProtocolsToClient;
import com.ruoyi.broadserver.server.MinaCastHandler;
import com.ruoyi.broadserver.server.handle.DefaultCommand;
import org.apache.mina.core.session.IoSession;
import com.ruoyi.broad.utils.bConvert;

//物联网终端参数透传接口（终端主动请求获取，端口:8900）
public class HeartIOT extends DefaultCommand {

	public HeartIOT(IoSession session, byte[] content) {
		super(session, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] execute() {
		// TODO Auto-generated method stub
		byte[] data = bConvert.subBytes(content, 5, 15);
		String info = new String(data);
		//logger.info("终端主动请求获取");
		String command = save(info)?"1":"0";//保存信息
		
		datainfo = info;
		loggersession();//插入日志
		
		
		return returnBytes(ProtocolsToClient.GETPARAMATER, command, "ok");
	}

	@Override
	public boolean save(Object obj) {
		// TODO Auto-generated method stub
		session.setAttribute(MinaCastHandler.CLIENTINFO, obj);
		SocketInfo info = GlobalInfo.getSocketInfoByIMEI(obj.toString());
		if(info != null){
			synchronized (info){
				info.setIotSession(session);
			}
		}else{

		}
		return true;
	}

	@Override
	public Object get(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
