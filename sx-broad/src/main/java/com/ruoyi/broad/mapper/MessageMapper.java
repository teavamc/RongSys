package com.ruoyi.broad.mapper;

import com.ruoyi.broad.domain.BroadMessage;

import java.util.List;

/**
 * Created by MI on 2019/3/29.
 */
public interface MessageMapper {

    public List<BroadMessage> selectMessageList(BroadMessage broadMessage);

}
