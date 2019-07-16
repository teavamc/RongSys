package com.ruoyi.broadserver.server.handle.impl;

import com.ruoyi.broadserver.global.ProtocolsToClient;
import com.ruoyi.broadserver.server.handle.DefaultCommand;
import org.apache.mina.core.session.IoSession;
import com.ruoyi.broad.utils.bConvert;

//LED字幕更新（终端主动请求获取）
public class ClientLED extends DefaultCommand {

	public ClientLED(IoSession session, byte[] content) {
		super(session, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] execute() {
		// TODO Auto-generated method stub
		byte[] data = bConvert.subBytes(content, 5, 3);
		String info = new String(data);

		String command = save(info)?"1":"0";//保存信息
		
		
		datainfo = info;
		loggersession();//插入日志
	
		String returnStr = (String)get(session);
		return returnBytes(ProtocolsToClient.OPENSTREAM, command, returnStr);
	}

	@Override
	public boolean save(Object obj) {
		// TODO Auto-generated method stub
		if(obj.equals("LED")) {
			//to do sth
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Object get(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
