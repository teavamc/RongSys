package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.typenum;
import com.ruoyi.broad.domain.Textmessages;

import java.util.List;
/**
 * 短信号码获取
 *
 * @author 戴誉琪
 * @date 2019-03-22
 */
public interface ITextmessagesService {
    /**
     * 获取所有类型及数量
     * @return
     */
    public List<typenum> selectTypeNum();
    public List<Textmessages> selectTextMessages();
}
