package com.ruoyi.broadserver.server.handle.impl;

import com.ruoyi.broad.domain.TerminalTels;
import com.ruoyi.broadserver.global.ProtocolsToClient;
import com.ruoyi.broadserver.server.handle.DefaultCommand;
import org.apache.mina.core.session.IoSession;

import java.util.Date;
import java.util.List;

//读取并写入终端维护电话
public class RW_Tels extends DefaultCommand {
    public RW_Tels(IoSession session, byte[] content) {
        super(session, content);
    }

    @Override
    public byte[] execute() {
        try{
            ;
            String command = save(datainfo)?"1":"0";//保存信息

            String data = get(datainfo).toString();//返回信息

            loggersession();//插入日志
            return returnBytes(ProtocolsToClient.PHONELIST, command, data);
        }catch (Exception e){
            logger.error("终端更新维护授权电话失败"+e);
        }
        return null;
    }

    @Override
    public boolean save(Object obj) {
        try {
            logger.info("获取终端当前维护电话信息："+obj);
            return true;
        } catch (Exception e) {
            logger.error("获取终端维护电话失败：",e);
        }
        return false;
    }

    @Override
    public Object get(Object obj) {
        try {
            if(Tid != null){
                List<TerminalTels>  tellist = organizationService.selectTelsByTid(Tid);
                if(tellist != null){
                    String tels = "";
                    for(int i=0;i<tellist.size();i++){
                        if(i==0) tels += tellist.get(i).getTel().trim() ;
                        else tels += ","+tellist.get(i).getTel().trim()  ;
                    }
                    return tels;
                }else{
                    return datainfo;
                }
            }
        } catch (Exception e) {
            logger.error("获取终端的维护电话出错：",e);
        }
        return datainfo;
    }
}
