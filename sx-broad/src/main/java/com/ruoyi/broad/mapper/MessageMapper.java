package com.ruoyi.broad.mapper;

import com.ruoyi.broad.domain.BroadMessage;
import com.ruoyi.broad.domain.MessageExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MI on 2019/3/29.
 */
@Repository
public interface MessageMapper {

    public List<BroadMessage> selectMessageList(BroadMessage broadMessage);

    public List<MessageExample> selectMessageExampleList();

}
