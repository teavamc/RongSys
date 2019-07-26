package com.ruoyi.broadserver.server.handle.impl;

import com.ruoyi.broad.domain.Organization;
import com.ruoyi.broad.utils.bConvert;
import com.ruoyi.broadserver.domain.SocketInfo;
import com.ruoyi.broadserver.global.ProtocolsToClient;
import com.ruoyi.broadserver.server.handle.DefaultCommand;
import org.apache.mina.core.session.IoSession;

import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Register extends DefaultCommand {
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

    public Register(IoSession session, byte[] content) {
        super(session, content);
        // TODO Auto-generated constructor stub
    }

    @Override
    public byte[] execute() {
        // TODO Auto-generated method stub
        try{
            byte[] data = bConvert.subBytes(content, 5, 15);
            String info = new String(data);//获取IMEI号
            String command = save(get(info))?"1":"0";//保存信息
            datainfo = df.format(new Date());//返回当前时间给终端
            loggersession();//插入日志
            return returnBytes(ProtocolsToClient.REGISTER, command, datainfo);
        }catch (Exception e){
            logger.error("终端注册登录失败"+e);
        }
        return null;
    }

    @Override
    public boolean save(Object obj) {
        // TODO 保存终端信息到内存
        try{
            if(obj!= null){
                Organization ter = (Organization)obj;
                SocketInfo info = getSocketInfoByIMEI(ter.getTid());
                if(info!=null) {
                    synchronized (info) {
                        info.setCommandSession(session);
                        info.setIpAddress(((InetSocketAddress) session.getRemoteAddress()).getAddress());
                        info.setType(ter.getTerminaltype());
                    }
                }else{
                    info = new SocketInfo();
                    info.setImei(ter.getTid());
                    info.setIpAddress(((InetSocketAddress) session.getRemoteAddress()).getAddress());
                    info.setCommandSession(session);
                    info.setType(ter.getTerminaltype());
                    putClientToMap(info);
                }
                return true;
            }
        }catch (Exception e){
            logger.error("保存终端注册信息出错",e);
        }
        return  false;
    }

    @Override
    public Object get(Object obj) {//获通过IMEI取终端信息
        // TODO Auto-generated method stub
        return  organizationService.selectOrganizationByTid(obj.toString());
    }
}
