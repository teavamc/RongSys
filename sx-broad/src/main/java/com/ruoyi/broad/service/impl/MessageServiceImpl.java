package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.dao.DaoSupport;
import com.ruoyi.broad.domain.BroadMessage;
import com.ruoyi.broad.mapper.MessageMapper;
import com.ruoyi.broad.service.IMessageService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MI on 2019/3/29.
 */
@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    MessageMapper messageMapper;

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<Map<String, Object>>  selectMessageList(BroadMessage broadMessage) {
        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        List<BroadMessage> areaList = messageMapper.selectMessageList(broadMessage);
        trees = getTrees(areaList);
        return trees;
    }

    public List<Map<String, Object>> getTrees(List<BroadMessage> broadMessages)
    {

        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        for (BroadMessage broadMessage : broadMessages)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", broadMessage.getAid());
            map.put("pId", broadMessage.getParentaid());
            map.put("name", broadMessage.getAname());
            map.put("title", broadMessage.getAname());
            trees.add(map);
        }
        return trees;
    }
}
