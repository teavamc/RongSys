package com.ruoyi.broadserver.server.handle.impl;


import com.ruoyi.broadserver.global.ProtocolsToClient;
import com.ruoyi.broadserver.server.MinaCastHandler;
import com.ruoyi.broadserver.server.handle.DefaultCommand;
import com.ruoyi.framework.util.SpringUtils;
import com.ruoyi.iot.domain.Torrent;
import com.ruoyi.iot.service.ITorrentService;
import com.ruoyi.iot.service.impl.TorrentServiceImpl;
import org.apache.mina.core.session.IoSession;

import java.net.InetSocketAddress;
import java.util.Date;


//物联网终端参数透传接口 终端回传参数
public class ReadIOT extends DefaultCommand {
	private ITorrentService torrentService = (TorrentServiceImpl) SpringUtils.getBean(TorrentServiceImpl.class);
	public ReadIOT(IoSession session, byte[] content) {
		super(session, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] execute() {
		// TODO Auto-generated method stub
		String[] infos = new String(content).split(",");
		logger.info(new String(content));
		logger.info((String)session.getAttribute(MinaCastHandler.CLIENTINFO));
		save(infos);//保存信息
		loggersession();//插入日志
		
		return null;
	}

	@Override
	public boolean save(Object obj) {
		// TODO Auto-generated method stub
		String[] datas = (String[]) obj;
		Torrent torrent = new Torrent();
		datainfo = "山洪灾害数据获取:	IP:"+((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
		for(int i = 3;i<datas.length;i++) {
			if(datas[i].equals("cc")) {
				break;
			}
			datainfo += "	"+ ProtocolsToClient.TORRENTDATA[(i-3)]+": "+datas[i];
		}
		torrent.setIMEI((String)session.getAttribute(MinaCastHandler.CLIENTINFO));
		torrent.setIP(((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress());
		torrent.setPow1(datas[4]);
		torrent.setGrouppow(datas[3]);
		torrent.setOutv1(datas[5]);
		torrent.setOutv2(datas[6]);
		torrent.setV24(datas[7]);
		torrent.setV28(datas[8]);
		torrent.setExtendpow(datas[9]);
		torrent.setSolarpow(datas[10]);
		torrent.setCharge(datas[11]);
		torrent.setWork(datas[12]);
		torrent.setTime(new Date());
		try {
			torrentService.insertTorrent(torrent);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return false;
	}

	@Override
	public Object get(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
