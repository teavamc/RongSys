package com.ruoyi.broadserver.server.handle;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ruoyi.broad.domain.Organization;
import com.ruoyi.broad.service.IOrganizationService;
import com.ruoyi.broad.service.impl.OrganizationServiceImpl;
import com.ruoyi.broadserver.domain.SocketInfo;
import com.ruoyi.broadserver.global.GlobalInfo;
import com.ruoyi.broadserver.server.MinaCastHandler;
import com.ruoyi.broadserver.server.MinaCastThread;
import com.ruoyi.framework.util.SpringUtils;
import com.ruoyi.streamsocket.server.NettyServerHandler;
import org.apache.mina.core.session.IoSession;
import com.ruoyi.broad.utils.bConvert;
import com.ruoyi.broadserver.global.ProtocolsToClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class DefaultCommand implements Command{
	private static Map<String, SocketInfo> IMEI_SocketInfo = new HashMap<>();//终端IMEI与其对应信息
	protected static final Logger logger = LoggerFactory.getLogger(DefaultCommand.class);
	protected static IOrganizationService organizationService = (OrganizationServiceImpl) SpringUtils.getBean(OrganizationServiceImpl.class);
    //private SessionManager sessionservice = (SessionService) SpringContextUtils.getBeanByClass(SessionService.class);
    
	protected IoSession session;
	protected byte[] content;
	protected String datainfo = null;
	
	
	public DefaultCommand(IoSession session, byte[] content) {
		this.session = session;
		this.content = content;
	}

	//默认调用返回的格式
	protected byte[] returnBytes(String type,String command,String data) {//data可能为null
		byte[] checkData = new byte[(data!= null?data.length():0)+3];//用来计算校验和
		ByteBuffer encoded = ByteBuffer.allocate(data.length()+20);
		encoded.put(bConvert.hexStringToBytes(ProtocolsToClient.PACKETHEAD));//发包的数据头
		encoded.put(bConvert.hexStringToBytes(type));//发包的类型
		byte[] length = bConvert.intToByteArray(2+(data!= null?data.length():0));
		System.arraycopy(length, 0, checkData, 0, length.length);
		checkData[2] = (byte)Integer.parseInt(command);
		if(data != null)
			System.arraycopy(data.getBytes(), 0, checkData, 3, data.getBytes().length);
		String check = bConvert.checksum(checkData);
		encoded.put(length);//发包的数据长度 命令1字节+data长度+校验1字节
		encoded.put(bConvert.hexStringToBytes(command));//发包命令
		if(data != null)encoded.put(data.getBytes());//发包数据
		encoded.put(bConvert.hexStringToBytes(check)[0]);//发包的校验
		encoded.put(bConvert.hexStringToBytes(ProtocolsToClient.ENDCHECK));//发包的结尾
		encoded.flip();
		byte[] bs = new byte[encoded.remaining()];
		encoded.get(bs);
		encoded.clear();
		return bs;
	}
	//发文件的返回格式
	protected byte[] returnFile(String type,String command,String data) {//data可能为null
		/*ByteBuffer encoded = ByteBuffer.allocate(data.length()+20);
		encoded.put(bConvert.hexStringToBytes(ProtocolsToClient.PACKETHEAD));//发包的数据头
		encoded.put(bConvert.hexStringToBytes(type));//发包的类型
		encoded.put(bConvert.intToByteArray(command.length()+(data!= null?data.length():0)));//发包的数据长度
		encoded.put(bConvert.hexStringToBytes(command));//发包命令
		if(data != null)encoded.put(data.getBytes());//发包数据
		encoded.put(bConvert.hexStringToBytes(ProtocolsToClient.CHECKCODE+ProtocolsToClient.ENDCHECK));//发包的校验以及结尾
		encoded.flip();
		byte[] bs = new byte[encoded.remaining()];
		encoded.get(bs);
		encoded.clear();
		return bs;*/
		return null;
	}
	//插入日志
	protected void loggersession() {
		GlobalInfo.putThreadintoPool(new Runnable() {
			@Override
			public void run() {
				if(datainfo != null && !datainfo.equals("")) {
					//do sth
				/*Session mysession = new Session();
				mysession.setSessiondata(datainfo);
				mysession.setSessiondate(new Date());
				mysession.setSessionuser(ProtocolsToClient.SESSIONCLIENT);
				try {
					sessionservice.saveSession(mysession);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				}

			}
		});
	}
	/*保存终端最后通信时间*/
	protected void setTime(){
		try{
			if(session.getAttribute(MinaCastHandler.CLIENTINFO) != null) {
				SocketInfo selfInfo = getSocketInfoByIMEI(session.getAttribute(MinaCastHandler.CLIENTINFO).toString());
				if (selfInfo != null) {
					synchronized (selfInfo) {
						selfInfo.setLastTime(new Date());//存储最后通信时间
					}
				}
			}
		}catch (Exception e){
			logger.error("保存通信时间出错:",e);
		}
	}

	/**
	 * 将终端加入Map中运行
	 * @param info
	 */
	public static void putClientToMap(SocketInfo info){
		synchronized (IMEI_SocketInfo){
			if(!IMEI_SocketInfo.get(info.getImei()).equals(info)){
				IMEI_SocketInfo.put(info.getImei(),info);
			}
		}
	}
	public static SocketInfo getSocketInfoByIMEI(String IMEI){
		return IMEI_SocketInfo.get(IMEI);
	}

	public static Map<String, SocketInfo> getIMEI_SocketInfo() {
		return IMEI_SocketInfo;
	}

}
