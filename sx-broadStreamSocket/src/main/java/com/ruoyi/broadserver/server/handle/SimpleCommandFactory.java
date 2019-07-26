package com.ruoyi.broadserver.server.handle;

import com.ruoyi.broad.service.IMaintainService;
import com.ruoyi.broadserver.server.MinaCastThread;
import org.apache.mina.core.session.IoSession;
import com.ruoyi.broad.utils.bConvert;
import com.ruoyi.broadserver.global.ProtocolsToClient;
import com.ruoyi.broadserver.server.handle.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class SimpleCommandFactory {
	private static Logger logger = LoggerFactory.getLogger(MinaCastThread.class);
	public DefaultCommand createCommand(IoSession session, byte[] content) {
		if(bConvert.byteToHexString(content[0]).equals(ProtocolsToClient.PACKETHEAD)) {
			DefaultCommand command = null;
			logger.info("收到终端信息："+new String(content));
			switch (bConvert.byteToHexString(content[1])) {//类型判断
				case ProtocolsToClient.IPCHANGE://获取终端IP(读)，并为流媒体心跳包
					command = new ClientHeart_IP(session,content);
					break;
				case ProtocolsToClient.REGISTER://终端命令端口注册登录
					command = new Register(session,content);
					break;
				case ProtocolsToClient.STATU://获取终端硬件信息状态
					command = new ReadClientInfo(session,content);
					break;
				case ProtocolsToClient.OPENSTREAM://启动流媒体传输
					command = new OpenStream(session,content);
					break;
				case ProtocolsToClient.CLOSESTREAM://关闭流媒体传输
					command = new CloseStream(session,content);
					break;
				case ProtocolsToClient.E_FM_RECIVE://获取RDS码(读写)
					command = new RW_RDS(session,content);
					break;
				case ProtocolsToClient.CLIENTREAD://获取终端只读信息
					command = new ReadClientFM(session,content);  
					break;
				case ProtocolsToClient.CELLPOS://获取基站信息
					command = new ReadBS(session,content);
					break;
				case ProtocolsToClient.UPDATELED://LED字幕更新(终端发起)
					command = new ClientLED(session,content);
					break;
				case ProtocolsToClient.GETPARAMATER://物联网终端参数透传接口（终端主动请求获取，端口:8900）
					command = new HeartIOT(session,content);
					break;
				/*case ProtocolsToClient.GETCLIENTDATA://物联网终端参数透传接口 终端回传参数
					command = new ReadIOT(session,content);
					break;*/
				case ProtocolsToClient.POSITION://终端经纬度信息
					command = new ReadGPS(session,content);
					break;
				case ProtocolsToClient.REQUEST://发送终端紧急接收的频率
					command = new SendBand(session,content);
					break;
				case ProtocolsToClient.PROGINFO://统计节目的下载播出，短信播出，重启的次数
					command = new ReadProInfo(session,content);
					break;
				case ProtocolsToClient.BROADCAST://紧急界面播出回执（新建连接）
					command = new BroadCast(session,content);
					break;
				case ProtocolsToClient.VOL://终端设置音量
					command = new RW_VOL(session,content);
					break;
				default:
					break;
			}
			return command;
		}else if(new String(content).contains("aa") && new String(content).contains("cc") || new String(content).contains("AA")&& new String(content).contains("CC")){
			return new ReadIOT(session,content);
		}else {
			return null;
		}
	}
}
