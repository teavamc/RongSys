package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.BroadMessage;

import java.util.List;
import java.util.Map;

/**
 * Created by MI on 2019/3/29.
 */
public interface IMessageService {

    public List<Map<String, Object>>  selectMessageList(BroadMessage broadMessage);
}
