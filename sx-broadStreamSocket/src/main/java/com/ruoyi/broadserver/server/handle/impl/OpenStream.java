package com.ruoyi.broadserver.server.handle.impl;

import com.ruoyi.broad.utils.bConvert;
import com.ruoyi.broadserver.global.ProtocolsToClient;
import com.ruoyi.broadserver.server.handle.DefaultCommand;
import org.apache.mina.core.session.IoSession;

//启动流媒体传输
public class OpenStream extends DefaultCommand {

	public OpenStream(IoSession session, byte[] content) {
		super(session, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] execute() {
		// TODO Auto-generated method stub
		byte[] data = bConvert.subBytes(content, 5, 6);
		String info = new String(data);

		String command = save(info)?"1":"0";//保存信息
		
		
		datainfo = info;
		loggersession();//插入日志
	
		return returnBytes(ProtocolsToClient.OPENSTREAM, command, "OK");
	}

	@Override
	public boolean save(Object obj) {
		// TODO Auto-generated method stub
		if(obj.equals("stream")) {
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
