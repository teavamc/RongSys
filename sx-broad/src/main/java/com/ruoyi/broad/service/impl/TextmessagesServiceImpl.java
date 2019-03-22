package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.typenum;
import com.ruoyi.broad.mapper.TextmessagesMapper;
import com.ruoyi.broad.service.ITextmessagesService;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 获取短信终端类型及数量$
 * @Param: $
 * @return: $
 * @Author: 戴誉琪
 * @Date: $
 */
@Service
public class TextmessagesServiceImpl  implements ITextmessagesService {

    @Autowired
    private TextmessagesMapper textmessagesMapper;
    /**
     * 获取所有类型及数量
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<typenum> selectTypeNum() {
        return textmessagesMapper.selectTypeNum();
    }
}
