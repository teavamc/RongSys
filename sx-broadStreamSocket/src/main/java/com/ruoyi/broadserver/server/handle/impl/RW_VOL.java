package com.ruoyi.broadserver.server.handle.impl;

import com.ruoyi.broad.utils.bConvert;
import com.ruoyi.broadserver.global.ProtocolsToClient;
import com.ruoyi.broadserver.server.handle.DefaultCommand;
import org.apache.mina.core.session.IoSession;


//终端设置音量
public class RW_VOL extends DefaultCommand {

	public RW_VOL(IoSession session, byte[] content) {
		super(session, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] execute() {
		// TODO Auto-generated method stub
		byte[] data = bConvert.subBytes(content, 5, 4);
		
		String command = save(data)?"1":"0";//保存音量或者执行对应操作
		
		loggersession();//插入日志
		
		String reinfo = (String)get(session);//获取修改的音量
		return returnBytes(ProtocolsToClient.VOL, command, reinfo);
	}

	@Override
	public boolean save(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object get(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
