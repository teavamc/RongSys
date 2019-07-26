package com.ruoyi.broadserver.server.handle.impl;

import com.ruoyi.broad.utils.bConvert;
import com.ruoyi.broadserver.global.ProtocolsToClient;
import com.ruoyi.broadserver.server.handle.DefaultCommand;
import org.apache.mina.core.session.IoSession;


//获取基站信息
public class ReadBS extends DefaultCommand {

	public ReadBS(IoSession session, byte[] content) {
		super(session, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] execute() {
		try {
			String[] infos = datainfo.split(",");

			String command = save(infos)?"1":"0";//保存信息

			loggersession();//插入日志

			return returnBytes(ProtocolsToClient.CELLPOS, command, null);
		} catch (Exception e) {
			logger.error("解析信息出错",e);
		}
		return null;
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
