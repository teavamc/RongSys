package com.ruoyi.broadserver.server.handle.impl;

import com.ruoyi.broadserver.server.handle.DefaultCommand;
import org.apache.mina.core.session.IoSession;

import com.ruoyi.broad.utils.bConvert;
import com.ruoyi.broadserver.global.ProtocolsToClient;
//紧急界面播出回执（新建连接）
public class BroadCast extends DefaultCommand {

	public BroadCast(IoSession session, byte[] content) {
		super(session, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] execute() {
		// TODO Auto-generated method stub
		byte[] data = bConvert.subBytes(content, 5, 24);
		String info = new String(data);
		String[] infos = info.split(",");

		String command = save(infos)?"1":"0";//保存信息并执行对应操作
		
		datainfo = info;
		loggersession();//插入日志
		
		return returnBytes(ProtocolsToClient.BROADCAST, command, null);
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
