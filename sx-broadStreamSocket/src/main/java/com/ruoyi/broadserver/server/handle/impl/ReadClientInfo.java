package com.ruoyi.broadserver.server.handle.impl;


import com.ruoyi.broadserver.global.ProtocolsToClient;
import com.ruoyi.broadserver.server.handle.DefaultCommand;
import org.apache.mina.core.session.IoSession;

//获取终端硬件信息状态
public class ReadClientInfo extends DefaultCommand {

    public ReadClientInfo(IoSession session, byte[] content) {
        super(session, content);
        // TODO Auto-generated constructor stub
    }

    @Override
    public byte[] execute() {
        // TODO Auto-generated method stub
        try{
            //logger.info("终端主动请求获取");
            String command = save(datainfo)?"1":"0";//保存信息

            loggersession();//插入日志


            return returnBytes(ProtocolsToClient.STATU, command, null);
        }catch (Exception e){
            logger.error("解析信息出错",e);
        }
        return  null;
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
