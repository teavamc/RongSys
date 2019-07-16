package com.ruoyi.broadserver.server.handle.impl;


import com.ruoyi.broadserver.server.MinaCastHandler;
import com.ruoyi.broadserver.server.MinaCastThread;
import com.ruoyi.broadserver.server.handle.DefaultCommand;
import org.apache.mina.core.session.IoSession;


//物联网终端参数透传接口 终端回传参数
public class ReadIOT extends DefaultCommand {
    //private TorrentManager torrentservice = (TorrentService) SpringContextUtils.getBeanByClass(TorrentService.class);
    //private ClientManager clientservice = (ClientService) SpringContextUtils.getBeanByClass(ClientService.class);
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
		/*Torrent torrent = new Torrent();
		datainfo = "山洪灾害数据获取:	IP:"+((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
		for(int i = 3;i<datas.length;i++) {
			if(datas[i].equals("cc")) {
				break;
			}
			datainfo += "	"+ProtocolsToClient.TORRENTDATA[(i-3)]+": "+datas[i];
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
			torrentservice.saveTorrent(torrent);
			Client client = clientservice.getClient((String)session.getAttribute(MinaCastHandler.CLIENTINFO));
			if(client != null && client.getIMEI() != null) {
				client.setIP(((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress());
				client.setPow1(datas[4]);
				client.setGrouppow(datas[3]);
				client.setOutv1(datas[5]);
				client.setOutv2(datas[6]);
				client.setV24(datas[7]);
				client.setV28(datas[8]);
				client.setExtendpow(datas[9]);
				client.setSolarpow(datas[10]);
				client.setCharge(datas[11]);
				client.setWork(datas[12]);
				client.setIsregister(true);
				client.setFinallogindate(new Date());
				clientservice.updateClient(client);
			}else {
				client = new Client();
				client.setIMEI((String)session.getAttribute(MinaCastHandler.CLIENTINFO));
				client.setIP(((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress());
				client.setPow1(datas[4]);
				client.setGrouppow(datas[3]);
				client.setOutv1(datas[5]);
				client.setOutv2(datas[6]);
				client.setV24(datas[7]);
				client.setV28(datas[8]);
				client.setExtendpow(datas[9]);
				client.setSolarpow(datas[10]);
				client.setCharge(datas[11]);
				client.setWork(datas[12]);
				client.setIsregister(true);
				client.setFinallogindate(new Date());
				client.setCreatdate(new Date());
				client.setClientname((String)session.getAttribute(MinaCastHandler.CLIENTINFO));
				clientservice.saveUser(client);
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}*/
		return false;
	}

	@Override
	public Object get(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
