package com.ruoyi.broadserver.server.handle.impl;

import com.ruoyi.broad.domain.Organization;
import com.ruoyi.broadserver.domain.SocketInfo;
import com.ruoyi.broadserver.global.GlobalInfo;
import com.ruoyi.broadserver.global.ProtocolsToClient;
import com.ruoyi.broadserver.server.MinaCastHandler;
import com.ruoyi.broadserver.server.handle.DefaultCommand;
import org.apache.mina.core.session.IoSession;
import com.ruoyi.broad.utils.bConvert;
import org.aspectj.weaver.ast.Or;

import java.net.InetSocketAddress;
import java.util.Date;

//获取终端IP（对系统可读可写）并为流媒体心跳包
public class ClientHeart_IP extends DefaultCommand {
	private final static String TYPE = "HEART";
	public ClientHeart_IP(IoSession session, byte[] content) {
		super(session, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] execute() {
		// TODO Auto-generated method stub
		try {
			String command = save(datainfo)?"1":"0";//保存信息
			loggersession();//插入日志
			return returnBytes(ProtocolsToClient.IPCHANGE, command, "nothin");//暂时默认为无流媒体需求
		} catch (Exception e) {
			logger.error("解析信息出错",e);
		}
		return null;
	}
	@Override
	public boolean save(Object obj) {
		// TODO Auto-generated method stub
		try{
			if(obj!= null){
				session.setAttribute(MinaCastHandler.CLIENTINFO, obj);
				SocketInfo info = getSocketInfoByIMEI(obj.toString());
				if(info!=null) {
					if(info.getType().contains(TYPE)){
						synchronized (info) {
							info.setHeartioSession(session);
							info.setIpAddress(((InetSocketAddress) session.getRemoteAddress()).getAddress());
							info.setLastTime(new Date());
						}
					}
				}else{
					Organization terminal = (Organization) get(obj);
					if(terminal != null && terminal.getTerminaltype().contains(TYPE)){
						info = new SocketInfo();
						info.setImei(terminal.getTid());
						info.setIpAddress(((InetSocketAddress) session.getRemoteAddress()).getAddress());
						info.setCommandSession(session);
						info.setType(terminal.getTerminaltype());
						info.setLastTime(new Date());
						putClientToMap(info);
					}
				}
				return true;
			}
		}catch (Exception e){
			logger.error("保存终端心跳注册信息出错",e);
		}
		return  false;
	}

	@Override
	public Object get(Object obj) {
		// TODO Auto-generated method stub
		return  organizationService.selectOrganizationByTid(obj.toString());
	}

}
